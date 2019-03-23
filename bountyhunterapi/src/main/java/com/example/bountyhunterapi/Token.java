package com.example.bountyhunterapi;

import com.google.gson.annotations.SerializedName;

public class Token {
@SerializedName("token")
    private String token;

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
