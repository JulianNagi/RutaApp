package com.proyecto.RutApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Notifs_usuario extends AppCompatActivity {

    private Button llegadaCasaBtn, llegadaColegioBtn, recogidaCasaBtn, recogidaColegioBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifs_conductor);
        llegadaCasaBtn = (Button)findViewById(R.id.llegadaCasaBtn);
        llegadaColegioBtn = (Button)findViewById(R.id.llegadaColegioBtn);
        recogidaCasaBtn = (Button)findViewById(R.id.recogidaCasaBtn);
        recogidaColegioBtn = (Button)findViewById(R.id.recogidaColegioBtn);

        llegadaCasaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtener usuario y notificar llegada a casa
            }
        });
        llegadaColegioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtener usuario y notificar llegada a colegio
            }
        });
        recogidaCasaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtener usuario y notificar recogida en casa
            }
        });
        recogidaColegioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtener usuario y notificar recogida en colegio
            }
        });
    }

}
