package com.kierigby.bountyhunter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.bountyhunterapi.BountyHunterAPI;

public class MainActivity extends AppCompatActivity {

    private Button mLoginButton, mRegisterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void LoginUser(String username, String password){
        BountyHunterAPI api= new BountyHunterAPI();
        api.getUser(username,password);
    }
}
