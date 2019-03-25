package com.kierigby.bountyhunter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.bountyhunterapi.BountyHunterAPI;
import com.example.bountyhunterapi.RetrofitClientInstance;
import com.example.bountyhunterapi.User;

public class MainActivity extends AppCompatActivity {

    private Button mLoginButton, mRegisterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotten_pass);

    }

    @Override
    protected void onStart() {
        super.onStart();
        BountyHunterAPI api = new BountyHunterAPI(getApplicationContext());
        //api.registerUser("Khalil","Russell","khalilruss","khalilruss@live.com","123456");
        //api.loginUser("khalilruss","123456");
        //((GlobalUser) getApplication()).setLoggedInUser( api.loginUser("testuser1","test"));
       // ((GlobalUser) getApplication()).setLoggedInUser( api.loginUser("khalilruss","123456"));
        //api.resetPasswordRequest("khalilruss@live.com");

    }
}
