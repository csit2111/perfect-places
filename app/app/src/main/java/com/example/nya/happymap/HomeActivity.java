package com.example.nya.happymap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_home);
        super.onCreate(savedInstanceState);
    }

    //Список мест
    public void showPlaceList(View view){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
    }

    //Все места на карте
    public void showMapAll(View view){
        Intent intent = new Intent(this, MapAllActivity.class);
        startActivity(intent);
    }

}
