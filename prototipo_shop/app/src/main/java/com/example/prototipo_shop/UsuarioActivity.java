/*package com.example.prototipo_shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;] import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UsuarioActivity extends AppCompatActivity {
    private Button buttonSalvar = null;
    private UsuarioDAO usuarioDAO = null;
    private EditText editText = null;
    private  UsuarioValue usuarioSelecionada = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);
        buttonSalvar = (Button) findViewById(R.id.buttonSalvar);
        editText = (EditText) findViewById(R.id.editTextUsuario);

        usuarioDAO = new UsuarioDAO(this);

        Intent intent = getIntent();
        usuarioSelecionada= (UsuarioValue)  intent.getSerializableExtra("usuarioSelecionada");
        if(usuarioSelecionada!=null){
            buttonSalvar.setText("Alterar");
            editText.setText(usuarioSelecionada.getNome());
            editText.setText(usuarioSelecionada.getEmail());
            editText.setText(usuarioSelecionada.getDataNascimento());
            editText.setText(usuarioSelecionada.getSenha());
        }



        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UsuarioValue usuarioValueNova = new UsuarioValue();
                usuarioValueNova.setNome(editText.getText().toString());

                if(usuarioSelecionada!=null) {

                    usuarioValueNova.setId(usuarioSelecionada.getId());
                    usuarioDAO.alterar(usuarioValueNova);
                }
                else {
                    UsuarioValue usuarioValue = new UsuarioValue();
                    usuarioValue.setNome(editText.getText().toString());

                    usuarioDAO.salvar(usuarioValue);
                }
                finish();
            }
        });
    }
}*/