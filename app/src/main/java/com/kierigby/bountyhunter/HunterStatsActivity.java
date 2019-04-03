package com.kierigby.bountyhunter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class HunterStatsActivity extends AppCompatActivity {

    private ArrayList<String> mStatName = new ArrayList<>();
    private ArrayList<String> mActualStat = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hunter_stats);
        initStatList();
    }

    private void initStatList() {
        mStatName.add("Games Played");
        mActualStat.add("-");

        mStatName.add("Total Points");
        mActualStat.add("-");

        mStatName.add("Total Number of Catches");
        mActualStat.add("-");

        mStatName.add("Highest No of Catches in a game");
        mActualStat.add("-");

        mStatName.add("Games Won");
        mActualStat.add("-");

        initRecyclerView();
    }

    private void initRecyclerView(){

        RecyclerView recyclerView = findViewById(R.id.hunter_recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mStatName, mActualStat);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
