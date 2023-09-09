package com.test.2023ampmhackathon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button roomMateButton = findViewById(R.id.room_mate);
        roomMateButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RoomMateView.class);
            startActivity(intent);
        });

        Button curfewMateButton = findViewById(R.id.curfew_mate);
        curfewMateButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CurfewMateView.class);
            startActivity(intent);
        });

        Button taxiMateButton = findViewById(R.id.taxi_mate);
        taxiMateButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, TaxiMateView.class);
            startActivity(intent);
        });
    }

}