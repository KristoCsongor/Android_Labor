package com.example.lab05_03;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        String firstname = extras.getString("firstname");
        String lastname = extras.getString("lastname");
        int res = extras.getInt("image");
        if(firstname != null && lastname != null) {
            TextView tv = findViewById(R.id.textView);
            ImageView image = findViewById(R.id.imageView);
            tv.setText("Your name: " + firstname + " " + lastname);
            image.setImageResource(res);
        }
    }
}