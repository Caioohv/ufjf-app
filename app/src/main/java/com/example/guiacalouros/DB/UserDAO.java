package com.example.guiacalouros.DB;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.guiacalouros.MainActivity;
import com.example.guiacalouros.UserClass;

import java.util.ArrayList;
import java.util.List;


public class UserDAO extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "guia_user";
    public static final String COLUMN_CPF = "CPF";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_PASSWORD = "PASSWORD";
    public static final String COLUMN_EMAIL = "EMAIL";
    public static final String COLUMN_APPROVED = "APPROVED";

    public UserDAO(@Nullable Context context) {
        super(context,"guia_ufjf_db",null ,1 );
    }

    //é chamado na primeira vez que o banco é acessado. Cria o banco
    @SuppressLint("SQLiteString")
    @Override
    public void onCreate(SQLiteDatabase db){
        String createTableStatement = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CPF + " STRING, " + COLUMN_NAME + " STRING, " + COLUMN_PASSWORD + " STRING , " + COLUMN_EMAIL + " STRING, " + COLUMN_APPROVED + " BOOLEAN) ";

        db.execSQL(createTableStatement);
    }

    //method é chamado se o banco for atualizado. Previne que a aplicação quebre ao mudar a estrutura do banco
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addUser(UserClass userClass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CPF, userClass.getCpf());
        cv.put(COLUMN_EMAIL, userClass.getEmail());
        cv.put(COLUMN_NAME, userClass.getName());
        cv.put(COLUMN_PASSWORD, userClass.getPassword());
        cv.put(COLUMN_APPROVED, userClass.getApproved());

        long insert = db.insert(TABLE_NAME, null, cv);
        if(insert == -1)
            return false;


        return true;
    }

    public List<UserClass> getEveryone(){
        List<UserClass> returnList = new ArrayList<>();

        //get data from database
        String queryString = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()){
            do{
                int userId = cursor.getInt(0);
                String cpf = cursor.getString(1);
                String email = cursor.getString(2);
                String name = cursor.getString(3);
                String password = cursor.getString(4);
                boolean approved = cursor.getInt(4) == 1 ? true : false;

                UserClass user = new UserClass(userId,name, cpf, email, password, approved );
                returnList.add(user);

            }while(cursor.moveToNext());
        }else{

        }
        cursor.close();
        db.close();
        return returnList;
    }

    public UserClass getUser(String cpf, String password){
        Log.e("Select", cpf);
        String queryString = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_CPF + " = '" + cpf + "' AND PASSWORD = '" + password + "'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()){
            int userId = cursor.getInt(0);
            String cpfQuery = cursor.getString(1);
            String email = cursor.getString(2);
            String name = cursor.getString(3);
            String passwordQuery = cursor.getString(4);
            boolean approved = cursor.getInt(4) == 1 ? true : false;

            UserClass user = new UserClass(userId,name, cpfQuery, email, passwordQuery, approved);
            cursor.close();
            db.close();
            return user;
        }else{
            cursor.close();
            db.close();
            return null;
        }
    }
}