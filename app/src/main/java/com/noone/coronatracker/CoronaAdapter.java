package com.noone.coronatracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class CoronaAdapter extends RecyclerView.Adapter<CoronaAdapter.CoronaViewHolder> {
    private List<Statewise> statewiseList;
    private Context context;
    private int rowLayout;

    public CoronaAdapter(List<Statewise> statewiseList, Context context, int rowLayout) {
        this.statewiseList = statewiseList;
        this.context = context;
        this.rowLayout = rowLayout;
    }

    //A view holder inner class where we get reference to the views in the layout using their ID
    public static class CoronaViewHolder extends RecyclerView.ViewHolder {
        CardView infoLayout;
        TextView state;
        TextView confirmed;
        TextView active;
        TextView recovered;
        TextView deceased;

        public CoronaViewHolder(View v) {
            super(v);
            infoLayout = (CardView) v.findViewById(R.id.infolayout);
            state = (TextView) v.findViewById(R.id.state);
            confirmed = (TextView) v.findViewById(R.id.confirmed);
            active = (TextView) v.findViewById(R.id.active);
            recovered = (TextView) v.findViewById(R.id.recovered);
            deceased = (TextView) v.findViewById(R.id.deceased);
        }
    }

    @Override
    public CoronaAdapter.CoronaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new CoronaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CoronaViewHolder holder, final int position) {
        holder.state.setText(statewiseList.get(position).getState());
        holder.confirmed.setText("Confirmed : "+statewiseList.get(position).getConfirmed().toString());
        holder.active.setText("Active : "+statewiseList.get(position).getActive().toString());
        holder.recovered.setText("Recovered : "+statewiseList.get(position).getRecovered().toString());
        holder.deceased.setText("Deceased : "+statewiseList.get(position).getDeaths().toString());
    }

    @Override
    public int getItemCount() {
        return statewiseList.size();
    }
}
