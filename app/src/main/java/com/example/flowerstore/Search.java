package com.example.flowerstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class Search extends AppCompatActivity implements  searchadapter.SearchsAdapterListener  {
    RecyclerView rvItems;

    SearchView svMovies;

    String[] name={"Greens of Highgate","The Flower Shop","Flori's","Nature's Gift Flower Shop","Garden Centre","Flora And Nora","Pike Place Flowers","Bethesda Florist","El Florista","Forum Florist"};
    String[] phone={"7844556000","9866415000","8845955000","22436578","9910178735","8377024287","7988472411","9999568890","9504454903","7056009794","9931010427","7782956727"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        svMovies = findViewById(R.id.svMovies);
       rvItems= findViewById(R.id.rvItems);


        List<String> list = new ArrayList<>();
        list.add("Greens of Highgate");
        list.add("The Flower Shop");
        list.add("rose");
        list.add("lotus");
        list.add("lilly");
        list.add("marrygold");
        list.add("goldenrosr");
        list.add("roshpush");
        list.add("buddha");
        list.add("ganesh");
        list.add("krishna");
        list.add("wallhanging");


   final      searchadapter adapter = new searchadapter(this, list, this);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());
        rvItems.setLayoutManager(lm);
        rvItems.setItemAnimator(new DefaultItemAnimator());
        rvItems.setAdapter(adapter);

        svMovies.setActivated(true);
        svMovies.setQueryHint("Type your keyword here");
        svMovies.onActionViewExpanded();
        svMovies.setIconified(false);
        svMovies.clearFocus();

        svMovies.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }


    @Override
    public void onBackPressed() {
        // close search view on back button pressed
        if (!svMovies.isIconified()) {
            svMovies.setIconified(true);
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onSelected(String item) {
        Toast.makeText(this, "Selected: " + item, Toast.LENGTH_LONG).show();
    }

}
