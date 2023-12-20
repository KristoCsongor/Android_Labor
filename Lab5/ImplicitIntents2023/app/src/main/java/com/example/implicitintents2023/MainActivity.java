package com.example.implicitintents2023;

import static android.Manifest.permission.CALL_PHONE;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button callNumber;
    EditText phoneNumber;
    Button btnPhoto;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callNumber = findViewById(R.id.callNumber);
        phoneNumber = findViewById(R.id.phoneNumber);
        btnPhoto = findViewById(R.id.capturePhoto);
        imageView = findViewById(R.id.imageView);
    }

    public void call(View view){
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+ phoneNumber.getText()));
        if (ContextCompat.checkSelfPermission(MainActivity.this, CALL_PHONE)==
                PackageManager.PERMISSION_DENIED){
            requestPermissions(new String[] {CALL_PHONE}, 1);
        }
        startActivity(callIntent);
    }

    public void capturePhoto(View view){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //startActivityForResult(takePictureIntent, 1);
        launchSecondActivity.launch(takePictureIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap image = (Bitmap) extras.get("data");
            imageView.setImageBitmap(image);
            imageView.setRotation(30);
        }
    }

    private ActivityResultLauncher<Intent> launchSecondActivity = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        Bundle extras = data.getExtras();
                        Bitmap image = (Bitmap) extras.get("data");
                        imageView.setImageBitmap(image);
                        imageView.setRotation(30);

                    } else {
                        Toast.makeText(MainActivity.this, "Cancelled...", Toast.LENGTH_SHORT).show();
                    }
                }
            });


}