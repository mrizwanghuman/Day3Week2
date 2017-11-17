package com.example.admin.day3week2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by  Admin on 11/16/2017.
 */

public class CelAdapter extends ArrayAdapter<Celebrity> {
    public CelAdapter(@NonNull Context context, int resource, @NonNull List<Celebrity> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

if(convertView==null){
convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cel_cutom_view,null);
    TextView lvNames = convertView.findViewById(R.id.tvCelName);
    ImageView celPic = convertView.findViewById(R.id.celPic);
    Celebrity celebrity = getItem(position);
    if (celebrity!=null){
        lvNames.setText(celebrity.getName());
        celPic.setImageResource(celebrity.imageId);
    }
}
        return convertView;
    }
}
