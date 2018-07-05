package com.acadview.dbdemostudent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
EditText name,cur_pwd,new_pwd;
Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name = findViewById(R.id.editText6);
        cur_pwd = findViewById(R.id.editText7);
        new_pwd = findViewById(R.id.editText8);
        update = findViewById(R.id.button6);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBClass dbClass = new DBClass(UpdateActivity.this);
                dbClass.onUpdate(name.getText().toString(),cur_pwd.getText().toString(),new_pwd.getText().toString());
            }
        });

//        update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DBClass dbClass = new DBClass(UpdateActivity.this);
//                dbClass.onUpdate(name.getText().toString(),cur_pwd.getText().toString(),new_pwd.getText().toString());
//
//                Toast.makeText(UpdateActivity.this,"UPDATION SUCCESSFULL !",Toast.LENGTH_LONG).show();
//            }
//        });

    }
}
