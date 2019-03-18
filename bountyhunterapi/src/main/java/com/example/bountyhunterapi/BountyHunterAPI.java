package com.example.bountyhunterapi;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BountyHunterAPI {

    public void getUser(String username, String password){
        RetrofitServices service =RetrofitClientInstance.getRetrofitInstance().create(RetrofitServices.class);
        Call<Void> call = service.getUser(username,password);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(!response.isSuccessful()){
                    Log.d("Response code", String.valueOf(response.code()));
                    return;
                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    public void registerUser(String username, String password){
        RetrofitServices service =RetrofitClientInstance.getRetrofitInstance().create(RetrofitServices.class);
        Call<Void> call = service.registerUser(username,password);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(!response.isSuccessful()){
                    Log.d("Response code", String.valueOf(response.code()));
                    return;
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

}
