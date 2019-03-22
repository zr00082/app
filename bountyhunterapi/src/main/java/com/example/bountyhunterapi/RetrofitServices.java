package com.example.bountyhunterapi;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Interface that defines the HTTP operations that will be used by retrofit.
 * Retrofit will automatically generate the body of the declared methods
 */
public interface RetrofitServices {

    //Creates the 'fire and forget' GET request that will be used to send the analytics
    @POST("/users/")
    Call<Void>registerUser(@Body String user);

    @POST("/users/login")
    Call<Void>loginUser(@Body Map<String,String> loginInfo);

    //Creates the GET request that will be sent to request the JSON data
    @GET("/users/:{id}")
    Call<User> getUser(@Path("id") int userID);

    @PUT("/users/:{id}")
    Call<Void> updateUser(@Path("id") int userID, @Body Map<String,String> updateInfo);

    @DELETE("/users/:{id}")
    Call<Void> deleteUser(@Path("id") int userID);

    @GET("/users/search/:{username}")
    Call<Void> searchUser(@Path("id") String username);


}