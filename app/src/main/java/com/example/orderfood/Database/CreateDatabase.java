package com.example.orderfood.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CreateDatabase  extends SQLiteOpenHelper {
    //table
    public static String TB_NHANVIEN = "NHANVIEN";
    public static String TB_MONAN = "MONAN";
    public static String TB_LOAIMONAN = "LOAIMONAN";
    public static String TB_BANAN = "BANAN";
    public static String TB_GOIMON = "GOIMON";
    public static String TB_CHITIETGOIMON = "CHITIETGOIMON";
    //field
    public static String TB_NHANVIEN_MANV = "MANV";
    public static String TB_NHANVIEN_TENDN = "TENDN";
    public static String TB_NHANVIEN_MATKHAU = "MATKHAU";
    public static String TB_NHANVIEN_GIOITINH = "GIOITINH";
    public static String TB_NHANVIEN_NGAYSINH = "NGAYSINH";
    public static String TB_NHANVIEN_CMND = "CMND";

    public static String TB_MONAN_MAMON = "MAMON";
    public static String TB_MONAN_TENMONAN = "TENMONAN";
    public static String TB_MONAN_GIATIEN = "GIATIEN";
    public static String TB_MONAN_MALOAI = "MALOAI";

    public static String TB_LOAIMONAN_MAMON = "MALOAI";
    public static String TB_LOAIMONAN_TENMONAN = "TENLOAI";

    public static String TB_BANAN_MABAN = "MABAN";
    public static String TB_BANAN_MAMON = "TENBAN";
    public static String TB_BANAN_TINHTRANG = "TINHTRANG";

    public static String TB_GOIMON_MAGOIMON = "MAGOIMON";
    public static String TB_GOIMON_MAMNV = "MAMNV";
    public static String TB_GOIMON_NGAYGOI = "NGAYGOI";
    public static String TB_GOIMON_TINHTRANG = "TINHTRANG";
    public static String TB_GOIMON_MABAN = "MABAN";

    public static String TB_CHITIETGOIMON_MAID = "MAID";
    public static String TB_CHITIETGOIMON_MAGOIMON = "MAGOIMON";
    public static String TB_CHITIETGOIMON_MAMONAN = "MAMONAN";
    public static String TB_CHITIETGOIMON_SOLUONG = "SOLUONG";



    public CreateDatabase(@Nullable Context context) {
        super(context, "OrderFood", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db = getWritableDatabase();
         // CREATE TABLE table_name ( id INTEGER PRIMARY KEY AUTOINCREMENT , name TEXT , birthday TEXT )
        String tbNHANVIEN = " CREATE TABLE IF NOT EXISTS " + TB_NHANVIEN + " ("
                + TB_NHANVIEN_MANV + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_NHANVIEN_TENDN + " TEXT, "
                + TB_NHANVIEN_MATKHAU + " TEXT, "
                + TB_NHANVIEN_GIOITINH + " TEXT, "
                + TB_NHANVIEN_NGAYSINH + " TEXT, "
                + TB_NHANVIEN_CMND + " INTEGER "
                + ")";

        String tbBANAN = "CREATE TABLE IF NOT EXISTS " + TB_BANAN + " ("
                + TB_BANAN_MABAN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_BANAN_MAMON + " TEXT, "
                + TB_BANAN_TINHTRANG + " TEXT "
                + ")";

        String tbMONAN = "CREATE TABLE IF NOT EXISTS " + TB_MONAN + " ("
                + TB_MONAN_MAMON + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_MONAN_TENMONAN + " TEXT, "
                + TB_MONAN_GIATIEN + " INTEGER, "
                + TB_MONAN_MALOAI + " TEXT "
                + ")";

        String tbLOAIMON = "CREATE TABLE IF NOT EXISTS " + TB_LOAIMONAN + " ("
                + TB_LOAIMONAN_MAMON + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_LOAIMONAN_TENMONAN + " TEXT "
                + ")";

        String tbGOIMON = "CREATE TABLE IF NOT EXISTS " + TB_GOIMON + " ("
                + TB_GOIMON_MAGOIMON + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_GOIMON_MAMNV + " INTEGER, "
                + TB_GOIMON_NGAYGOI + " TEXT, "
                + TB_GOIMON_TINHTRANG + " TEXT, "
                + TB_GOIMON_MABAN + " INTEGER "
                + ")";

        String tbCHITIETGOIMON = "CREATE TABLE IF NOT EXISTS " + TB_CHITIETGOIMON + " ("
                + TB_CHITIETGOIMON_MAID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_CHITIETGOIMON_MAGOIMON + " INTEGER, "
                + TB_CHITIETGOIMON_MAMONAN + " TEXT, "
                + TB_CHITIETGOIMON_SOLUONG + " INTEGER "
                + ")";

        db.execSQL(tbNHANVIEN);
        db.execSQL(tbBANAN);
        db.execSQL(tbMONAN);
        db.execSQL(tbLOAIMON);
        db.execSQL(tbGOIMON);
        db.execSQL(tbCHITIETGOIMON);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public SQLiteDatabase open(){
        return this.getWritableDatabase();
    }

    // truy van khong tra ket qua : CREATE , INSERT , UPDATE , DELETE
    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();  // ( getWira : vua ghi vua doc)
        database.execSQL(sql);

    }

    // truy van co tra ket qua : SELECT
    public Cursor GetData(String sql){
        SQLiteDatabase database = getReadableDatabase(); // cho doc :  chi lay data ra - > doc)
        return database.rawQuery(sql,null);
    }

    public void openDB(){
        SQLiteDatabase database = getWritableDatabase();
    }
}
