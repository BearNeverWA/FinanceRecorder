package com.callmebear.financerecorder;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/*
 * Created by Call Me Bear on 2016/5/15.
 */
public class RecordersAdapter extends BaseAdapter {
    private Context context;
    private Cursor cursor;
    private LinearLayout layout;

    public RecordersAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;
    }

    @Override
    public int getCount() {
        return cursor.getCount();
    }

    @Override
    public Object getItem(int position) {
        return cursor.getPosition();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        layout = (LinearLayout) inflater.inflate(R.layout.recorder_cell, null);
        TextView valuetv = (TextView) layout.findViewById(R.id.list_value);
        TextView mattertv = (TextView) layout.findViewById(R.id.list_matter);
        TextView timetv = (TextView) layout.findViewById(R.id.list_time);
        cursor.moveToPosition(position);
        String value = cursor.getString(cursor.getColumnIndex("value"));
        String matter = cursor.getString(cursor.getColumnIndex("matter"));
        String time = cursor.getString(cursor.getColumnIndex("time"));
        valuetv.setText(value);
        mattertv.setText(matter);
        timetv.setText(time);
        return layout;
    }
}
