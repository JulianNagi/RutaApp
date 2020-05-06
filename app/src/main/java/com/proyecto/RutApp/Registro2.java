package com.proyecto.RutApp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class Registro2 extends AppCompatActivity {

    //Llamar objetos
    private EditText etName;
    private EditText etEmail;
    private EditText etPhone;
    private EditText etPassword;
    private EditText etPassword1;
    private EditText etMarca;
    private EditText etMatricula;
    private EditText etFecha;
    private EditText etNumeroP;
    private Button registrarC;

    //Variables
    private String name, email, pass, pass1, phone, marca, matricula, soat, nPuestos;

    private FirebaseAuth mAuth2;
    private DatabaseReference mDatabase2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mAuth2 = FirebaseAuth.getInstance();
        mDatabase2 = FirebaseDatabase.getInstance().getReference();

        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro2);
        etName= (EditText)findViewById(R.id.nameC);
        etEmail= (EditText)findViewById(R.id.emailC);
        etPhone= (EditText)findViewById(R.id.phoneC);
        etPassword= (EditText)findViewById(R.id.passwordC);
        etPassword1= (EditText)findViewById(R.id.passwordC1);
        etMarca= (EditText)findViewById(R.id.marcaV);
        etMatricula= (EditText)findViewById(R.id.matriculaV);
        etFecha= (EditText)findViewById(R.id.fechaS);
        etNumeroP= (EditText)findViewById(R.id.numeroPuestos);
        registrarC= (Button)findViewById(R.id.bregistrarC);

        registrarC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etName.getText().toString();
                email = etEmail.getText().toString();
                phone = etPhone.getText().toString();
                pass = etPassword.getText().toString();
                pass1 = etPassword1.getText().toString();
                marca = etMarca.getText().toString();
                matricula = etMatricula.getText().toString();
                soat = etFecha.getText().toString();
                nPuestos = etNumeroP.getText().toString();

                if (!name.isEmpty() && !email.isEmpty() && !phone.isEmpty() && !marca.isEmpty() && !pass.isEmpty() && !pass1.isEmpty() && !matricula.isEmpty() && !soat.isEmpty() && !nPuestos.isEmpty()) {
                    if (pass.equals(pass1)) {
                        if (pass.length() > 6) {
                            RDriver();
                        } else {
                            Toast.makeText(Registro2.this, "Su contraseña debe tener mas de 6 caracteres", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Registro2.this, "Las contraseñas no coincidan", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Registro2.this, "Llene todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void RDriver(){
        mAuth2.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Map<String, Object> mapa= new HashMap<>();
                    mapa.put("Name", name);
                    mapa.put("Email", email);
                    mapa.put("phone", phone);
                    mapa.put("Password", pass);
                    mapa.put("Marca Vehiculo", marca);
                    mapa.put("Matricula Vehiculo", matricula);
                    mapa.put("Fecha de vancimiento SOAT", soat);
                    mapa.put("numero de puestos", nPuestos);
                    String id = mAuth2.getCurrentUser().getUid();
                    mDatabase2.child("Drivers").child(id).setValue(mapa).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()){
                                Toast.makeText(Registro2.this,"Iniciar Sesion",Toast.LENGTH_SHORT).show();
                                Intent i= new Intent(Registro2.this, inicio.class);
                                startActivity(i);
                            }
                            else{
                                Toast.makeText(Registro2.this,"No se pudo crear el usuario",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(Registro2.this,"No se pudo registrar el usuario",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}
