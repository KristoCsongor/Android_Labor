package com.example.recycleviewtemp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Contact contact = (Contact) getIntent().getExtras().getSerializable("contact");
        TextView textView = findViewById(R.id.textView2);
        textView.setText(contact.getName());
    }
}