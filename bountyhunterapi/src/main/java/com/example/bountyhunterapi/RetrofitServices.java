package com.example.bountyhunterapi;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
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
    Call<Void>registerUser(@Body User newUser);

    @FormUrlEncoded
    @POST("/users/login")
    Call<Token>loginUser(@Field("username") String username, @Field("password") String password);

    //Creates the GET request that will be sent to request the JSON data
    @GET("/users/:{id}")
    Call<User> getUser(@Header("Authorization") String authKey, @Path("id") int userID);

    @PUT("/users/:{id}")
    Call<User> updateUser(@Header("Authorization") String authKey, @Path("id") int userID, @Body User updateInfo);

    @DELETE("/users/:{id}")
    Call<Void> deleteUser(@Header("Authorization") String authKey,@Path("id") int userID);

    @GET("/users/search/:{username}")
    Call<UserList> searchUser(@Header("Authorization") String authKey,@Path("id") String username);

    @PATCH("/users/resetpassword/:{id}")
    Call<User> resetPassword(@Header("Authorization") String authKey,@Path("id") int userID);
}