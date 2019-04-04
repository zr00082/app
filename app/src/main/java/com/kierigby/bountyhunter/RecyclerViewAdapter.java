package com.kierigby.bountyhunter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<String> mTitle;
    private ArrayList<String> mDesc;
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<String> title, ArrayList<String> desc) {
        this.mTitle = title;
        this.mDesc = desc;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.title.setText(mTitle.get(i));
        viewHolder.desc.setText(mDesc.get(i));

    }

    @Override
    public int getItemCount() {
        return mTitle.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {


        TextView title;
        TextView desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);
        }
    }
}
