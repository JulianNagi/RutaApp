package com.proyecto.RutApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class Registro extends AppCompatActivity {

    //Llamar objetos
    private EditText nombre;
    private EditText correo;
    private EditText celular;
    private EditText direccion;
    private EditText contrasena;
    private EditText conf_contrasena;
    private Button registrarU;

    //Variables
    private String name, email, address, pass, pass1, phone;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre= (EditText)findViewById(R.id.R_nombre);
        correo= (EditText)findViewById(R.id.R_correo);
        celular= (EditText)findViewById(R.id.R_phone);
        direccion= (EditText)findViewById(R.id.R_Address);
        contrasena= (EditText)findViewById(R.id.R_password);
        conf_contrasena= (EditText)findViewById(R.id.R_password1);
        registrarU= (Button)findViewById(R.id.bregistrar);

        registrarU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nombre.getText().toString();
                email = correo.getText().toString();
                phone = celular.getText().toString();
                address = direccion.getText().toString();
                pass = contrasena.getText().toString();
                pass1 = conf_contrasena.getText().toString();

                if (!name.isEmpty() && !email.isEmpty() && !phone.isEmpty() && !address.isEmpty() && !pass.isEmpty() && !pass1.isEmpty()) {
                    if (pass.equals(pass1)) {
                        if (pass.length() > 6) {
                            RUser();
                        } else {
                            Toast.makeText(Registro.this, "Su contraseña debe tener mas de 6 caracteres", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Registro.this, "Las contraseñas no coincidan", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Registro.this, "Llene todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    private void RUser(){
        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Map<String, Object> map= new HashMap<>();
                    map.put("Name", name);
                    map.put("Email", email);
                    map.put("phone", phone);
                    map.put("Address", address);
                    map.put("Password", pass);
                    String id = mAuth.getCurrentUser().getUid();
                    mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()){
                                Toast.makeText(Registro.this,"Iniciar Sesion",Toast.LENGTH_SHORT).show();
                                Intent i= new Intent(Registro.this, inicio.class);
                                startActivity(i);
                            }
                            else{
                               Toast.makeText(Registro.this,"No se pudo crear el usuario",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(Registro.this,"No se pudo registrar el usuario",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

