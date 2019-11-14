package com.example.retrofitexample002;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.Callback;

public class MyAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mlayoutinflator = null;
    ArrayList<Data.Progress> dataPt;

    public MyAdapter(MainActivity context, ArrayList<Data.Progress> data){
        mContext = context;
        dataPt = data;
        mlayoutinflator = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return dataPt.size();
    }

    @Override
    public Data.Progress getItem(int position) {
        return dataPt.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = mlayoutinflator.inflate(R.layout.list_layout, null);

        TextView timeView = (TextView)view.findViewById(R.id.time_view);
        TextView timeView2 = (TextView)view.findViewById(R.id.time_view2);
        TextView locationnameView = (TextView)view.findViewById(R.id.location_name_view);
        TextView statusView =(TextView)view.findViewById(R.id.status_text_view);
        TextView decriptionView = (TextView)view.findViewById(R.id.description_view);

        timeView.setText(dataPt.get(position).getTime().split("T")[0]);
        timeView2.setText(dataPt.get(position).getTime().split("T")[1].split(":")[0]+"시"+dataPt.get(position).getTime().split("T")[1].split(":")[0]);
        locationnameView.setText(dataPt.get(position).getLocation().getName());
        statusView.setText(dataPt.get(position).getStatus().getText());
        decriptionView.setText(dataPt.get(position).getDescription());

        return view;
    }
}
