package com.example.diutransport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowRoutes extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_routes);
        recyclerView = findViewById(R.id.routeList);
        reference = FirebaseDatabase.getInstance().getReference("BusTimeTable/");

        List<BusTimeTable> busTimeTableList = new ArrayList<BusTimeTable>();

        BusTimeTable bus1 = new BusTimeTable("21", "Surjamukhi", "1:00 AM", "Mirpur");
        BusTimeTable bus2 = new BusTimeTable("3", "Dolphin", "4:00 AM", "Uttara");
        BusTimeTable bus3 = new BusTimeTable("6", "Surjamukhi", "3:00 AM", "Dhanmondi");
        BusTimeTable bus4 = new BusTimeTable("12", "Dolphin", "7:00 AM", "Naraingonj");

        //add object from firebase to busTimeTableList here
        //the obj are in BusTimeTable > DhanmondibusTimeTable > uniq id >
        //get the obj and add to busTimeTableList
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(getApplicationContext(), busTimeTableList);
        recyclerView.setAdapter(adapter);

        reference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                busTimeTableList.clear();
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        for (DataSnapshot dataSnap : dataSnapshot.getChildren()){
                            BusTimeTable busTimeTable1 = dataSnap.getValue(BusTimeTable.class);
                            busTimeTableList.add(busTimeTable1);
                            Log.d("TAG", "onDataChange: " + busTimeTable1.getBusNumber());
                        }
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}