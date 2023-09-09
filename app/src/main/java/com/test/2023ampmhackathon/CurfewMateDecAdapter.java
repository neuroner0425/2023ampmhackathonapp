package com.test.2023ampmhackathon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class CurfewMateDecAdapter extends BaseAdapter {
    private final List<CurfewMateInfo> listData;
    private final LayoutInflater layoutInflater;

    public CurfewMateDecAdapter(Context aContext, List<CurfewMateInfo> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.curfewview, null);
            holder = new ViewHolder();
            holder.tvTime = (TextView) convertView.findViewById(R.id.tvTime);
            holder.tvDormName = (TextView) convertView.findViewById(R.id.tvDormName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        CurfewMateInfo curfewInfo = this.listData.get(position);
        holder.tvTime.setText(curfewInfo.getTime().toString());
        holder.tvDormName.setText(curfewInfo.getDormname());

        return convertView;
    }

    static class ViewHolder {
        TextView tvTime;
        TextView tvDormName;
    }
}