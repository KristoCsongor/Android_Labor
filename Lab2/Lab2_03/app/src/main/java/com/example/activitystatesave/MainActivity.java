package com.example.activitystatesave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("status", "onCreate()");

        if(savedInstanceState == null) {
            Log.d("status", "onCreate() mehod was invoked without a previous state");
        } else {
            Log.d("status", "onCreate() mehod was invoked with a previous state");
        }

        TextView tv = findViewById(R.id.textView);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = tv.getText().toString();
                String text1 = "Default Text";
                String text2 = "Text Default";
                if (text.equals(text1)) {
                    tv.setText(text2);
                } else if (text.equals(text2)) {
                    tv.setText(text1);
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView tv = findViewById(R.id.textView);
        outState.putString("myEditText", tv.getText().toString());
        Log.d("status", "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView tv = findViewById(R.id.textView);
        if (savedInstanceState.getString("myEditText") != null) {
            tv.setText(savedInstanceState.getString("myEditText"));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("status", "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("status", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("status", "onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("status", "onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("status", "onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("status", "onRestart()");
    }
}