package com.example.bountyhunterapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Interface that defines the HTTP operations that will be used by retrofit.
 * Retrofit will automatically generate the body of the declared methods
 */
public interface RetrofitServices {

    //Creates the GET request that will be sent to request the JSON data
    @GET("data.json")
    Call<Void> getFruits();

    //Creates the 'fire and forget' GET request that will be used to send the analytics
    @GET("stats")
    Call<Void>sendData(@Query("event")String event,@Query("data")Long time);
}