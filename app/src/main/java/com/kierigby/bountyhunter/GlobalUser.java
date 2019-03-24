package com.kierigby.bountyhunter;

import android.app.Activity;

import com.example.bountyhunterapi.User;

public class GlobalUser extends Activity {
    User loggedInUser;

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
