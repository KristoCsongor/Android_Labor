package com.example.lab05_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText firstname = findViewById(R.id.firstnameText);
        EditText lastname = findViewById(R.id.lastnameText);
        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("firstname", firstname.getText().toString());
                intent.putExtra("lastname", lastname.getText().toString());
                intent.putExtra("image", R.drawable.huf);
                startActivity(intent);
            }
        });
    }
}