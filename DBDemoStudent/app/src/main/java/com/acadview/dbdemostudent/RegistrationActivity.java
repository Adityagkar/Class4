package com.acadview.dbdemostudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    EditText name,password,number,type;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        submit = findViewById(R.id.button5);
        name = findViewById(R.id.editText2);
        password = findViewById(R.id.editText3);
        number = findViewById(R.id.editText4);
        type = findViewById(R.id.editText5);

        final DBClass dbClass = new DBClass(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbClass.addData(name.getText().toString(),password.getText().toString(),number.getText().toString(),type.getText().toString());
               // Toast.makeText(getApplicationContext(),"DETAILS ADDED SUCCESSFULLY  !",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(RegistrationActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
