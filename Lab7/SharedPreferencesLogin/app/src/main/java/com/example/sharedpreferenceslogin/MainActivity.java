package com.example.sharedpreferenceslogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        if (sharedPreferences.getString("logged", "").equals("true")) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        Button loginButton = findViewById(R.id.loginbutton);
        CheckBox checkbox = findViewById(R.id.rememberMe);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = findViewById(R.id.login);
                EditText password = findViewById(R.id.password);
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", username.getText().toString());
                    // editor.putString("password", password.getText().toString());
                    if (checkbox.isChecked()) {
                        editor.putString("logged", "true");
                    }
                    editor.commit();
                }
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}