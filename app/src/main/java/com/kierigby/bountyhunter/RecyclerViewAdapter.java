package com.kierigby.bountyhunter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<String> mStatName;
    private ArrayList<String> mActualStat;
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<String> statName, ArrayList<String> actualStat) {
        this.mStatName = statName;
        this.mActualStat = actualStat;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.statName.setText(mStatName.get(i));
        viewHolder.statScore.setText(mActualStat.get(i));

    }

    @Override
    public int getItemCount() {
        return mStatName.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {


        TextView statName;
        TextView statScore;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            statName = itemView.findViewById(R.id.statTitle);
            statScore = itemView.findViewById(R.id.actualStat);
        }
    }
}
