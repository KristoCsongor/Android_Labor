package com.example.lab03_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et1 = findViewById(R.id.editTextText);
        EditText et2 = findViewById(R.id.editTextText2);
        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = et1.getText().toString();
                String password = et2.getText().toString();
                if(!email.equals("admin") || !password.equals("admin")) {
                    Toast.makeText(MainActivity.this, "Wrong email or password.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
                    myIntent.putExtra("email", email);
                    myIntent.putExtra("password", password);
                    startActivity(myIntent);
                }
            }
        });
    }
}