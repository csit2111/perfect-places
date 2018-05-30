package com.example.nya.happymap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.media.session.MediaControllerCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapAllActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_all);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        context = this;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //CustomInfoWindowGoogleMap adapter = new CustomInfoWindowGoogleMap(this);
        //mMap.setInfoWindowAdapter(adapter);



        //mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
          //  @Override
            //  public void onInfoWindowClick(Marker marker) {

//                Intent intent = new Intent(context, PlaceInfo.class);
  //                startActivity(intent);

    //                Place place = (Place) marker.getTag();
      //              int id = place.getId();
        //             intent.putExtra("ID", id);
          //            startActivity(intent);};});

        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                View view = ((Activity)context).getLayoutInflater()
                        .inflate(R.layout.custom_infowindow, null);

                TextView name_place = (TextView) view.findViewById(R.id.name);
                ImageView picture_place = (ImageView) view.findViewById(R.id.picture);


                //name_place.setText(marker.getTitle());


                Place place = (Place)marker.getTag();
                name_place.setText(place.getName());

                String placePhotoUrl = place.getPhotos().get(0).getImagePath().toString();

                if (placePhotoUrl!= null) {
                    Picasso.with(picture_place.getContext()).load(placePhotoUrl).into(picture_place);
                }
                else{

                }

                mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(Marker marker) {

                       Intent intent = new Intent(context, PlaceInfo.class);

                        Place place = (Place) marker.getTag();
                        int id = place.getId();
                        intent.putExtra("ID", id);
                        startActivity(intent);};});

                return view;
            }
        });

        LatLng coordinats = new LatLng(51.5332, 46.0192);

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(coordinats)
                .zoom(13)
                .bearing(90)
                .tilt(30)
                .build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        getListPlace();
    }

    private void getListPlace() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<Place>> call = api.getPlaces();

        call.enqueue(new Callback<List<Place>>() {
            @Override
            public void onResponse(Call<List<Place>> call, Response<List<Place>> response) {
                if (response.isSuccessful()) {
                    // запрос успешно обработан
                    List<Place> places = response.body();
                    showPlaces(places);
                }
                // сервер вернул ошибку
                else {
                    //log ("response code " + response.code());
                }
            }
            // ошибка (сервер :()
            @Override
            public void onFailure(Call<List<Place>> call, Throwable t) {
                // log("failure " + t);
            }
        });
    }

    private void showPlaces( List<Place> places) {

        List<Marker> markers = new ArrayList<>();
        Marker marker;

        for(int i = 0; i < places.size(); i++){
            LatLng coordinats = places.get(i).getPosition();

            marker = mMap.addMarker(new MarkerOptions()
                    .position(coordinats));
            marker.setTag(places.get(i));
            markers.add(marker);
        }
    }
}
