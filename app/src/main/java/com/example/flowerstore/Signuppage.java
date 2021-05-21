package com.example.flowerstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Signuppage extends AppCompatActivity {
    EditText name, email, phone, password;

    Button button;

    Databasehandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);
        email = findViewById(R.id.Email);
        name = findViewById(R.id.Name);
        password = findViewById(R.id.Pass);
        phone = findViewById(R.id.Phone);
        db = new Databasehandler(this);

        addListenerOnButton();
    }

    public void addListenerOnButton() {
        button = findViewById(R.id.signup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long i = db.addContact(new Contact(email.getText().toString(), name.getText().toString(), phone.getText().toString(), password.getText().toString()));
                if (i > 0) {
                    Toast.makeText(Signuppage.this, "inserted", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(Signuppage.this, "inserted", Toast.LENGTH_SHORT).show();

                }


                List<Contact> contac = db.getAllContacts();

                for (Contact cn: contac) {
                    String log = "id: " + cn.getEmail() + " ,Name: " + cn.getName() + " ,Phone: " +
                            cn.getPhoneNumber();
                    // Writing Contacts to log
                }
            }
        });
    }
}
