package com.kierigby.bountyhunter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.example.bountyhunterapi.BountyHunterAPI;

public class NewPasswordActivity extends AppCompatActivity {
    private EditText mNewPasswordInput, mConfirmNewPasswordInput;
    private BountyHunterAPI api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);
        api= new BountyHunterAPI(this);
        addListenerToNewPasswordButton();
        addListenerToBackButton();

    }

    public void addListenerToNewPasswordButton() {
        mNewPasswordInput = findViewById(R.id.etNewPassword);
        mConfirmNewPasswordInput = findViewById(R.id.etConfirmNewPassword);
        Button mNewPasswordBtn = findViewById(R.id.btSubmit);

        mNewPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mNewPasswordInput.getText().toString().isEmpty() || mConfirmNewPasswordInput.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter all the necessary information", Toast.LENGTH_LONG).show();
                } else if (!mNewPasswordInput.getText().toString().equals(mConfirmNewPasswordInput.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "The passwords you entered do not match", Toast.LENGTH_LONG).show();
                } else {
                    api.resetPassoword(getToken(), mConfirmNewPasswordInput.getText().toString());
                    NavUtils.navigateUpFromSameTask(NewPasswordActivity.this);
                }
            }
        });


    }

    public void addListenerToBackButton() {
        ImageButton mBackArrow = findViewById(R.id.backFromSetNewPass);
        mBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToMainPage = new Intent(NewPasswordActivity.this, MainActivity.class);
                startActivity(backToMainPage);


            }
        });
    }

    public String getToken() {
        Intent deepLinkI = getIntent();
        String token = deepLinkI.getData().getQueryParameter("token");
        return token;

    }
}
