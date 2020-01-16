package com.example.restapitest001;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

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

        String carriername = "kr.epost"; //택배사 이름
        String tracknumberedit = "1111111111"; //송장번

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://apis.tracker.delivery")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final Retroservice retroService = retrofit.create(Retroservice.class);

        Call<Data> dataP = retroService.trackingData(carriername, tracknumberedit);

        dataP.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {

                Data user = response.body();

                Log.d("TEST",user.getId());
                Log.d("TEST",user.getName());
                Log.d("TEST",user.getTel());

                for(int i = 0; i < user.progress.size();i++){

                }

            }

            @Override
            public void onFailure(@NonNull Call<Data> call, @NonNull Throwable t) {
                Log.d("TESt", "Failure");
            }
        });
    }
}
