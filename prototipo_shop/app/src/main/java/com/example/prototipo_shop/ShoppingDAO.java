package com.example.prototipo_shop;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.example.prototipo_shop.ShoppingValue;

    public class ShoppingDAO extends SQLiteOpenHelper {
        private static final String DATABASE = "UsuariosBD";
        private static final int VERSAO = 1;



        public ShoppingDAO(Context context) {
            super(context, DATABASE, null, VERSAO);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String ddl="CREATE TABLE Shopping (id_shop INTEGER PRIMARY KEY AUTOINCREMENT, nome_shop TEXT NOT NULL, fav_shop TEXT NOT NULL);";
            db.execSQL(ddl);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String ddl = "DROP TABLE IF EXISTS Shopping";
                    db.execSQL(ddl);
                    onCreate(db);
        }

        public void drop() {
            String[] args= { "0" };
            getWritableDatabase().delete("Shopping",  "id>?",args);
        }

        public void CadastrarShop(String nome, String fav) {
            Log.i("debug", "inicio");
            ContentValues values= new ContentValues();
            values.put("nome", nome);
            values.put("fav", fav);

            Log.i("debug",nome);
            Log.i("debug",fav);
            getWritableDatabase().insert("Shopping", null, values);
        }

        public void SalveFav(ShoppingValue shop){
            ContentValues values= new ContentValues();

            values.put("fav", shop.getFav());
            getWritableDatabase().update("Shopping", values,
                    "id=?", new String[]{shop.getId().toString()});
        }

        public void todos(){
            List<ShoppingValue> shoppings = new ArrayList<ShoppingValue>();
            String query = "SELECT  * FROM Shopping";
            SQLiteDatabase db = this.getWritableDatabase();


            //Cursor cursor= db.rawQuery(query, null);
            //ShoppingValue shoppingValue1 = null;
           /* if (cursor.moveToFirst()) {
                do {/*
                    shoppingValue1 = new ShoppingValue();
                            shoppingValue1.setId(cursor.getLong(0));
                            shoppingValue1.setNome(cursor.getString(1));
                            shoppingValue1.setFav(cursor.getInt(2));
                    shoppingValue1.setId(Long.parseLong(cursor.getString(0)));
                    shoppings.add(shoppingValue1);
                }while (cursor.moveToNext());
            }*/
            //return shoppings;
        }

    }
