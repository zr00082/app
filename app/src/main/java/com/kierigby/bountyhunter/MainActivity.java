package com.kierigby.bountyhunter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.bountyhunterapi.BountyHunterAPI;

public class MainActivity extends AppCompatActivity implements InternetConnectionListener {

    private Button mLoginButton, mRegisterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BountyHunterAPI api = new BountyHunterAPI();

    }

    @Override
    public void onInternetUnavailable() {

    }

    @Override
    public void onCacheUnavailable() {

    }
}
