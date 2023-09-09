package com.test.2023ampmhackathon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private final List<StudentInfo> listData;
    private final LayoutInflater layoutInflater;

    public CustomListAdapter(Context aContext, List<StudentInfo> listData) {
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
            convertView = layoutInflater.inflate(R.layout.customview, null);
            holder = new ViewHolder();
            holder.tvDormitoryName = (TextView) convertView.findViewById(R.id.tvDormitoryName);
            holder.tvStudentNumber = (TextView) convertView.findViewById(R.id.tvStudentNumber);
            holder.tvGender = (TextView) convertView.findViewById(R.id.tvGender);
            holder.tvMBTI = (TextView) convertView.findViewById(R.id.tvMBTI);
            holder.tvIsSmoker = (TextView) convertView.findViewById(R.id.tvIsSmoker);
            holder.tvIsSnorer = (TextView) convertView.findViewById(R.id.tvIsSnorer);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        StudentInfo studentInfo = this.listData.get(position);
        holder.tvDormitoryName.setText(studentInfo.getDormitoryName());
        holder.tvStudentNumber.setText(studentInfo.getStudentNumber());
        holder.tvGender.setText(studentInfo.getGender());
        holder.tvMBTI.setText(studentInfo.getMbti());
        holder.tvIsSmoker.setText(studentInfo.isSmoker() ? "담배: Yes" : "담배: No");
        holder.tvIsSnorer.setText(studentInfo.isSnorer() ? "코골이: Yes" : "코골이: No");

        return convertView;
    }

    static class ViewHolder {
        TextView tvDormitoryName;
        TextView tvStudentNumber;
        TextView tvGender;
        TextView tvMBTI;
        TextView tvIsSmoker;
        TextView tvIsSnorer;
    }
}

