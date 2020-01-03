package com.example.restapitest001;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Retroservice {
    @GET("/carriers/kr.epost/tracks/6077111895704")
    Call<Data> listData();

    @GET("/carriers/kr.epost/tracks/6077111895704")
    Call<List<Data>> listDatas();

    @GET("/carriers/{track_id}/tracks/{track_number}")
    Call<Data> trackingData(@Path("track_id") String track_id, @Path("track_number") String track_number);

    @GET("/carriers")
    Call<List<Data>> getCarriers();
}
