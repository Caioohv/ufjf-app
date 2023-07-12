package com.example.guiacalouros;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DatabaseConnection extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "guia_user";
    public static final String COLUMN_CPF = "CPF";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_PASSWORD = "PASSWORD";
    public static final String COLUMN_EMAIL = "EMAIL";

    public DatabaseConnection(@Nullable Context context) {
        super(context,"guia_ufjf_db",null ,1 );
    }

    //é chamado na primeira vez que o banco é acessado. Cria o banco
    @SuppressLint("SQLiteString")
    @Override
    public void onCreate(SQLiteDatabase db){
        String createTableStatement = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CPF + " STRING, " + COLUMN_NAME + " STRING, " + COLUMN_PASSWORD + " STRING , " + COLUMN_EMAIL + " STRING) ";

        db.execSQL(createTableStatement);
    }

    //method é chamado se o banco for atualizado. Previne que a aplicação quebre ao mudar a estrutura do banco
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(GuiaUser guiaUser){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CPF, guiaUser.getCpf());
        cv.put(COLUMN_EMAIL, guiaUser.getEmail());
        cv.put(COLUMN_NAME, guiaUser.getName());
        cv.put(COLUMN_PASSWORD, guiaUser.getPassword());

        long insert = db.insert(TABLE_NAME, null, cv);
        if(insert == -1)
            return false;


        return true;
    }
}