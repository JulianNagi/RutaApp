package com.proyecto.RutApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.proyecto.RutApp.R;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

public class inicio extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText user_login;
    private EditText password;
    private Button Login,registrarU,registrarC,olvideC;
    String user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        mAuth = FirebaseAuth.getInstance();
        user_login= (EditText)findViewById(R.id.user_login);
        password= (EditText)findViewById(R.id.user_password);
        Login = (Button)findViewById(R.id.btnLogin);
        registrarU = (Button)findViewById(R.id.btnRegistroU);
        registrarC = (Button)findViewById(R.id.btnRegistroC);
        olvideC = (Button)findViewById(R.id.btnOlvideC);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = user_login.getText().toString();
                pass = password.getText().toString();
                mAuth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Intent i= new Intent(inicio.this, MapsActivity.class);
                            startActivity(i);
                        }
                        else{
                            Toast.makeText(inicio.this,"No se pudo iniciar sesion",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        registrarU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(inicio.this, Registro.class);
                startActivity(i);
            }
        });
        registrarC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(inicio.this, Registro2.class);
                startActivity(i);
            }
        });
        olvideC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(inicio.this, olvide.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==event.KEYCODE_BACK) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Desea salir de la app?").setPositiveButton("si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent= new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            })
                    .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();;
                        }
                    });
            builder.show();
        }
    return super.onKeyDown(keyCode, event);
    }
}
