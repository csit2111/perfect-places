package com.example.nya.happymap;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "https://trello-attachments.s3.amazonaws.com/";
    //String BASE_URL = "localhost:8080";

    @GET("5a87db2c82f875e0ef000219/5aecb3a0d6d797dce75df5b2/9e59b7e12e9b2aaa50d095da6aee45a2/Place.json")
    Call<Place> getTestPlace();

    //@GET("/places")
    @GET("/5a87db2c82f875e0ef000219/5aecb3a0d6d797dce75df5b2/a9e9a2147b7a0504cb6f8869111010f6/AllPlaces.json")
    Call<List<Place>> getPlaces();

    @GET("/place/{category}")
    Call<List<Category>> getCategoriesList(@Query("tagId") int tagId);

    @GET("/places/{id}")
    Call<Place> getPlaceById(@Path("id") int id);
}
