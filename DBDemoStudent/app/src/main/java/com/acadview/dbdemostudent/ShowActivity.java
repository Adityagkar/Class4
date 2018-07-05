package com.acadview.dbdemostudent;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        ListView listView = findViewById(R.id.list);
        ArrayList<String> arrayList = new ArrayList<String>();

        DBClass dbClass = new DBClass(this);
        Cursor cursor= dbClass.getData();

        if(cursor.moveToFirst()){

            do {
                //cursor , display the data of that row
                String name = cursor.getString(cursor.getColumnIndex("Name"));
                String password = cursor.getString(cursor.getColumnIndex("Password"));
                String number = cursor.getString(cursor.getColumnIndex("Number"));
                String type = cursor.getString(cursor.getColumnIndex("Type"));

                arrayList.add(name+" "+password+" "+number+" "+type);
                //cursor , increment to next row
            }while(cursor.moveToNext());

        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
    }
}
