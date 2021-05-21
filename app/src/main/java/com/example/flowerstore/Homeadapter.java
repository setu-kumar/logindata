package com.example.flowerstore;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Homeadapter extends ArrayAdapter {

    Activity context;
    String name[], phonenumber[], address[];
    int image[];

    public Homeadapter(Activity context, String[] name, String[] phonenumber, String[] address, int[] image) {
        super(context,R.layout.extra,name);
        this.context = context;
        this.name = name;
        this.phonenumber = phonenumber;
        this.address = address;
        this.image = image;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(R.layout.extra, null, true);
        TextView namee = v.findViewById(R.id.name);
        ImageView imagee = v.findViewById(R.id.image);
        TextView numberr = v.findViewById(R.id.phonenumber);
        TextView addresss = v.findViewById(R.id.address);
        namee.setText(name[position]);
        imagee.setImageResource(image[position]);
        numberr.setText(phonenumber[position]);
        addresss.setText(address[position]);
        return v;

    };

}

