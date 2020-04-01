package com.example.orderfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.orderfood.Database.CreateDatabase;

public class LoaiMonAnDAO {
    SQLiteDatabase database;
    public LoaiMonAnDAO(Context context){
        CreateDatabase createDatabase = new CreateDatabase(context);
        database = createDatabase.open();

    }

    public boolean ThemLoaiMonAn(String name){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.TB_LOAIMONAN,name);

        long check = database.insert(CreateDatabase.TB_LOAIMONAN,null,contentValues);
        if(check != 0) return true;
        return false;
    }
}
