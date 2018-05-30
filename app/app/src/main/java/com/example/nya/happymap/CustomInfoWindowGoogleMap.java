package com.example.nya.happymap;

import com.google.android.gms.maps.GoogleMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.squareup.picasso.Picasso;


public class CustomInfoWindowGoogleMap implements GoogleMap.InfoWindowAdapter {

    private Context context ;

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

        Place place = (Place)marker.getTag();
        name_place.setText(place.getName());

        String placePhotoUrl = place.getPhotos().get(0).getImagePath().toString();

        if (placePhotoUrl!= null) {
            Picasso.with(context).load(placePhotoUrl).into(picture_place);

            Toast.makeText(context, placePhotoUrl, Toast.LENGTH_SHORT).show();
        }
        else{

        }

        return view;
    }
}
