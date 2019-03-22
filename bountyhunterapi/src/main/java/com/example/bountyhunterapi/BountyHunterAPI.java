package com.example.bountyhunterapi;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BountyHunterAPI {

    public void getUser(int userID, final Context context) {
        RetrofitServices service = RetrofitClientInstance.getRetrofitInstance(context).create(RetrofitServices.class);
        Call<Void> call = service.getUser(userID);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() == 200) {
                    Toast.makeText(context, "User account was found", Toast.LENGTH_LONG);
                    return;
                } else if (response.code() == 404) {
                    Toast.makeText(context, "Could not find the user account with the specified username \n Please try again", Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(context, "Failed to connect to the server \n Please check the internet connection of your device", Toast.LENGTH_LONG);
            }
        });
    }


    public void deleteUser(int userID, final Context context) {
        RetrofitServices service = RetrofitClientInstance.getRetrofitInstance(context).create(RetrofitServices.class);

        Call<Void> call = service.deleteUser(userID);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() == 204) {
                    Toast.makeText(context, "Your account was successfully deleted", Toast.LENGTH_LONG);
                    return;
                } else if (response.code() == 500) {
                    Toast.makeText(context, "An error occurred when trying to delete account \n Please try again", Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(context, "Failed to connect to the server \n Please check the internet connection of your device", Toast.LENGTH_LONG);
            }
        });

    }

    public void searchUser(String username, final Context context) {
        RetrofitServices service = RetrofitClientInstance.getRetrofitInstance(context).create(RetrofitServices.class);
        Call<Void> call = service.searchUser(username);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() == 200) {
                    Toast.makeText(context, "User account was found", Toast.LENGTH_LONG);
                    return;
                } else if (response.code() == 404) {
                    Toast.makeText(context, "Could not find the user account with the specified username \n Please try again", Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(context, "Failed to connect to the server \n Please check the internet connection of your device", Toast.LENGTH_LONG);
            }
        });
    }

    public void registerUser(String user, final Context context) {
        RetrofitServices service = RetrofitClientInstance.getRetrofitInstance(context).create(RetrofitServices.class);
        Call<Void> call = service.registerUser(user);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() == 201) {
                    Toast.makeText(context, "Your account was successfully registered", Toast.LENGTH_LONG);
                    return;
                } else if (response.code() == 500) {
                    Toast.makeText(context, "An error occurred when trying to register your account \n Please try again", Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(context, "Failed to connect to the server \n Please check the internet connection of your device", Toast.LENGTH_LONG);
            }
        });
    }
}
