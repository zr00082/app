package com.kierigby.bountyhunter;

import android.app.Application;

import com.example.bountyhunterapi.BountyHunterAPI;
import com.example.bountyhunterapi.User;

public class GlobalUser extends Application {
    User loggedInUser;
    BountyHunterAPI api;

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public User getLoggedInUser() {
        return this.loggedInUser;
    }

    public void logoutUser() {
        this.loggedInUser = null;
        api=new BountyHunterAPI(this);
        api.clearToken();
    }

    public boolean tokenCheck() {
        final boolean[] validToken = new boolean[1];
        api = new BountyHunterAPI(this);
        api.getUser(loggedInUser.getId(), new BountyHunterAPI.TokenCheckCallBack() {
            @Override
            public void tokenCheck(int code) {
                if(code==200){
                    validToken[0] =false;
                }else {
                    validToken[0]=true;
                }
            }
        });
        return validToken[0];
    }
}
