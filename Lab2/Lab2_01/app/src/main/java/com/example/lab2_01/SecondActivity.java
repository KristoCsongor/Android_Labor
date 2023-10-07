package com.example.lab2_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d("status: ", "SecondActivity: onCreate ");
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