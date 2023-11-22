package com.example.diutransport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<BusTimeTable> busTimeTableList;


    public MyAdapter(Context context, List<BusTimeTable> busTimeTableList) {
        this.context = context;
        this.busTimeTableList = busTimeTableList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from( context ).inflate( R.layout.item_view,parent,false ));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.busNumberTV.setText( busTimeTableList.get( position ).getBusNumber() );
        holder.busTypeTV.setText( busTimeTableList.get( position ).getBusType() );
        holder.departureTimeTV.setText( busTimeTableList.get( position ).getDepartureTime() );
        holder.busRouteTV.setText( busTimeTableList.get( position ).getBusRoute() );
    }

    @Override
    public int getItemCount() {
        return busTimeTableList.size();
    }
}
