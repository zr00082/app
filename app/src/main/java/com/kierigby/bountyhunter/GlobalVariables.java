package com.kierigby.bountyhunter;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class GlobalVariables extends Application {
    private User logginedUser;
    private InternetConnectionListener mInternetConnectionListener;

    public void setLogginedUser(User logginedUser) {
        this.logginedUser = logginedUser;
    }

    public void setInternetConnectionListener(InternetConnectionListener listener) {
        mInternetConnectionListener = listener;
    }

    public void removeInternetConnectionListener() {
        mInternetConnectionListener = null;
    }

}
