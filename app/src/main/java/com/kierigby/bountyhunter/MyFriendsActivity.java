package com.kierigby.bountyhunter;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.bountyhunterapi.BountyHunterAPI;
import com.example.bountyhunterapi.Friend;

import java.util.ArrayList;
import java.util.List;

public class MyFriendsActivity extends AppCompatActivity {

    private ArrayList<Friend> friendsList = new ArrayList<>();
    private BountyHunterAPI api;
    private RecyclerView.Adapter mFriendRecyclerViewAdapter;
    private RecyclerView mFriendRecyclerView;
    private ImageButton mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_friends);
        api = new BountyHunterAPI(this);
        addListenerToBackButton();
        setUpRecyclerView();
        getFriends();
    }


    private void setUpRecyclerView() {

        mFriendRecyclerView = findViewById(R.id.friends_recycler_view);
        mFriendRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFriendRecyclerViewAdapter = new FriendsRecyclerViewAdapter(friendsList);
        mFriendRecyclerView.setAdapter(mFriendRecyclerViewAdapter);

    }

    public void getFriends() {
        api.getFriendsFollowers(((GlobalUser) this.getApplication()).getLoggedInUser().getId(), new BountyHunterAPI.FoundFriendsCallBack() {
            @Override
            public void onFriendsFound(List<Friend> friends) {
                friends.removeAll(friendsList);
                friendsList.addAll(friends);
                mFriendRecyclerViewAdapter.notifyDataSetChanged();
            }
        });

        api.getFriendsFollowing(((GlobalUser) this.getApplication()).getLoggedInUser().getId(), new BountyHunterAPI.FoundFriendsCallBack() {
            @Override
            public void onFriendsFound(List<Friend> friends) {
                friends.removeAll(friendsList);
                friendsList.addAll(friends);
                mFriendRecyclerViewAdapter.notifyDataSetChanged();
            }
        });
    }


    public void addListenerToBackButton() {
        mBackButton = findViewById(R.id.backFromMyFriends);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavUtils.navigateUpFromSameTask(MyFriendsActivity.this);
            }
        });
    }

}