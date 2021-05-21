package com.example.flowerstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class Search2 extends AppCompatActivity {
SearchView search;
ListView list1;
ArrayList<String> list;
ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search2);
        search=findViewById(R.id.search);
        list1=findViewById(R.id.list1);

        list= new ArrayList<>();
        list.add("rose");
        list.add("rosebush");
        list.add("lily");
        list.add("lotus");
        list.add("marygold");
        list.add("orchids");
        list.add("buddha");


        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        list1.setAdapter(adapter);
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if(list.contains(s)){
                    adapter.getFilter().filter(s);

                }
                else{
                    Toast.makeText(Search2.this, "Not Found", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }
}
