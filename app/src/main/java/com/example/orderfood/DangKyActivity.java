package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orderfood.DAO.NhanVienDAO;
import com.example.orderfood.DTO.NhanVienDTO;
import com.example.orderfood.Database.CreateDatabase;
import com.example.orderfood.FragmentApp.DatePickerFragment;

public class DangKyActivity extends AppCompatActivity implements View.OnClickListener , View.OnFocusChangeListener{

    EditText edTenDangNhapDK , edMatKhauDK, edNgaySinhDK , edCMNDDK;
    Button btnDongYDK, btnThoatDK ;
    RadioGroup rgGioiTinh;
    String sGioiTinh;
    NhanVienDAO nhanVienDAO;
    TextView register;
    CreateDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dangky);
        map();


        nhanVienDAO = new NhanVienDAO(this);
        btnDongYDK.setOnClickListener(this);
        btnThoatDK.setOnClickListener(this);
        edNgaySinhDK.setOnFocusChangeListener(this);

        database = new CreateDatabase(this);
//        Cursor dataCV = database.GetData("SELECT * FROM NHANVIEN");
//        while( dataCV.moveToNext()){
//            String name = dataCV.getString(1);
//            register.append(name);
//        }


    }

    private void map(){
        edTenDangNhapDK = (EditText) findViewById(R.id.edTenDangNhapDK);
        edMatKhauDK = (EditText) findViewById(R.id.edMatKhauDK);
        edNgaySinhDK = (EditText) findViewById(R.id.edNgaySinhDK);
        edCMNDDK = (EditText) findViewById(R.id.edCMNDDK);
        register = (TextView) findViewById(R.id.register);
        btnDongYDK = (Button) findViewById(R.id.btnDongYDK);
        btnThoatDK = (Button) findViewById(R.id.btnThoatDK);
        rgGioiTinh = (RadioGroup) findViewById(R.id.rgGioitinh);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnDongYDK:
                String sTenDangNhap = edTenDangNhapDK.getText().toString();
                String sMatKhau = edMatKhauDK.getText().toString();
                if(rgGioiTinh.getCheckedRadioButtonId() == R.id.rdNam ){
                    sGioiTinh = "Nam";
                }else if(rgGioiTinh.getCheckedRadioButtonId() == R.id.rdNu){
                    sGioiTinh = "Nữ";
                }


                String sNgaySinh = edNgaySinhDK.getText().toString();
                int iCMND = 0;
                try {
                    iCMND = Integer.parseInt(edCMNDDK.getText().toString());
                }catch (Exception e){

                }

                if(sTenDangNhap.equals("")){
                    Toast.makeText(DangKyActivity.this,R.string.DangNhapRequire,Toast.LENGTH_SHORT).show();
                }else if(sMatKhau.equals("")){
                    Toast.makeText(DangKyActivity.this,R.string.PassRequire,Toast.LENGTH_SHORT).show();
                }else{
                    NhanVienDTO nhanVienDTO = new NhanVienDTO();
                    nhanVienDTO.setTENDN(sTenDangNhap);
                    nhanVienDTO.setMATKHAU(sMatKhau);
                    nhanVienDTO.setNGAYSINH(sNgaySinh);
                    nhanVienDTO.setGIOITINH(sGioiTinh);
                    nhanVienDTO.setCMND(iCMND);

//                    database.QueryData("INSERT INTO NHANVIEN VALUES(null, '" + nhanVienDTO.getTENDN() + "' , '" + nhanVienDTO.getMATKHAU() + "' , '" + nhanVienDTO.getGIOITINH() + "' , '" + nhanVienDTO.getNGAYSINH() + "','" + nhanVienDTO.getCMND() + "' )");
                    long checkRegisterSuccess = nhanVienDAO.ThemNhanVien(nhanVienDTO);
                    if(checkRegisterSuccess != 0){
                        Toast.makeText(DangKyActivity.this,"Them thanh cong",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DangKyActivity.this,DangNhapActivity.class);
                        startActivity(intent);
                    }
                    else  Toast.makeText(DangKyActivity.this,"Them that bai",Toast.LENGTH_SHORT).show();


                }
                break;
            case R.id.btnThoatDK:
                finish();
                break;
        }

    }
    // bat su kien onfocus ngay sinh
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        int id = v.getId();
        switch (id){
            case R.id.edNgaySinhDK:
                if(hasFocus){

                    // xuat popup ngay sinh
                    DatePickerFragment datePickerFragment = new DatePickerFragment();
                    datePickerFragment.show(getSupportFragmentManager(),"Ngay Sinh");
                }
                break;
        }

    }




}
