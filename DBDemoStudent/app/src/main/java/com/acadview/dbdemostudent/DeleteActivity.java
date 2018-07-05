package com.acadview.dbdemostudent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteActivity extends AppCompatActivity {
    EditText name;
    Button deletebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        name = findViewById(R.id.editText);
        
        deletebtn = findViewById(R.id.buttondelt);
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBClass dbClass = new DBClass(DeleteActivity.this);
                dbClass.onDelete(name.getText().toString());
            }
        });

    }
}
