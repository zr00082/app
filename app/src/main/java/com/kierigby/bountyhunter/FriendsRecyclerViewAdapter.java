package com.kierigby.bountyhunter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bountyhunterapi.Friend;

import java.util.ArrayList;

public class FriendsRecyclerViewAdapter extends  RecyclerView.Adapter<FriendsRecyclerViewAdapter.MyViewHolder>{

    private static ArrayList<Friend> mFriendList;

    private static Context mContext;

    public FriendsRecyclerViewAdapter( ArrayList<Friend> friends) {
        this.mFriendList = friends;
    }

    /**
     * Provide a reference to the views for each data item
     */
    public static class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView textView;
        ImageButton deleteBtn;

        /**
         * Sets up the view for each data item,
         * @param itemView the view that will be used by the item
         */
        public  MyViewHolder(View itemView){
            super(itemView);
            textView= itemView.findViewById(R.id.friendName);
            mContext= itemView.getContext();
            deleteBtn= itemView.findViewById(R.id.deleteFriendsIcon);
            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "Delete Button works", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    @NonNull
    @Override
    public FriendsRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.friend_item, viewGroup, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendsRecyclerViewAdapter.MyViewHolder myViewHolder, int i) {

        Friend friendObj=mFriendList.get(i);
        String username = friendObj.getFriend().getUsername();
        myViewHolder.textView.setText(username);

    }

    @Override
    public int getItemCount() {
        return mFriendList.size();
    }

}
