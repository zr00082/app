package com.kierigby.bountyhunter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LoggedInActivity extends AppCompatActivity {

    private ImageView profileImageView, notificationsImageView, logOutImageView;
    private TextView createGameTextView, gameHistoryTextView, gameRulesTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        addListenerToProfileImageView();
        addListenerToLogoutImageView();
    }

    private void addListenerToProfileImageView() {
        profileImageView = findViewById(R.id.profileImageView);

        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profileI = new Intent(LoggedInActivity.this, EditProfileActivity.class);
                startActivity(profileI);
            }
        });

    }

    private void addListenterToNotificationsImageView() {
        notificationsImageView = findViewById(R.id.notificationsImageView);

        notificationsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent notificationsI = new Intent(LoggedInActivity.this, EditProfileActivity.class);
                startActivity(notificationsI);
            }
        });

    }

    private void addListenerToLogoutImageView() {
        logOutImageView = findViewById(R.id.logoutImageView);

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
        createGameTextView = findViewById(R.id.tvCreateGame);

        createGameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void addListenerToGameHistoryTextView() {
    gameHistoryTextView=findViewById(R.id.tvGameHistory);

    gameHistoryTextView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });
    }

    private void addListenerToGameRulesTextView() {
    gameRulesTextView=findViewById(R.id.tvGameRules);

    gameRulesTextView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });


    }
}
