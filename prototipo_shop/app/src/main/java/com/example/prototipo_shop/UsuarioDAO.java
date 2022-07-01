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
    private static final String DATABASE = "BancoUsuarios";
    private static final int VERSAO = 1;

    private static final String TABELAUSUARIO = "Usuario";
    //  private static final String COLUNAID = "id;
    private static final String COLUNANOME = "nome";
    private static final String COLUNAEMAIL = "email";
    private static final String COLUNADATANASCIMENTO = "dataNascimento";
    private static final String COLUNASENHA = "senha";



    public UsuarioDAO(Context context) {
        super(context, DATABASE, null, VERSAO);
    }


    public void onCreate(SQLiteDatabase db) {
        String ddl = "CREATE TABLE " + TABELAUSUARIO + "(id INTEGER PRIMARY KEY, " + COLUNANOME + " TEXT, "
                + COLUNAEMAIL + " TEXT, " + COLUNADATANASCIMENTO + " TEXT, "
                + COLUNASENHA + " TEXT)";
        db.execSQL(ddl);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int velha, int nova) {
        String ddl = "DROP TABLE IF EXISTS Usuario";
        db.execSQL(ddl);
        onCreate(db);
        db.close();
    }

    public void dropTable(){
        String[] args = {"0"};
        getWritableDatabase().delete(TABELAUSUARIO, "id>?", args);
    }

    public void addUsuario(UsuarioValue usuario) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUNANOME, usuario.getNome());
        values.put(COLUNAEMAIL, usuario.getEmail());
        values.put(COLUNADATANASCIMENTO, usuario.getDataNascimento());
        values.put(COLUNASENHA, usuario.getSenha());

        db.insert(TABELAUSUARIO, null, values);
        db.close();
    }

    public void apagarUsuario(UsuarioValue usuario){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABELAUSUARIO,  "id=?", new String[] {String.valueOf(usuario.getId())});
        db.close();
    }

   /* public UsuarioValue selecionarUsuario(int codigo){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABELAUSUARIO, new String[] {COLUNANOME, COLUNAEMAIL, COLUNADATANASCIMENTO,
        COLUNASENHA}, "id=?",
                new String[]{String.valueOf(codigo)}, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        UsuarioValue usuario = new UsuarioValue(
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));

        usuario.setId(Long.parseLong(cursor.getString(0)));

        return usuario;
    }*/

    public UsuarioValue autenticar(UsuarioValue usuario){
        String query = "SELECT  * FROM " + TABELAUSUARIO + " WHERE " + COLUNAEMAIL + " LIKE '" + usuario.getEmail()
                + "' AND " + COLUNASENHA + " LIKE '" + usuario.getSenha() + "'";

        SQLiteDatabase db =  this.getWritableDatabase();
        Cursor cursor= db.rawQuery(query, null);
        UsuarioValue usuario1 = null;
        if (cursor.moveToFirst()) {
            usuario1 = new UsuarioValue(
                    cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
                    usuario1.setId(Long.parseLong(cursor.getString(0)));
        }
        db.close();
        return usuario1;
    }

    public void todos(){
        String query = "SELECT  * FROM " + TABELAUSUARIO ;

        SQLiteDatabase db =  this.getWritableDatabase();
        Cursor cursor= db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                UsuarioValue  usuario1 = new UsuarioValue(
                        cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
                usuario1.setId(Long.parseLong(cursor.getString(0)));
                Log.i("Debug",usuario1.getEmail());
            }while (cursor.moveToNext());
        }
        db.close();
    }
}
    /*
    //========================================================
    public void salvar(UsuarioValue disciplinaValue) {
        ContentValues values= new ContentValues();
        values.put("nome", disciplinaValue.getNome());
        getWritableDatabase().insert("Disciplina", null, values);
    }
    public List getLista(){
        List<UsuarioValue>  disciplinas = new LinkedList<UsuarioValue>();
        String query = "SELECT  * FROM " + "Disciplina order by nome";
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor= db.rawQuery(query, null);
        UsuarioValue disciplina = null;
        if(cursor.moveToFirst()) {
            do {
                disciplina = new UsuarioValue();
                disciplina.setId(Long.parseLong(cursor.getString(0)));
                disciplina.setNome(cursor.getString(1));
                disciplinas.add(disciplina);
            } while(cursor.moveToNext());
        }
        return disciplinas;
    }

    public void deletar(UsuarioValue usuarioValue) {
        String[] args= { usuarioValue.getId().toString() };
        getWritableDatabase().delete("Usuario",  "id=?", args);
    }

    public void alterar(UsuarioValue disciplinaValue) {
        ContentValues values= new ContentValues();

        String[] args= new String[]{disciplinaValue.getId().toString()};
        values.put("nome", disciplinaValue.getNome());
        getWritableDatabase().update("Disciplina", values,
                "id=?", new String[]{disciplinaValue.getId().toString()});
    }
}
*/