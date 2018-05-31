package com.example.nya.happymap;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker mMarker;

    private Place place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Region region = new Region(64, "Саратовская область");
        Type type = new Type (1, "Культура");
        Tag tag = new Tag(1, "скверы", type);
        ArrayList<Comment> comm = new ArrayList<>();
        ArrayList<Image> photos = new ArrayList<>();
        photos.add(new Image(1, "https://turisticum.ru/img/saratov_1/881_2.jpg"));
        place = new Place(0, "Проспект Мирова","Это центр нашей Вселенной. С него всё началось и в нём всё закончится!",
                region, tag, 51.5332, 46.0192, "ул. Кирова, д. 8", "", comm, photos);


        Intent intent = getIntent();
        if (intent.hasExtra("lat") && intent.hasExtra("log")) {
            place.setLt(intent.getExtras().getDouble("lat"));
            place.setLg(intent.getExtras().getDouble("log"));
            place.addPhoto(new Image(intent.getExtras().getInt("imageID"), intent.getExtras().getString("image")));
            place.setName(intent.getExtras().getString("name"));
            place.setId(intent.getExtras().getShort("ID"));


            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(googleMap.MAP_TYPE_TERRAIN);

        LatLng coordinats = new LatLng( place.getLat(),place.getLog());

        CameraPosition cameraPosition = new CameraPosition.Builder()
               .target(coordinats)
                .zoom(13)
                .bearing(90)
                .tilt(30)
                .build();


        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        MarkerOptions options = new MarkerOptions();
        options.position(coordinats)
                .title(place.getName().toString());

        mMarker = mMap.addMarker(options);
    }

}
