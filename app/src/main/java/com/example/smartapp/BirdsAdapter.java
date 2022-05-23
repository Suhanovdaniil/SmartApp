package com.example.smartapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BirdsAdapter extends ArrayAdapter<Birds> {
    public BirdsAdapter(Context context, Birds[] arr) {
        super(context, R.layout.info_list, arr);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Birds birds = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.info_list, null);
        }


// Заполняем адаптер
        ((TextView) convertView.findViewById(R.id.birds_name)).setText(birds.name);
        ((ImageView) convertView.findViewById(R.id.iv_icon)).setImageResource(birds.photo_res);
        return convertView;
    }
}
