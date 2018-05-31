package com.example.nya.happymap;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;


public class MainActivity extends AppCompatActivity {

    private RecyclerView placeRecyclerView;
    private static PlaceAdapter adapter;


    //private List<Place> placesList = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            initRecyclerView();
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
                    adapter.setItems(places);
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


    private void initRecyclerView() {
        placeRecyclerView = (RecyclerView) findViewById(R.id.posts_recycle_view);
        placeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PlaceAdapter(this);
        placeRecyclerView.setAdapter(adapter);
    }
}