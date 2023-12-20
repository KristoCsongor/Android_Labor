package com.example.implicitintentstemp;

import static android.Manifest.permission.CALL_PHONE;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

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

public class MainActivity extends AppCompatActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCallPhone = findViewById(R.id.call);
        EditText txtPhoneNumber = findViewById(R.id.phoneNum);
        img = findViewById(R.id.imageView);

        btnCallPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + txtPhoneNumber.getText().toString()));
                if (ContextCompat.checkSelfPermission(MainActivity.this, CALL_PHONE) == PackageManager.PERMISSION_DENIED) {
                    requestPermissions(new String[] {CALL_PHONE}, 1);
                }
                startActivity(callIntent);
            }
        });

        Button btnImageCapture = findViewById(R.id.capturePhoto);
        btnImageCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //startActivity(takePictureIntent);
                activity.launch(takePictureIntent);
            }
        });

    }

    private ActivityResultLauncher<Intent> activity = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent data = result.getData();
                    Bundle extr = data.getExtras();
                    Bitmap image = (Bitmap) extr.get("data");
                    img.setImageBitmap(image);
                }
            }
    );

}