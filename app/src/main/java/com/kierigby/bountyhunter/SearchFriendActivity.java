package com.kierigby.bountyhunter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class SearchFriendActivity extends AppCompatActivity {

    private ArrayList<String> friendName = new ArrayList<>();
    private ArrayList<String> userName = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_friend);
        initFriendList();
    }

    private void initFriendList() {
        friendName.add("Test Name");
        userName.add("username1");


        initRecyclerView();
    }

    private  void initRecyclerView(){

        RecyclerView recyclerView = findViewById(R.id.add_friends_list);
        RecyclerViewAdapterSearchFriends adapter = new RecyclerViewAdapterSearchFriends(friendName, userName, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
