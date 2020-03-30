package com.example.orderfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.orderfood.DTO.BanAnDTO;
import com.example.orderfood.Database.CreateDatabase;

import java.util.ArrayList;
import java.util.List;

public class BanAnDAO {
    SQLiteDatabase database;
    public BanAnDAO(Context context){
        CreateDatabase createDatabase = new CreateDatabase(context);
        database = createDatabase.open();
    }

    public boolean ThemBanAn(String name){
        ContentValues contentValues = new ContentValues();

        contentValues.put(CreateDatabase.TB_BANAN_TENBAN,name);
        contentValues.put(CreateDatabase.TB_BANAN_TINHTRANG,"false");

        long check = database.insert(CreateDatabase.TB_BANAN,null,contentValues);
        if(check != 0) return true;
        return false;
    }

    public List<BanAnDTO> getListBanAn(){
        List<BanAnDTO> banAnDTOList = new ArrayList<BanAnDTO>();

//        String sqlUpdate = "UPDATE " + CreateDatabase.TB_BANAN + " SET " + CreateDatabase.TB_BANAN_TENBAN + " = 'ban 1'" + " WHERE "+CreateDatabase.TB_BANAN_MABAN + " = 2";
//        database.execSQL(sqlUpdate);

        String sql = "SELECT * FROM "+ CreateDatabase.TB_BANAN;
        Cursor cursor = database.rawQuery(sql,null);
        while(cursor.moveToNext()){
            BanAnDTO banAnDTO = new BanAnDTO();
            banAnDTO.setMaBan(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_BANAN_MABAN)));
            banAnDTO.setTenBan(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_BANAN_TENBAN)));

            banAnDTOList.add(banAnDTO);
        }
        return banAnDTOList;
    }
}
