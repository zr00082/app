package com.kierigby.bountyhunter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.bountyhunterapi.BountyHunterAPI;
import com.example.bountyhunterapi.Stat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatsActivity extends AppCompatActivity {

    private final List<Stat> statsList = Collections.synchronizedList(new ArrayList<Stat>());
    private BountyHunterAPI api;
    private RecyclerView.Adapter mStatRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        api = new BountyHunterAPI(this);
        setUpRecyclerView();
        getStats();

    }


    private void setUpRecyclerView() {
        RecyclerView mStatsRecyclerView = findViewById(R.id.stats_recycler_view);
        mStatsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mStatRecyclerViewAdapter = new StatsRecyclerViewAdapter(statsList);
        mStatsRecyclerView.setAdapter(mStatRecyclerViewAdapter);
    }

    private void getStats(){
        api.getBountyHunterStats(((GlobalUser) this.getApplication()).getLoggedInUser().getId(), new BountyHunterAPI.StatCallBack() {
            @Override
            public void onStatsRetrieved(List<Stat> stats) {
                synchronized (statsList) {
                   statsList.addAll(stats);
                    mStatRecyclerViewAdapter.notifyDataSetChanged();
                }
            }
        });

        api.getFugitiveStats(((GlobalUser) this.getApplication()).getLoggedInUser().getId(), new BountyHunterAPI.StatCallBack() {
            @Override
            public void onStatsRetrieved(List<Stat> stats) {
                synchronized (statsList) {
                    statsList.addAll(stats);
                    mStatRecyclerViewAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
