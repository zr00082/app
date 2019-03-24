package com.example.bountyhunterapi;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    @FormUrlEncoded
    @POST("/users/")
    Call<Void>registerUser(@Field("firstName") String firstName, @Field("lastName") String lastName,@Field("username") String username, @Field("email") String email,@Field("password") String password);

    @FormUrlEncoded
    @POST("/users/login")
    Call<Token>loginUser(@Field("username") String username, @Field("password") String password);

    //Creates the GET request that will be sent to request the JSON data
    @GET("/users/{id}")
    Call<User> getUser(@Header("Authorization") String authKey, @Path("id") UUID userID);

    @GET("/users/me")
    Call<User> getLoggedInUser(@Header("Authorization") String authKey);

    @PUT("/users/{id}")
    Call<User> updateUser(@Header("Authorization") String authKey, @Path("id") UUID userID, @Body User updateInfo);

    @FormUrlEncoded
    @DELETE("/users/{id}")
    Call<Void> deleteUser(@Header("Authorization") String authKey,@Path("id") UUID userID,@Field("password") String password);

    @GET("/users/search/{username}")
    Call<UserList> searchUser(@Header("Authorization") String authKey,@Path("username") String username);

    @FormUrlEncoded
    @PATCH("/users/resetpassword")
    Call<Void> resetPasswordRequest( @Field("email") String email);

    @FormUrlEncoded
    @POST("/users/resetpassword/{token}")
    Call<Void> resetPassword(@Path("token") String token,@Field("newpassword") String newPassword);
}