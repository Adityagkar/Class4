package com.acadview.Registration_loginPage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,mail,phone,city;
    Button submit;
    Spinner state;
    String state_string;
    Integer state_position;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);
        phone = findViewById(R.id.phone);
        city = findViewById(R.id.city);
        state = findViewById(R.id.statespinner);
        submit = findViewById(R.id.submit);

        sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_APPEND);


        final String states[] = {"Bihar", "Chhattisgarh", "Jharkhand", "Madhya Pradesh", "Odisha", "Rajasthan", "Uttar Pradesh"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, states);
        state.setAdapter(arrayAdapter);

        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                state_string = states[i];
                state_position=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "You haven't selected anything ! ", Toast.LENGTH_LONG).show();
            }
        });



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             confirmAlert();
            }
        });


    }

    private void confirmAlert(){
        AlertDialog.Builder alertdialog= new AlertDialog.Builder(MainActivity.this);

        alertdialog.setTitle("Confirm !");
        alertdialog.setMessage("Are you sure you want to save data values ?");

        alertdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("Name",name.getText().toString());
                editor.putString("Mail",mail.getText().toString());
                editor.putString("Phone",phone.getText().toString());
                editor.commit();
               Toast.makeText(getApplicationContext(),"All details are stored",Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

        alertdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        AlertDialog alertDialogBox=alertdialog.create();
        alertDialogBox.show();
    }


}