package com.example.mad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context) {
        super(context, "userData.DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table userdetail(name TEXT, email TEXT primary key, Password Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase BD, int i, int i1) {
        BD.execSQL("drop Table if exists userdetail");
    }
    public  Boolean insertuserdata(String name, String email, String Password){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", Password);
        long result = DB.insert("userdetail", null, contentValues);
        if (result == -1){
            return false;
        }else {
            return true;
        }
    }

    public  Boolean updateuserdata(String name, String email, String Password){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", Password);
        Cursor cursor = DB.rawQuery("Select * from userdetail where email =?", new String[]{email});
        if (cursor.getCount()>-1)
        {
            long result = DB.insert("userdetail", null, contentValues);
            if (result == -1){
                return false;
            }else {
                return true;
            }  }else {
            return false;
        }
    }

    public  Boolean deleteuserdata(String email){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Cursor cursor = DB.rawQuery("Select * from userdetail where email =?", new String[]{email});
        if (cursor.getCount()>-1)
        {
            long result = DB.delete("userdetail", "name=?", new String[]{email});
            if (result == -1){
                return false;
            }else {
                return true;
            }  }else {
            return false;
        }
    }


    public  Cursor view(){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Cursor cursor = DB.rawQuery("Select * from userdetail", null);
        return cursor;
    }
}

