package com.proyecto.RutApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Notifs_conductor extends AppCompatActivity {

    private Button accidentBtn, traficoBtn, fallaBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifs_conductor);
        accidentBtn = (Button)findViewById(R.id.AccidentBtn);
        traficoBtn = (Button)findViewById(R.id.TraficoBtn);
        fallaBtn = (Button)findViewById(R.id.FallaMecBtn);

        accidentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Notifs_conductor.this, NewEvent.class);
                startActivity(i);
            }
        });

        traficoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Notifs_conductor.this, NewEvent.class);
                startActivity(i);
            }
        });

        fallaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Notifs_conductor.this, NewEvent.class);
                startActivity(i);
            }
        });

    }
}
