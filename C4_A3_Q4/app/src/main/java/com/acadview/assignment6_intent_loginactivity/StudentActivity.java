package com.acadview.assignment6_intent_loginactivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class StudentActivity extends AppCompatActivity {

    Button calling,upload;
    ImageView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        calling = findViewById(R.id.button6);
        upload=findViewById(R.id.button5);
        profile=findViewById(R.id.imageView);


        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,101);
            }
        });

        calling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone_number = "+919644449851";
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone_number));
             startActivity(intent);

            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101 && resultCode == RESULT_OK) {
            Bundle bundle=data.getExtras();
            Bitmap bitmap=(Bitmap) bundle.get("data");
            profile.setImageBitmap(bitmap);
        }
        else{
            Toast.makeText(getApplicationContext(),"No Image Taken !",Toast.LENGTH_LONG).show();
        }
    }
}
