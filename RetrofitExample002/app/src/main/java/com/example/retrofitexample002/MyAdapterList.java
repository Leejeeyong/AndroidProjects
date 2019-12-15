package com.example.retrofitexample002;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapterList extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mlayoutinflator = null;
    ArrayList<String> dataCa;
    ArrayList<String> dataTr;

    public MyAdapterList(MainActivity context, ArrayList data1, ArrayList data2){
        mContext = context;
        dataCa = data1;
        dataTr = data2;
        mlayoutinflator = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return dataCa.size();
    }

    @Override
    public String getItem(int position) { return dataCa.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = mlayoutinflator.inflate(R.layout.list_layout2, null);

        TextView textView = (TextView)view.findViewById(R.id.textView);
        TextView textView2 = (TextView)view.findViewById(R.id.textView2);

        textView.setText(dataCa.get(position));
        textView2.setText(dataTr.get(position));

        return view;
    }
}
