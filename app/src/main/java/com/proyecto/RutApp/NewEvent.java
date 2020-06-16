package com.proyecto.RutApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NewEvent extends AppCompatActivity {

    private Button eventSend;
    private TextView date, route, eventTypeText;
    private EditText description;
    public String eventType;    //Tipo de evento, depende del boton presionado antes

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newevent);
        eventSend = (Button)findViewById(R.id.eventSend);
        date = (TextView)findViewById(R.id.dateTextBox);
        route = (TextView)findViewById(R.id.routeTextBox);
        eventTypeText = (TextView)findViewById(R.id.typeTextBox);
        description = (EditText)findViewById(R.id.descTextBox);

        date.setText("");       //Poner como String la fecha
        route.setText("");      //Poner como String la ruta
        eventTypeText.setText(eventType);

        eventSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Evento event = new Evento(Integer.parseInt(date.getText().toString()), Integer.parseInt(route.getText().toString()), eventType, description.getText().toString());
                event.informarEvento();
                Intent i = new Intent(NewEvent.this, Notifs_conductor.class);
                startActivity(i);
            }
        });

    }

}
