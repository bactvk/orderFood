package com.example.orderfood.CustomAddapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orderfood.DTO.BanAnDTO;
import com.example.orderfood.R;

import java.util.List;

public class AdapterHienThiBanAn extends BaseAdapter implements View.OnClickListener {

    Context context;
    int layout;
    List<BanAnDTO> banAnDTOList;
    ViewHolder viewHolder;

    public AdapterHienThiBanAn(Context context, int layout, List<BanAnDTO> banAnDTOList) {
        this.context = context;
        this.layout = layout;
        this.banAnDTOList = banAnDTOList;
    }

    @Override
    public int getCount() {
        return banAnDTOList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    public class ViewHolder{
        ImageView imgBanAn, imgGoiMon , imgThanhToan , imgAnButton;
        TextView txtTenBanAn;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.custom_layout_hienthibanan,parent,false);
            viewHolder.imgBanAn = convertView.findViewById(R.id.imgBanAn);
            viewHolder.imgGoiMon = convertView.findViewById(R.id.imgGoimon);
            viewHolder.imgThanhToan = convertView.findViewById(R.id.imgThanhtoan);
            viewHolder.imgAnButton = (ImageView) convertView.findViewById(R.id.imgAnButton);
            viewHolder.txtTenBanAn = (TextView) convertView.findViewById(R.id.txtNameBanAn);

            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if(banAnDTOList.get(position).isDuocChon()){
            ShowButton();
        }else{
            HideButton();
        }
        BanAnDTO banAnDTO = banAnDTOList.get(position);
        viewHolder.txtTenBanAn.setText(banAnDTO.getTenBan());

        viewHolder.imgBanAn.setTag(position); // luu vi tri ban an


        viewHolder.imgBanAn.setOnClickListener(this);
        viewHolder.imgGoiMon.setOnClickListener(this);
        viewHolder.imgThanhToan.setOnClickListener(this);

        return convertView;
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        viewHolder = (ViewHolder) ((View) v.getParent()).getTag();
        switch (id){
            case R.id.imgBanAn:

                ShowButton();

                int vitri = (int) v.getTag();
                banAnDTOList.get(vitri).setDuocChon(true);

                break;
        }
    }

    private void ShowButton(){
        viewHolder.imgGoiMon.setVisibility(View.VISIBLE);
        viewHolder.imgThanhToan.setVisibility(View.VISIBLE);
        viewHolder.imgAnButton.setVisibility(View.VISIBLE);
    }
    private void HideButton(){
        viewHolder.imgGoiMon.setVisibility(View.INVISIBLE);
        viewHolder.imgThanhToan.setVisibility(View.INVISIBLE);
        viewHolder.imgAnButton.setVisibility(View.INVISIBLE);
    }
}
