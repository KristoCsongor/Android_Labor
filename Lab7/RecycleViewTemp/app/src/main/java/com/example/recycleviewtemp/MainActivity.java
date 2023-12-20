package com.example.recycleviewtemp;

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

        RecyclerView rvContacts =findViewById(R.id.recycletxt);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        List<Contact> contacts = Contact.getContacts();
        ContactAdapter adapter = new ContactAdapter(this, contacts);
        rvContacts.setAdapter(adapter);
    }
}