package com.acadview.assignment6_intent_loginactivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class InstructorActivity extends AppCompatActivity {

    Button webexplorer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor);

       webexplorer = findViewById(R.id.button3);

       webexplorer.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/?gfe_rd=cr&dcr=0&ei=lbLNWsO_PKmA8QfuiJmACw"));
               startActivity(intent);
           }
       });


    }
}
