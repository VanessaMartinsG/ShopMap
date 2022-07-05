package com.example.prototipo_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;

public class FormCadastro extends AppCompatActivity {

    private ImageView image_backPage;

    private EditText edit_nome, edit_email, edit_senha, edit_dataNascimento, edit_senhaconfirmar;
    private Button bt_cadastrar;

    UsuarioDAO db = new UsuarioDAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);

        getSupportActionBar().hide();
        IniciarComponentesCadastro();

        image_backPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormCadastro.this,formLogin.class);
                startActivity(intent);
            }
        });
        bt_cadastrar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                String nome = edit_nome.getText().toString();
                String email = edit_email.getText().toString();
                String dataNascimento = edit_dataNascimento.getText().toString();
                String senha = edit_senha.getText().toString();
                String senhaconfirmar = edit_senhaconfirmar.getText().toString();
                Log.i("Cadastrar", email);
                if(email == null){
                    Log.i("Cadastrar", "NULO");
                }
                String [] mensagens = {"Preencha todos os campos","Cadastro realizado com sucesso", "A senha está diferente.", "Este email ja existe."};

                if(nome.isEmpty() || email.isEmpty() || dataNascimento.isEmpty() || senha.isEmpty() || senhaconfirmar.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.BLACK);
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                }
                else if(!senha.equals(senhaconfirmar)){
                    Snackbar snackbar = Snackbar.make(v, mensagens[2], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.BLACK);
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                }
                else{
                    if(db.verificaEmail(email) == false){
                        Snackbar snackbar = Snackbar.make(v, mensagens[3], Snackbar.LENGTH_SHORT);
                        snackbar.setBackgroundTint(Color.BLACK);
                        snackbar.setTextColor(Color.WHITE);
                        snackbar.show();
                    }
                    else {
                        CadastrarUsuario(nome, email, dataNascimento, senha);
                        Snackbar snackbar = Snackbar.make(v, mensagens[1], Snackbar.LENGTH_SHORT);
                        snackbar.setBackgroundTint(Color.BLACK);
                        snackbar.setTextColor(Color.WHITE);
                        snackbar.show();
                        Intent intent = new Intent(FormCadastro.this, formLogin.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
    private void CadastrarUsuario(String nome, String email, String dataNascimento, String senha){
        Log.d("Cadastrar",email);
        Log.d("Cadastrar:", senha);

        db.salvar(nome, email, dataNascimento, senha);
    }

    private void IniciarComponentesCadastro(){
        edit_nome = findViewById(R.id.nomeCompleto);
        edit_email = findViewById(R.id.nomeEmail);
        edit_dataNascimento = findViewById(R.id.dataNascimento);
        edit_senha = findViewById(R.id.senha);
        edit_senhaconfirmar = findViewById(R.id.senhaConfirmar);
        bt_cadastrar = findViewById(R.id.cadastrar);
        image_backPage = findViewById(R.id.backPage);
    }
}