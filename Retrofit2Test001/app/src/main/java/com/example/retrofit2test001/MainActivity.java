package com.example.retrofit2test001;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetroService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetroService retroservice = retrofit.create(RetroService.class);

        Call<Data> datas = retroservice.getData("de.dhl");
        Log.d("TEsT","Start1");

        datas.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {
                Data body = response.body();

                Log.d("TEST",body.getName()+"Name");
            }

            @Override
            public void onFailure(@NonNull Call<Data> call, @NonNull Throwable t) {

            }
        });

    }
}
