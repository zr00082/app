package com.kierigby.bountyhunter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.bountyhunterapi.BountyHunterAPI;
import com.example.bountyhunterapi.RetrofitClientInstance;

public class MainActivity extends AppCompatActivity {

    private Button mLoginButton, mRegisterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BountyHunterAPI api = new BountyHunterAPI(getApplicationContext());
        api.searchUser("test user");


    }

}
