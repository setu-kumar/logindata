package com.example.flowerstore;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Galleryadapter extends ArrayAdapter {
    Activity context;
    int images[];
    String a[];

    public Galleryadapter(Activity context, int[] images,String a[]) {
        super(context, R.layout.gallerylayout,a);
        this.context = context;
        this.images = images;
        this.a=a;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      //  return super.getView(position, convertView, parent);
        LayoutInflater inflater=context.getLayoutInflater();
        View v=inflater.inflate(R.layout.gallerylayout,null,false);
        ImageView imagee=v.findViewById(R.id.images);
        imagee.setImageResource(images[position]);
        TextView tv=v.findViewById(R.id.txt);
        tv.setText(a[position]);
        return v;
    }


}
