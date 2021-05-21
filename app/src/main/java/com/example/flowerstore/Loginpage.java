package com.example.flowerstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Loginpage extends AppCompatActivity {
    EditText email,password;
    Button button;
    Button button1;
    //ImageButton button1, button2;
   // TextView button3;

    Databasehandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);




   db = new Databasehandler(this);
//
//        //  Log.d("Reading: ", "Reading  contacts..");
//        Contact contact=     db.getContact(email.getText().toString());
//        Toast.makeText(this, ""+contact.getEmail(), Toast.LENGTH_SHORT).show();
       // Contact contact1=db.getContact(password.getText().toString());
//if (contact.getEmail().equals(email.getText().toString()))
//{        Toast.makeText(Loginpage.this,"Reading" ,Toast.LENGTH_LONG).show();


//}
//else{
        //  Toast.makeText(Loginpage.this, "not found", Toast.LENGTH_SHORT).show();
//}

        //          }
        //
        button = findViewById(R.id.login);
            button1 = findViewById(R.id.sign);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

if(email.getText().toString().equals("") && password.getText().toString().equals(""))
{
                        Toast.makeText(Loginpage.this, "enter valid user id pasword", Toast.LENGTH_SHORT).show();

                    }
else {

    Log.d("Reading: ", "Reading  contacts..");
    Contact contact = db.getContact(email.getText().toString());
    Toast.makeText(Loginpage.this, "" + contact.getEmail(), Toast.LENGTH_SHORT).show();
    // Contact contact1=db.getContact(password.getText().toString());


    if (contact.getEmail().equals(email.getText().toString()) && contact.getPassword().equals(password.getText().toString())) {
        Toast.makeText(Loginpage.this, "Reading", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Loginpage.this, MainActivity.class);
        startActivity(intent);

    } else {
        Toast.makeText(Loginpage.this, "not found", Toast.LENGTH_SHORT).show();
    }
}               }


            });
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Loginpage.this, Signuppage.class);
                    startActivity(intent);
                }
            });
        }
    }
