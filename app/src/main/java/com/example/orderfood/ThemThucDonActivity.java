package com.example.orderfood;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class ThemThucDonActivity extends AppCompatActivity implements View.OnClickListener {

    public static int REQUEST_CODE_THEM_LOAI_THUC_DON = 114;
    ImageButton imThemLoaiThucDon;
    Spinner spinnerLoaiThucDon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_thuc_don);

        imThemLoaiThucDon = (ImageButton) findViewById(R.id.imThemLoaiThucDon);
        spinnerLoaiThucDon = (Spinner) findViewById(R.id.spinLoaiMonAn);

        imThemLoaiThucDon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.imThemLoaiThucDon:
                Intent iThemLoaiMonAn = new Intent(ThemThucDonActivity.this,ThemLoaiThucDonActivity.class);
                startActivityForResult(iThemLoaiMonAn,REQUEST_CODE_THEM_LOAI_THUC_DON);

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_THEM_LOAI_THUC_DON){
            if(resultCode == Activity.RESULT_OK){
                Intent Dulieu = data;
                boolean check = Dulieu.getBooleanExtra("checkLoaiThucDon",false);
                if(check){
                    Toast.makeText(ThemThucDonActivity.this,"Them loai mon an thanh cong",Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(ThemThucDonActivity.this,"Them loai mon an that bai",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
