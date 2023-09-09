package com.test.2023ampmhackathon;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TaxiMateView extends AppCompatActivity {

    private ListView taxiMateDescListView;

    private TaxiMateDescAdapter taxiMateDescAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taxi_mate);

        String[] departureOptions = {"건지광장", "참빛광장", "직영관", "창의관", "구정문"};
        ArrayAdapter<String> departureAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, departureOptions);
        departureAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Button departureButton = findViewById(R.id.Departure);
        final Spinner departureSpinner = findViewById(R.id.Departure_Spinner);
        departureSpinner.setVisibility(View.GONE);
        departureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                departureSpinner.setVisibility(View.VISIBLE);
            }
        });
        departureSpinner.setAdapter(departureAdapter);
        departureSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        String[] arrivalOptions = {"고속버스터미널", "시외버스터미널", "전주역"};
        ArrayAdapter<String> arrivalAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrivalOptions);
        arrivalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Button arrivalButton = findViewById(R.id.Arrival);
        final Spinner arrivalSpinner = findViewById(R.id.Arrival_Spinner);
        arrivalSpinner.setVisibility(View.GONE);
        arrivalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrivalSpinner.setVisibility(View.VISIBLE);
            }
        });
        arrivalSpinner.setAdapter(arrivalAdapter);
        arrivalSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        taxiMateDescListView = (ListView) findViewById(R.id.taxi_mate_listview);
        taxiMateDescAdapter = new TaxiMateDescAdapter(TaxiMateView.this, new ArrayList<String>() {{
            add("#건지광장 #시외버스터미널");
            add("#창의관 #전주역");
            add("#참빛광장 #고속버스터미널");
            add("#직영관 #전주역");
            add("#시외버스터미널 #직영관");
            add("#전주역 #직영관");
            add("#전주역 #창의관");
        }});
        taxiMateDescListView.setAdapter(taxiMateDescAdapter);



    }
}
