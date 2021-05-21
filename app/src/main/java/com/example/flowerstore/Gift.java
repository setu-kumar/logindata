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
public class Gift extends Fragment {
    ListView gift;
    int[] images = {R.drawable.budhagift,R.drawable.gggg,R.drawable.gift3,R.drawable.gift2
            ,R.drawable.gift1,R.drawable.gifff,R.drawable.gi2,R.drawable.gi1,R.drawable.ggggg};
    String[] name={"rose","lotus","udggfud","gjhgdffj","jbdfjhdb","kjdhfjhd","jhdhhdf","hvdvdhgv","dhgvhg"};


    public Gift() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_gift, container, false);
        gift=  view.findViewById(R.id.gift);
        Giftadapter adapter = new Giftadapter(getActivity(),images,name);
        gift.setAdapter(adapter);


        return  view;

    }

}
