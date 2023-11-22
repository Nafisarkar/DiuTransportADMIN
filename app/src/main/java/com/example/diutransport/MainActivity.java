package com.example.diutransport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextView availTV, deptTV, busforTV, mirpurtTV, dhanmonditTV, uttaratTV, naratTV, mirpurnTV, dhanmondinTV, uttaranTV, naranTV;
    CardView availcardView;
    DatabaseReference dbRefAbil, dbRefDep, dbRefBusfor, dbRefMirpurtypebil, dbrefBusNumber;
    EditText dpET,busAvailET,mirpurET,dhanmondiET,uttaraET,narayanganjET,mipurBusNoEt,dhanmondiBusNoEt,uttaraBusNoEt,narayanganjBusNoEt;
    Button routesBtn,availBtn,noavailBtn,dpBtn,busAvailUpdateBtn,mirpurBtn,dhanmondiBtn,uttaraBtn,narayanganjBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        availTV = findViewById(R.id.availabilityTV);
        availcardView = findViewById(R.id.availabilitycardView);
        busforTV = findViewById(R.id.availableforTV);
        deptTV = findViewById(R.id.deptimeTV);

        mirpurtTV = findViewById(R.id.mirpurtypeTV);
        dhanmonditTV = findViewById(R.id.dhanmonditypeTV);
        uttaratTV = findViewById(R.id.uttaratypeTV);
        naratTV = findViewById(R.id.naratypeTV);

        mirpurnTV = findViewById(R.id.mirpurnumberTV);
        dhanmondinTV = findViewById(R.id.dhanmondinumberTV);
        uttaranTV = findViewById(R.id.uttaranumberTV);
        naranTV = findViewById(R.id.naranumberTV);

        routesBtn = findViewById(R.id.routesBtn);
        availBtn = findViewById(R.id.makeAvailableBtn);
        noavailBtn = findViewById(R.id.makeNotAvailableBtn);
        dpBtn = findViewById(R.id.updateDepTimeBtn);
        busAvailUpdateBtn = findViewById(R.id.updateBusAvailableForBtn);
        mirpurBtn = findViewById(R.id.mirpurUpdateBtn);
        dhanmondiBtn = findViewById(R.id.dhanmondiUpdateBtn);
        uttaraBtn = findViewById(R.id.uttaraUpdateBtn);
        narayanganjBtn = findViewById(R.id.narayanganjUpdateBtn);

        dpET = findViewById(R.id.deptimeET);
        busAvailET = findViewById(R.id.busAvailableForET);
        mirpurET = findViewById(R.id.mirpurBusET);
        mipurBusNoEt = findViewById(R.id.mirpurBusNoET);
        dhanmondiET = findViewById(R.id.dhanmondiBusET);
        dhanmondiBusNoEt = findViewById(R.id.dhanmondiBusNoET);
        uttaraET = findViewById(R.id.uttaraBusET);
        uttaraBusNoEt = findViewById(R.id.uttaraBusNoET);
        narayanganjET = findViewById(R.id.narayanganjBusET);
        narayanganjBusNoEt = findViewById(R.id.narayanganjBusNoET);


        dbRefAbil = FirebaseDatabase.getInstance().getReference("Availability");
        dbRefAbil.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                if (value.equals("1")) {
                    availTV.setText("Available");
                    availcardView.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.green_300));
                } else {
                    availTV.setText("Not Available");
                    availcardView.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red_500));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        availBtn.setOnClickListener(v -> {
            dbRefAbil.setValue("1");

        });
        noavailBtn.setOnClickListener(v -> {
            dbRefAbil.setValue("0");
        });


        dbRefDep = FirebaseDatabase.getInstance().getReference("Departure");
        dbRefDep.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                deptTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        dpBtn.setOnClickListener(v -> {
            String dep = dpET.getText().toString();
            dbRefDep.setValue(dep);
        });

        dbRefBusfor = FirebaseDatabase.getInstance().getReference("BusFor");
        dbRefBusfor.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                busforTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        busAvailUpdateBtn.setOnClickListener(v -> {
            String busfor = busAvailET.getText().toString();
            dbRefBusfor.setValue(busfor);
        });

        dbRefMirpurtypebil = FirebaseDatabase.getInstance().getReference("MirpurType");
        dbRefMirpurtypebil.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                mirpurtTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mirpurBtn.setOnClickListener(v -> {
            DatabaseReference mirpurD1 = FirebaseDatabase.getInstance().getReference("MirpurType");
            mirpurD1.setValue(mirpurET.getText().toString());
            DatabaseReference mirpurD2 = FirebaseDatabase.getInstance().getReference("MirpurBusNumber");
            mirpurD2.setValue(mipurBusNoEt.getText().toString());
        });

        dhanmondiBtn.setOnClickListener(v->{
            DatabaseReference dhanmondiD1 = FirebaseDatabase.getInstance().getReference("DhanmondiType");
            dhanmondiD1.setValue(dhanmondiET.getText().toString());
            DatabaseReference dhanmondiD2 = FirebaseDatabase.getInstance().getReference("DhanmondiBusNumber");
            dhanmondiD2.setValue(dhanmondiBusNoEt.getText().toString());
        });
        uttaraBtn.setOnClickListener(v->{
            DatabaseReference uttaraD1 = FirebaseDatabase.getInstance().getReference("UttaraType");
            uttaraD1.setValue(uttaraET.getText().toString());
            DatabaseReference uttaraD2 = FirebaseDatabase.getInstance().getReference("UttaraBusNumber");
            uttaraD2.setValue(uttaraBusNoEt.getText().toString());
        });
        narayanganjBtn.setOnClickListener(v->{
            DatabaseReference narayanganjD1 = FirebaseDatabase.getInstance().getReference("NarayanganjType");
            narayanganjD1.setValue(narayanganjET.getText().toString());
            DatabaseReference narayanganjD2 = FirebaseDatabase.getInstance().getReference("NaraingonjBusNumber");
            narayanganjD2.setValue(narayanganjBusNoEt.getText().toString());
        });


        dbRefMirpurtypebil = FirebaseDatabase.getInstance().getReference("DhanmondiType");
        dbRefMirpurtypebil.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                dhanmonditTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        dbRefMirpurtypebil = FirebaseDatabase.getInstance().getReference("UttaraType");
        dbRefMirpurtypebil.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                uttaratTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        dbRefMirpurtypebil = FirebaseDatabase.getInstance().getReference("NarayanganjType");
        dbRefMirpurtypebil.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                naratTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        dbrefBusNumber = FirebaseDatabase.getInstance().getReference("MirpurBusNumber");
        dbrefBusNumber.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                mirpurnTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        dbrefBusNumber = FirebaseDatabase.getInstance().getReference("DhanmondiBusNumber");
        dbrefBusNumber.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                dhanmondinTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        dbrefBusNumber = FirebaseDatabase.getInstance().getReference("UttaraBusNumber");
        dbrefBusNumber.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                uttaranTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        dbrefBusNumber = FirebaseDatabase.getInstance().getReference("NaraingonjBusNumber");
        dbrefBusNumber.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                naranTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        routesBtn.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), ShowRoutes.class));
        });
    }
}