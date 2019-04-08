package com.kierigby.bountyhunter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bountyhunterapi.Token;

public class LoggedInActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        addListenerToProfileImageView();
        addListenerToLogoutImageView();
        addListenerToMyFriendsTextView();
        addListenerToGameHistoryTextView();
        Toast.makeText(getApplicationContext(), String.valueOf(((GlobalUser) this.getApplication()).tokenCheck()), Toast.LENGTH_SHORT).show();
    }

    private void addListenerToProfileImageView() {
        ImageView profileImageView = findViewById(R.id.profileImageView);

        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profileI = new Intent(LoggedInActivity.this, EditProfileActivity.class);
                startActivity(profileI);
            }
        });

    }

    private void addListenterToNotificationsImageView() {
        ImageView notificationsImageView = findViewById(R.id.notificationsImageView);

        notificationsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent notificationsI = new Intent(LoggedInActivity.this, EditProfileActivity.class);
                startActivity(notificationsI);
            }
        });

    }

    private void addListenerToLogoutImageView() {
        ImageView logOutImageView = findViewById(R.id.logoutImageView);

        logOutImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((GlobalUser) getApplication()).logoutUser();
                Intent logoutI = new Intent(LoggedInActivity.this, MainActivity.class);
                startActivity(logoutI);
            }
        });

    }

    private void addListenerToCreateGameTextView() {
        TextView createGameTextView = findViewById(R.id.tvCreateGame);

        createGameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void addListenerToGameHistoryTextView() {
        TextView gameHistoryTextView = findViewById(R.id.tvGameHistory);

        gameHistoryTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent statsI = new Intent(LoggedInActivity.this, StatsActivity.class);
                startActivity(statsI);
            }
        });
    }

    private void addListenerToGameRulesTextView() {
        TextView gameRulesTextView = findViewById(R.id.tvGameRules);

        gameRulesTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    private void addListenerToMyFriendsTextView() {
        TextView myFriendsTextView = findViewById(R.id.tvMyFriends);

        myFriendsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent friendsI = new Intent(LoggedInActivity.this, MyFriendsActivity.class);
                startActivity(friendsI);
            }
        });


    }

}
