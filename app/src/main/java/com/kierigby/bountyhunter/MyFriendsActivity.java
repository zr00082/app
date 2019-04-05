package com.kierigby.bountyhunter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MyFriendsActivity extends AppCompatActivity {

    private ArrayList<String> friendName = new ArrayList<>();
    private ArrayList<String> userName = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_friends);
        initFriendList();
    }

    private void initFriendList() {
        friendName.add("Test Name");
        userName.add("username1");


        initRecyclerView();
    }

    private  void initRecyclerView(){

        RecyclerView recyclerView = findViewById(R.id.friends_recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, friendName, userName);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}