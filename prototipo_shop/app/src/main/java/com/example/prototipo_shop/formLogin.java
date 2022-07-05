package com.example.prototipo_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class formLogin extends AppCompatActivity {

    private TextView text_telaCadastro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        getSupportActionBar().hide();
        IniciarComponentes();

        text_telaCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(formLogin.this,FormCadastro.class);
                startActivity(intent);
            }
        });
    }
    private void IniciarComponentes(){
        text_telaCadastro = findViewById(R.id.textCadastro);
    }
}