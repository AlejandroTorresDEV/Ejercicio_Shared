package com.example.alejandrotorresruiz.ejercicio_shared.Activitys.Activities.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.alejandrotorresruiz.ejercicio_shared.R;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail,editTextPassword;
    private Button buttonAcceso;
    private Switch switchRecordar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buildUI();

        buttonAcceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if(validarAcceso(email,password)){
                    accederMain();
                }
            }
        });
    }

    private void buildUI(){
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonAcceso = (Button) findViewById(R.id.buttonAcceso);
        switchRecordar = (Switch) findViewById(R.id.switchRecordar);
    }


    private void accederMain(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    private boolean validarAcceso(String email,String password){
        if(!validarEmail(email)){
            Toast.makeText(this,"El email es incorrecto",Toast.LENGTH_LONG).show();
            return false;
        }else if (!validarPassword(password)){
            Toast.makeText(this,"La constraseña no es correcta",Toast.LENGTH_LONG).show();
            return false;
        }else{
            Toast.makeText(this,"Correcto ACCEDIENDO",Toast.LENGTH_LONG).show();
            return true;
        }
    }

    public boolean validarEmail(String email){
        //PATTERNS NOS AYUDAR A VALIDAR SI UN "EMAIL" ESTA FORMADO COMO TAL. EJEM ALEX@GMAIL.COM
        //ENTRE OTRAS COSAS.
        if (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return true;
        }else{
            return false;
        }
    }

    public boolean validarPassword(String password){
        if(!TextUtils.isEmpty(password) && password.length() >= 4){
            return true;
        }else{
            return false;
        }
    }
}
