package com.kierigby.bountyhunter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapterSearchFriends extends RecyclerView.Adapter<RecyclerViewAdapterSearchFriends.ViewHolder>{

    private ArrayList<String> mFriendName;
    private ArrayList<String> mFriendUsername;
    private Context mContext;

    public RecyclerViewAdapterSearchFriends(ArrayList<String> mFriendName, ArrayList<String> mFriendUsername, Context mContext) {
        this.mFriendName = mFriendName;
        this.mFriendUsername = mFriendUsername;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.add_friends_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.friendName.setText(mFriendName.get(i));
        viewHolder.friendUsername.setText(mFriendUsername.get(i));

    }

    @Override
    public int getItemCount() {
        return mFriendName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView friendName;
        TextView friendUsername;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            friendName = itemView.findViewById(R.id.friendName);
            friendUsername = itemView.findViewById(R.id.friendUsername);
        }
    }
}
