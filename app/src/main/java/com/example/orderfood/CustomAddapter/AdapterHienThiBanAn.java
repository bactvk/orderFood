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

public class AdapterHienThiBanAn extends BaseAdapter {

    Context context;
    int layout;
    List<BanAnDTO> banAnDTOList;

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

        ViewHolder viewHolder;
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

        BanAnDTO banAnDTO = banAnDTOList.get(position);
        viewHolder.txtTenBanAn.setText(banAnDTO.getTenBan());

        return convertView;
    }
}
