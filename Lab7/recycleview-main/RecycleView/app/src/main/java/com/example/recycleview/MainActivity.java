package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvContacts = findViewById(R.id.rvContacts);
        // rvContacts.setHasFixedSize(true)
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        List<Contact> contacts = Contact.getContacts();
        ContactAdapter adapter = new ContactAdapter(this, contacts);
        rvContacts.setAdapter(adapter);
    }
}