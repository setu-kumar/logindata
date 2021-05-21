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
public class Decoration extends Fragment {
    ListView decoration;
    int[] images = {R.drawable.dec,R.drawable.dec1,R.drawable.decoration,R.drawable.decoration1,R.drawable.decoration2,
            R.drawable.decoration3,R.drawable.decoration4,R.drawable.decoration5,R.drawable.decoration6};
    String[] name={"rose","lotus","ygfuygf","gddhdh","hgygyu","hdhdhdhh","gdhdyd","jbdjhdfjh","jdjgfu"};


    public Decoration() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_decoration, container, false);
        decoration=  view.findViewById(R.id.decoration);
       Decorationadapter adapter = new Decorationadapter(getActivity(),name,images);
        decoration.setAdapter(adapter);


        return  view;
    }

}
