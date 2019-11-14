package com.example.retrofit2test001;

import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetroService {
    String URL = "https://apis.tracker.delivery";
    String URL1 = "https://apis.tracker.delivery/carriers";


    @GET("/carriers")
    Call<List<Data>> getListData();

    @GET("/carriers")
    Call<List<Data>> getDataAll(@Query("id") String id);

    @GET("/carriers")
    Call<Data> getData(@Path("id") String id);


    @GET("/carriers")
    Call<List<Data>> getData2(@Query("name") String name);

    //@GET("/carriers/kr.cjlogistics/tracks/625646311801")
    //Call<List<Data>> getData3(@);
}
