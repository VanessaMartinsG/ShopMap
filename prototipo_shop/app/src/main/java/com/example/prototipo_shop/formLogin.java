package com.example.prototipo_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class formLogin extends AppCompatActivity {

    private TextView text_Tcadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        getSupportActionBar().hide();
        IniciarComp();
        text_Tcadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(formLogin.this,FormCadastro.class);
                startActivity(intent);
            }
        });
    }
    private void IniciarComp(){
        text_Tcadastro = findViewById(R.id.textCadastro);
    }
}