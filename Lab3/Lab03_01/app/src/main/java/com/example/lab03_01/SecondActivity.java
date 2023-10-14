package com.example.lab03_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tv = findViewById(R.id.textView);
        String email = this.getIntent().getStringExtra("email");
        String password = this.getIntent().getStringExtra("password");
        tv.setText(email);
    }
}