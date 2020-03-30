package com.example.orderfood.FragmentApp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.orderfood.CustomAddapter.AdapterHienThiBanAn;
import com.example.orderfood.DAO.BanAnDAO;
import com.example.orderfood.DTO.BanAnDTO;
import com.example.orderfood.R;
import com.example.orderfood.ThemBanAnActivity;
import com.example.orderfood.TrangChuActivity;

import java.util.List;

public class HienThiBanAnFragment extends Fragment {

    public static int REQUEST_CODE_THEM = 11;
    BanAnDAO banAnDAO;
    GridView gvHienThiBanAn;
    List<BanAnDTO> banAnDAOList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_hienthi_ban_an,container,false);
        //
        setHasOptionsMenu(true); // để fragment hiển thị bàn ăn là menu chứ ko phải fragment

        gvHienThiBanAn = (GridView) view.findViewById(R.id.gvHienThiBanAn);
        banAnDAO = new BanAnDAO(getActivity());
        banAnDAOList = banAnDAO.getListBanAn();

        AdapterHienThiBanAn adapterHienThiBanAn = new AdapterHienThiBanAn(getActivity(),R.layout.custom_layout_hienthibanan,banAnDAOList);
        gvHienThiBanAn.setAdapter(adapterHienThiBanAn);
        return view;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        MenuItem itThemBanAn = menu.add(1,R.id.itThemBanAn,1,"Thêm bàn ăn");
        itThemBanAn.setIcon(R.drawable.thembanan);
        itThemBanAn.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM); // hiển thị ra khi có chỗ trống
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.itThemBanAn:
//                Intent iThemBanAn = new Intent(getActivity(), ThemBanAnActivity.class);  // getActivity() : TrangChuActivity
//                startActivity(iThemBanAn);
//                startActivityForResult(iThemBanAn,REQUEST_CODE_THEM);

                DialogThemBanAn();
                break;
        }
//        return super.onOptionsItemSelected(item); // sài cho startActivity
        return true;
    }

    public void DialogThemBanAn(){
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.layout_them_banan);
        //set size
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        dialog.getWindow().setLayout((6 * width)/7, (2 * height)/7);

        final EditText edtNameBanAn = dialog.findViewById(R.id.edtNameBanAn_dialog);
        Button btnDongYThem = dialog.findViewById(R.id.btnDongYThemBanAn);

        banAnDAO = new BanAnDAO(getActivity());
        btnDongYThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sNameBanAn = edtNameBanAn.getText().toString();
                if(sNameBanAn.equals("")) Toast.makeText(getActivity(),"Please input name Ban An",Toast.LENGTH_SHORT).show();
                else{
                   boolean check = banAnDAO.ThemBanAn(sNameBanAn);
                   Log.d("check:", String.valueOf(check));
                    Toast.makeText(getActivity(),"Them Ban an thanh cong",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getActivity(), TrangChuActivity.class));
                   dialog.dismiss();
                }
            }
        });

        dialog.show();
    }
}
