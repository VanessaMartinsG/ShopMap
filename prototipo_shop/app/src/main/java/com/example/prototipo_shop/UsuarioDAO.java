package com.example.prototipo_shop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class UsuarioDAO extends SQLiteOpenHelper {
    private static final String DATABASE = "UsuariosBD";
    private static final int VERSAO = 1;



    public UsuarioDAO(Context context) {
        super(context, DATABASE, null, VERSAO);
    }


    public void onCreate(SQLiteDatabase db) {
        String ddl="CREATE TABLE Usuario (id INTEGER PRIMARY KEY,"+
                " nome TEXT NOT NULL,"+
                " email TEXT UNIQUE NOT NULL,"+
                " dataNascimento TEXT NOT NULL,"+
                " senha TEXT NOT NULL)";
        db.execSQL(ddl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int velha, int nova) {
        String ddl="DROP TABLE IF EXISTS Usuario";
        db.execSQL(ddl);
        onCreate(db);
    }

    public void salvar(String nome, String email, String dataNascimento, String senha) {

        ContentValues values= new ContentValues();
        values.put("nome", nome);
        values.put("email", email);
        values.put("dataNascimento", dataNascimento);
        values.put("senha", senha);
        getWritableDatabase().insert("Usuario", null, values);
    }
    public boolean verificaEmail(String email){
        String query = "SELECT  * FROM Usuario";
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor= db.rawQuery(query, null);
        if(cursor.moveToFirst()) {
            do {
                String localEmail = cursor.getString(2);
                if(email.equals(localEmail)){
                    return false;
                }
            } while(cursor.moveToNext());
        }
        return true;
    }

    public UsuarioValue autenticar(UsuarioValue usuario){

        String query ="SELECT  * FROM Usuario WHERE email LIKE '" + usuario.getEmail() +
                        "' AND senha LIKE '" + usuario.getSenha() + "'";
        SQLiteDatabase db =  this.getWritableDatabase();
        Cursor cursor= db.rawQuery(query, null);
        UsuarioValue usuario1 = null;
        if (cursor.moveToFirst()) {
            usuario1 = new UsuarioValue(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4));
            usuario1.setId(Long.parseLong(cursor.getString(0)));
        }
        db.close();
        return usuario1;
    }

    public void todos(){
        String query = "SELECT  * FROM Usuario";

        SQLiteDatabase db =  this.getWritableDatabase();
        Cursor cursor= db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                UsuarioValue usuario1 = new UsuarioValue(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4));
                usuario1.setId(Long.parseLong(cursor.getString(0)));
            }while (cursor.moveToNext());
        }
        db.close();
    }

    public void deletar(UsuarioValue usuarioValue) {
        String[] args= { usuarioValue.getId().toString() };
        getWritableDatabase().delete("Usuario",  "id=?", args);
    }

    public void alterar(UsuarioValue usuarioValue) {
        ContentValues values= new ContentValues();

        String[] args= new String[]{usuarioValue.getId().toString()};
        values.put("nome", usuarioValue.getNome());
        values.put("email", usuarioValue.getEmail());
        values.put("dataNascimento", usuarioValue.getDataNascimento());
        values.put("senha", usuarioValue.getSenha());
        getWritableDatabase().update("Usuario", values,
                "id=?", new String[]{usuarioValue.getId().toString()});
    }
}
