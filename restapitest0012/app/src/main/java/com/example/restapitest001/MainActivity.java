package com.example.restapitest001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://apis.tracker.delivery")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final Retroservice retroService = retrofit.create(Retroservice.class);
    }
}
