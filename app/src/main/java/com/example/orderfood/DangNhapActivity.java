package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orderfood.DAO.NhanVienDAO;
import com.example.orderfood.Database.CreateDatabase;

public class DangNhapActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnDangNhap , btnDangky;
    EditText edtNameDangNhap , edtPassDangNhap;
    NhanVienDAO nhanVienDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dangnhap);

        btnDangNhap = (Button) findViewById(R.id.btnDangNhap);
        btnDangky = (Button) findViewById(R.id.btnDangKy);
        edtNameDangNhap = (EditText) findViewById(R.id.edtTenDangNhap);
        edtPassDangNhap = (EditText) findViewById(R.id.edtMkDangNhap);

        nhanVienDAO = new NhanVienDAO(this);
        btnDangNhap.setOnClickListener(this);
        btnDangky.setOnClickListener(this);

        //ShowButtonRegister();
    }

    private void ShowButtonRegister(){
        boolean check = nhanVienDAO.CheckEmployee();
        if(check)  btnDangky.setVisibility(View.GONE);
        else btnDangky.setVisibility(View.VISIBLE);
    }

    private void processBtnLogin(){
        String snameLogin = edtNameDangNhap.getText().toString();
        String sPass = edtPassDangNhap.getText().toString();

        boolean check = nhanVienDAO.checkLogin(snameLogin,sPass);
        if(check){
            Toast.makeText(DangNhapActivity.this,"Dang nhap thanh cong",Toast.LENGTH_SHORT).show();
            Intent iTrangChu = new Intent(DangNhapActivity.this,TrangChuActivity.class);
            iTrangChu.putExtra("tenDN",edtNameDangNhap.getText().toString());
            startActivity(iTrangChu);
        }
        else Toast.makeText(DangNhapActivity.this,"Dang nhap that bai",Toast.LENGTH_SHORT).show();
    }

    private void processBtnRegister(){
        Intent iDangKy = new Intent(DangNhapActivity.this,DangKyActivity.class);
        startActivity(iDangKy);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnDangNhap:
                processBtnLogin();
                break;
            case R.id.btnDangKy:
                processBtnRegister();
                break;
        }
    }
}
