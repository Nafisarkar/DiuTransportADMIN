package com.example.diutransport;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView busNumberTV, busTypeTV, departureTimeTV, busRouteTV;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        busNumberTV = itemView.findViewById(R.id.busNoTV);
        busTypeTV = itemView.findViewById(R.id.typeTV);
        departureTimeTV = itemView.findViewById(R.id.departureTimeTV);
        busRouteTV = itemView.findViewById(R.id.busRouteTV);

    }
}
