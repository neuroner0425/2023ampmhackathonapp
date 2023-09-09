package com.test.2023ampmhackathon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CurfewMateDescAdapter extends BaseAdapter {
    private Context mContext;

    private ArrayList<String> userDataArrayList;

    public CurfewMateDescAdapter(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.userDataArrayList = arrayList;
    }

    @Override
    public int getCount() {
        return userDataArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(R.layout.layout_curfew_desc, null);

            CurfewMateViewHolder viewHolder = new CurfewMateViewHolder();
            viewHolder.CurfewMateDescTextView = (TextView) view.findViewById(R.id.layout_curfew_desc_text);

            view.setTag(viewHolder);
        }

        CurfewMateViewHolder viewHolder = (CurfewMateViewHolder) view.getTag();
        viewHolder.CurfewMateDescTextView.setText(userDataArrayList.get(position));

        return view;
    }

    private class CurfewMateViewHolder {
        TextView CurfewMateDescTextView;
    }
}
