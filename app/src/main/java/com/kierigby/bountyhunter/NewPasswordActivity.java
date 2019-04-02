package com.kierigby.bountyhunter;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bountyhunterapi.BountyHunterAPI;
import com.example.bountyhunterapi.Token;

public class NewPasswordActivity extends AppCompatActivity {
    private EditText mNewPasswordInput,mConfirmNewPasswordInput;
    private Button mNewPasswordBtn;
    private BountyHunterAPI api = new BountyHunterAPI(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);
//        addListenerToNewPasswordButton();
    }

//    public void addListenerToNewPasswordButton(){
//        mNewPasswordInput=findViewById();
//        mConfirmNewPasswordInput=findViewById();
//        mNewPasswordBtn=findViewById();
//
//        mNewPasswordBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(mNewPasswordInput.getText().toString().isEmpty()||mConfirmNewPasswordInput.getText().toString().isEmpty()){
//                    Toast.makeText(getApplicationContext(), "Please enter all the necessary information", Toast.LENGTH_LONG).show();
//                } else if (!mNewPasswordInput.getText().toString().equals(mConfirmNewPasswordInput.getText().toString())) {
//                    Toast.makeText(getApplicationContext(), "The passwords you entered do not match", Toast.LENGTH_LONG).show();
//                }else{
//                    api.resetPassoword(getToken(),mConfirmNewPasswordInput.getText().toString());
//                                    NavUtils.navigateUpFromSameTask(NewPasswordActivity.this);
//                }
//            }
//        });
//    }

    public String getToken(){
        Intent deepLinkI= getIntent();
        String token= "Bearer " +deepLinkI.getData().getQueryParameter("token");
        Toast.makeText(getApplicationContext(),token,Toast.LENGTH_LONG).show();

        return token;
    }

}
