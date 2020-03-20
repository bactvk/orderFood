package com.example.orderfood.FragmentApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.orderfood.R;
import com.example.orderfood.ThemBanAnActivity;

public class HienThiBanAnFragment extends Fragment {

    public static int REQUEST_CODE_THEM = 11;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_hienthi_ban_an,container,false);
        //
        setHasOptionsMenu(true);
        return view;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        MenuItem itThemBanAn = menu.add(1,R.id.itThemBanAn,1,"Thêm bàn ăn");
        itThemBanAn.setIcon(R.drawable.thembanan);
        itThemBanAn.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.itThemBanAn:
                Intent iThemBanAn = new Intent(getActivity(), ThemBanAnActivity.class);  // getActivity() : TrangChuActivity
//                startActivity(iThemBanAn);
                startActivityForResult(iThemBanAn,REQUEST_CODE_THEM);
                break;
        }
//        return super.onOptionsItemSelected(item); // sài cho startActivity
        return true;
    }
}
