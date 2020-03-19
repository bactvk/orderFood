package com.example.orderfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.orderfood.DTO.NhanVienDTO;
import com.example.orderfood.Database.CreateDatabase;

public class NhanVienDAO {

    SQLiteDatabase database;
    CreateDatabase createDatabase;
    Context context;
    public NhanVienDAO(Context context){
        this.context = context;
        CreateDatabase createDatabase = new CreateDatabase(context);
        database = createDatabase.open();
    }

    public long ThemNhanVien(NhanVienDTO nhanVienDTO){ // them thanh cong tra ve id cua nhanvien
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.TB_NHANVIEN_TENDN , nhanVienDTO.getTENDN());
        contentValues.put(CreateDatabase.TB_NHANVIEN_CMND, nhanVienDTO.getCMND());
        contentValues.put(CreateDatabase.TB_NHANVIEN_GIOITINH , nhanVienDTO.getGIOITINH());
        contentValues.put(CreateDatabase.TB_NHANVIEN_MATKHAU , nhanVienDTO.getMATKHAU());
        contentValues.put(CreateDatabase.TB_NHANVIEN_NGAYSINH , nhanVienDTO.getNGAYSINH());

        long check = database.insert(CreateDatabase.TB_NHANVIEN,null,contentValues);

        return check;

    }

    public boolean CheckEmployee(){

        String sql = "SELECT * FROM "+ CreateDatabase.TB_NHANVIEN;
        Cursor cursor = database.rawQuery(sql,null);
        if(cursor.getCount() != 0 ) return true;
        return false;
    }

    public boolean checkLogin(String nameLogin,String passLogin){
        String sql = " SELECT * FROM "+ CreateDatabase.TB_NHANVIEN + " WHERE " + CreateDatabase.TB_NHANVIEN_TENDN + " = '" + nameLogin + "' AND "
                + CreateDatabase.TB_NHANVIEN_MATKHAU + " = '" +  passLogin +  "'" ;

        Cursor cursor = database.rawQuery(sql,null);
        if(cursor.getCount() != 0) return true;
        return false;
    }

}
