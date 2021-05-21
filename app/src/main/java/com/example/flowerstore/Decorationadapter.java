package com.example.flowerstore;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Decorationadapter extends ArrayAdapter {
    Activity context;
    String name[];
    int images[];

    public Decorationadapter(Activity context, String[] name, int[] images) {
        super(context,R.layout.decorationlayout,name);
        this.context = context;
        this.name = name;
        this.images = images;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // return super.getView(position, convertView, parent);
        LayoutInflater inflater=context.getLayoutInflater();
        View v=inflater.inflate(R.layout.decorationlayout,null,true);
        TextView namee=v.findViewById(R.id.name);
        ImageView imagee=v.findViewById(R.id.images);
        namee.setText(name[position]);
        imagee.setImageResource(images[position]);
        return v;

    };
}
