package com.example.prototipo_shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class formLogin extends AppCompatActivity {

    private TextView text_telaCadastro;
    private EditText edit_email, edit_senha;
    private AppCompatButton bt_logar;

    UsuarioDAO db = new UsuarioDAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        getSupportActionBar().hide();
        IniciarComponentes();
        UsuarioValue usuario = new UsuarioValue();
        db.todos();
       if (db.autenticar(usuario) == null){
           Log.i("Debug Login", "usuario não logado");
       }
       else{
           Log.i("Debug Login", usuario.getEmail());
       }

        text_telaCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(formLogin.this,FormCadastro.class);
                startActivity(intent);
            }
        });

        bt_logar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                String email = edit_email.getText().toString();
                String senha = edit_senha.getText().toString();
                UsuarioValue usuario = LogarUsuario(email, senha);
                if(usuario == null) {
                    Snackbar snackbar = Snackbar.make(v, "Usuário não cadastrado", Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.BLACK);
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                    Log.i("Debug Login", "usuario não logado");
                }
                else{
                    Intent intent = new Intent(formLogin.this,MainActivity.class);
                    startActivity(intent);
                    Log.i("Debug Login", usuario.getEmail());
                    Snackbar snackbar = Snackbar.make(v, usuario.getEmail(), Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.BLACK);
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                }
            }
        });
    }


    private UsuarioValue LogarUsuario( String email, String senha){

        /*String email = edit_email.getText().toString();
        String senha = edit_senha.getText().toString();*/
        UsuarioValue usuario = new UsuarioValue();
        usuario.setEmail(email);
        usuario.setSenha(senha);

        return  db.autenticar(usuario);
    }

    private void IniciarComponentes(){
        text_telaCadastro = findViewById(R.id.textCadastro);
        edit_email = findViewById(R.id.email);
        edit_senha = findViewById(R.id.password);
        bt_logar = findViewById(R.id.bt_login);
    }
}