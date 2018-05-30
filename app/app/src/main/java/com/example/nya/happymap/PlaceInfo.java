package com.example.nya.happymap;

import android.provider.ContactsContract;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.widget.TextView;


import com.squareup.picasso.Picasso;


public class PlaceInfo extends AppCompatActivity {

    private android.widget.ImageView placeImageView;
    private TextView placeNameTextView;
    private TextView placeCommentsTextView;
    private TextView placeAddressTextView;
    private TextView placeDescriptionTextView;


    private RecyclerView commentRecyclerView;
    private static CommentsAdapter adapter;

    final String TAG = "myLogs";

    public int id;
    public double lat;
    public double log;
    public List<Image> photos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_info);

        Intent intent = getIntent();
        if (intent.hasExtra("ID")){
            id = getIntent().getExtras().getInt("ID");
            initRecyclerView();

            getPlaceById(id);
        }
        else{

            //int id = getIntent().getExtras().getInt("ID");
            //getPlaceById(id);
        }
    }

    private void getPlaceById(int id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        //Call<Place> call = api.getPlaceById(id);

        Call<Place> call = api.getTestPlace();

        call.enqueue(new Callback<Place>() {
            @Override
            public void onResponse(Call<Place> call, Response<Place> response) {
                if (response.isSuccessful()) {
                    // запрос успешно обработан

                    placeImageView = (ImageView) findViewById(R.id.placeImage);
                    placeNameTextView = (TextView) findViewById(R.id.textPlaceName);

                    placeAddressTextView = (TextView) findViewById(R.id.textPlaceAddress);
                    placeDescriptionTextView = (TextView) findViewById(R.id.textPlaceDescription);

                    Place place = response.body();
                    placeNameTextView.setText(place.getName().toString());

                    placeAddressTextView.setText(place.getContacts().toString());

                    placeDescriptionTextView.setText(place.getDescription().toString());

                    Picasso.with(PlaceInfo.this)
                            .load(response.body().getPhotos().get(0).getImagePath().toString()).into(placeImageView);

                    if (place.getComments() != null){
                        adapter.setItems(place.getComments());
                    }

                    lat = place.getLat();
                    log = place.getLog();
                    photos = new ArrayList<Image>(response.body().getPhotos());

                }
                // сервер вернул ошибку
                else {
                     Log.d (TAG, "response.code()");
                }
            }

            // ошибка (сервер :()
            @Override
            public void onFailure(Call<Place> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                // log("failure " + t);
            }

        });
    }

    //показать место на карте
    public void showMap(View v){
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("ID", id);
        intent.putExtra("lat", lat);
        intent.putExtra("log", log);
        intent.putExtra("name", placeNameTextView.getText().toString());
        intent.putExtra("image", photos.get(0).getImagePath().toString());
        intent.putExtra("imageID", photos.get(0).getImageId());
        startActivity(intent);
    }

    private void initRecyclerView() {
       commentRecyclerView = (RecyclerView) findViewById(R.id.recycle_view_comments);
        commentRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CommentsAdapter(this);
        commentRecyclerView.setAdapter(adapter);
    }
}


