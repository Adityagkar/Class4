package com.acadview.dbdemostudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button add,delete,show,update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.button);
        delete = findViewById(R.id.button3);
        show= findViewById(R.id.button2);
        update = findViewById(R.id.button4);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ShowActivity.class);
                startActivity(intent);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DeleteActivity.class);
                startActivity(intent);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,UpdateActivity.class);
                startActivity(intent);
            }
        });

//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DBClass dbClass = new DBClass(MainActivity.this);
//                dbClass.deleteData("Tekender");
//            }
//        });

//        update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DBClass dbClass = new DBClass(MainActivity.this);
//                dbClass.updateData("Tekender","abcd","1234a");
//            }
//        });


    }
}
