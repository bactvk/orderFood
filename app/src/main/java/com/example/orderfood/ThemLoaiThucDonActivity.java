package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orderfood.DAO.LoaiMonAnDAO;

public class ThemLoaiThucDonActivity extends AppCompatActivity {

    Button btnDongYThemLoaiThucDon;
    EditText edtTenLoai;
    LoaiMonAnDAO loaiMonAnDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_loai_thuc_don);

        loaiMonAnDAO = new LoaiMonAnDAO(this);
        btnDongYThemLoaiThucDon = (Button) findViewById(R.id.btnDongYThemLoaiThucDon);
        edtTenLoai = (EditText) findViewById(R.id.edtThemLoaiThucDon);

        btnDongYThemLoaiThucDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sNameLoaiThucDon = edtTenLoai.getText().toString();
                if(sNameLoaiThucDon.equals("")){
                    Toast.makeText(ThemLoaiThucDonActivity.this,getResources().getString(R.string.vuilongnhapdata),Toast.LENGTH_SHORT).show();

                }else{
                    boolean check = loaiMonAnDAO.ThemLoaiMonAn(sNameLoaiThucDon);
                    Intent iData = new Intent();
                    iData.putExtra("checkLoaiThucDon",check);
                    setResult(Activity.RESULT_OK,iData);

                    if(check){
                        Toast.makeText(ThemLoaiThucDonActivity.this,"Them loai mon an thanh cong",Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(ThemLoaiThucDonActivity.this,"Them loai mon an that bai",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
