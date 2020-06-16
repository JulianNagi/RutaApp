package com.proyecto.RutApp;

import androidx.appcompat.app.AppCompatActivity;

public class Evento extends AppCompatActivity {

    private int date;
    private int eventRoute;
    private String eventType;
    private String description;

    public Evento(int fecha, int ruta, String tipo, String descripcion){
        this.date = fecha;
        this.eventRoute = ruta;
        this.eventType = tipo;
        this.description = descripcion;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getEventRoute() {
        return eventRoute;
    }

    public void setEventRoute(int eventRoute) {
        this.eventRoute = eventRoute;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void informarEvento(){
        //Agregar Evento a la lista de eventos
        //Notificar
    }
}
