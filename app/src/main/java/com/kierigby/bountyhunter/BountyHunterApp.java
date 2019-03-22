package com.kierigby.bountyhunter;

import android.app.Application;

import com.example.bountyhunterapi.User;

public class BountyHunterApp extends Application {
    private User logginedUser;


    public void setLogginedUser(User logginedUser) {
        this.logginedUser = logginedUser;
    }
}
