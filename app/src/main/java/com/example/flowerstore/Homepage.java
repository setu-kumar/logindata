package com.example.flowerstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Homepage extends AppCompatActivity {
    ListView homepage;
    ShopDetails s;
    String[] name={"Greens of Highgate","The Flower Shop","Flori's","Nature's Gift Flower Shop","Garden Centre","Flora And Nora","Pike Place Flowers","Bethesda Florist","El Florista","Forum Florist"};
    String[] phonenumber={"7844556000","9866415000","8845955000","22436578","9910178735","8377024287","7988472411","9999568890","9504454903","7056009794","9931010427","7782956727"};
    String[] address={"Sector-56,Chandigarh","Sector-76,Chandigarh","Sector-66,Chandigarh","Phase-4,Mohali","Phase-7,Mohali(chandhigarh)","Phase-10,Mohali(Chandhigarh)","Sector-22,Near Market,Chadhigarh","PCL Chock,Mohali","Phase-6,Near Elanta Mall,Chandhigarh","Near V Mart,Mohali"};
    int[] images={R.drawable.flower,R.drawable.flower1,R.drawable.flower2,R.drawable.flower3,R.drawable.flower4,R.drawable.flower5,R.drawable.flower6,R.drawable.flower7,R.drawable.flower8,R.drawable.flower9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_homepage);
        setContentView(R.layout.activity_homepage);
        homepage=findViewById(R.id.list);

        Homeadapter adapter= new Homeadapter(Homepage.this,name,phonenumber,address,images);

        homepage.setAdapter(adapter);
        homepage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String phn=((TextView)view.findViewById(R.id.phonenumber)).getText().toString();

                Intent intent =new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phn));
                startActivity(intent);



            }
        });
    }
}
