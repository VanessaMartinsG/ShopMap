package com.example.prototipo_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class FormCadastro extends AppCompatActivity {

    private ImageView image_backPage;

    private EditText edit_nome, edit_email, edit_senha, edit_dataNascimento, edit_senhaconfirmar;
    private Button bt_cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);

        getSupportActionBar().hide();
        IniciarComponentes2();

        image_backPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(FormCadastro.this,formLogin.class);
               startActivity(intent);
            }
        });
    }

   private void IniciarComponentes2(){
       image_backPage = findViewById(R.id.backPage);
    }
}