package com.example.bountyhunterapi;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public abstract class NetworkConnectionInterceptor implements Interceptor {

    public abstract boolean isInternetAvailable();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!isInternetAvailable()) {
           throw new IOException();
        }
        return chain.proceed(request);
    }
}