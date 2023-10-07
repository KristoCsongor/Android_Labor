package com.example.lab2_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d("status: ", "SecondActivity: onCreate ");

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("status: ", "SecondActivity: onStart ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("status: ", "SecondActivity: onStop ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("status: ", "SecondActivity: onDestroy ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("status: ", "SecondActivity: onPause ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("status: ", "SecondActivity: onResume ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("status: ", "SecondActivity: onRestart ");
    }

}