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

import com.example.guiacalouros.ClassroomClass;
import com.example.guiacalouros.MainActivity;
import com.example.guiacalouros.UserClass;

import java.util.ArrayList;
import java.util.List;


public class ClassroomDAO extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "guia_classroom";
    public static final String COLUMN_TYPE = "TYPE";
    public static final String COLUMN_LOCATION = "LOCATION";
    public static final String COLUMN_REFERENCE = "REFERENCE";
    public static final String COLUMN_CODIGO = "CODIGO";

    public ClassroomDAO(@Nullable Context context) {
        super(context,"guia_ufjf_db",null ,1 );
    }

    //é chamado na primeira vez que o banco é acessado. Cria o banco
    @SuppressLint("SQLiteString")
    @Override
    public void onCreate(SQLiteDatabase db){
        String createTableStatement = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_TYPE + " STRING, " + COLUMN_LOCATION + " STRING, " + COLUMN_REFERENCE + " STRING," + COLUMN_REFERENCE + " CODIGO )" ;
        db.execSQL(createTableStatement);
    }

    //method é chamado se o banco for atualizado. Previne que a aplicação quebre ao mudar a estrutura do banco
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addClassroomC(ClassroomClass classroomClass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TYPE, classroomClass.getType());
        cv.put(COLUMN_LOCATION, classroomClass.getLocation());
        cv.put(COLUMN_REFERENCE, classroomClass.getReference());
        cv.put(COLUMN_CODIGO, classroomClass.getCodigo());

        long insert = db.insert(TABLE_NAME, null, cv);
        if(insert == -1)
            return false;


        return true;
    }

    public List<ClassroomClass> getEveryone(){
        List<ClassroomClass> returnList = new ArrayList<>();

        //get data from database
        String queryString = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()){
            do{
                int classroomId = cursor.getInt(0);
                String type = cursor.getString(1);
                String location = cursor.getString(2);
                String reference = cursor.getString(3);
                String codigo = cursor.getString(4);

                ClassroomClass classroom = new ClassroomClass(classroomId, type, location, reference, codigo);
                returnList.add(classroom );

            }while(cursor.moveToNext());
        }else{

        }
        cursor.close();
        db.close();
        return returnList;
    }

}