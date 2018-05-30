package com.acadview.ForexConverter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.acadview.ForexConverter.Converter;
import com.acadview.ForexConverter.R;

public class RateChanger extends AppCompatActivity {
    EditText currency1,currency2,rate;
    Button save,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_changer);

        currency1=findViewById(R.id.editText4);
        currency2=findViewById(R.id.editText5);
        rate=findViewById(R.id.editText8);
        save=findViewById(R.id.save);
        back=findViewById(R.id.back);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RateFixer rateFixer= new RateFixer();
                rateFixer.setCurrency1_name(currency1.getText().toString());
                rateFixer.setCurrency2_name(currency2.getText().toString());
                rateFixer.setCurrency_1_rate(Double.parseDouble(rate.getText().toString()));

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RateChanger.this, Converter.class);
                startActivity(intent);
            }
        });




    }
}
