package com.example.flowerstore;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Flower extends Fragment {
    ListView flower;
    int[] images = {R.drawable.tulip,R.drawable.rose,R.drawable.rosebush,R.drawable.pinklily,R.drawable.orchids
            ,R.drawable.hybrid,R.drawable.background,R.drawable.dahlias,
            R.drawable.bethan,R.drawable.bleeding,R.drawable.cosmos};
    String[] name={"Tulip","Rose","Rosebush","PinkLily","Orchids","Hybrid","African Lily","Dahlias","Bethan","Bleeding Hybrid","Cosmos"};

    public Flower() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_flower, container, false);
      flower=  view.findViewById(R.id.flower);
        Floweradapter adapter = new Floweradapter(getActivity(),name,images);
        flower.setAdapter(adapter);


return  view;
    }


}
