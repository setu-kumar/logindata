package com.example.flowerstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Mygallery extends AppCompatActivity
{
GridView grid;
String a[]={"1 ","2","3","4","5","6","7","8","9","10","11"};
static final int[] image ={
        R.drawable.facebook,R.drawable.flower,R.drawable.flower1,R.drawable.flower2,R.drawable.flower3,
        R.drawable.flower4,R.drawable.flower5,R.drawable.flower6,
        R.drawable.flower7,R.drawable.flower8,R.drawable.flower9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mygallery);

        grid = findViewById(R.id.grid);
        Galleryadapter adapter= new Galleryadapter(this,image,a);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"jj",Toast.LENGTH_LONG).show();
            }
        });
    }

}

