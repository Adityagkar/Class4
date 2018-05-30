package com.acadview.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String num1,operand,num3;
    Button add,sub,mul,div,equals;
    TextView display;
    String str;
    Integer answer;
    Button reset,backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display=findViewById(R.id.textView);

        equals=findViewById(R.id.button8);
        num1="";
        num3="";

        reset=findViewById(R.id.buttonreset);
        backspace=findViewById(R.id.buttondeci);

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=display.getText().toString();
                if (str.length() >=1 ) {
                    str = str.substring(0, str.length() - 1);
                    display.setText(str);
                } else if (str.length() <=1 ) {
                    display.setText("0");
                }
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("operand",operand);
                Log.d("operand",num1+":"+num3);


                switch (operand){
                    case "+": answer=Integer.parseInt(num3)+Integer.parseInt(num1);
                        display.setText(""+answer);
                        break;

                    case "-": answer=Integer.parseInt(num3)-Integer.parseInt(num1);
                        display.setText(""+answer);
                        break;

                    case "*": answer=Integer.parseInt(num3)*Integer.parseInt(num1);
                        display.setText(""+answer);
                        break;

                    case "/": answer=Integer.parseInt(num3)/Integer.parseInt(num1);
                        display.setText(""+answer);
                        break;
                }

                num1=""+answer;

            }
        });



    }

 void valueGetterOnClick(View v){

        str=display.getText().toString();

        if(v.getId()==R.id.buttonone){
           display.setText(str+"1");
           num1=num1+"1";
        }
        else if(v.getId()==R.id.buttontwo){
            display.setText(str+"2");
            num1=num1+"2";
        }
            else if(v.getId()==R.id.buttonthree){
                display.setText(str+"3");
                num1=num1+"3";
            }
                else if(v.getId()==R.id.buttonfour){
                    display.setText(str+"4");
                    num1=num1+"4";
                }
                    else if(v.getId()==R.id.buttonfive){
                        display.setText(str+"5");
                        num1=num1+"5";
                    }
                        else if(v.getId()==R.id.buttonsix){
                            display.setText(str+"6");
                            num1=num1+"6";
                        }
                            else if(v.getId()==R.id.buttonseven){
                                display.setText(str+"7");
                                num1=num1+"7";
                            }
                                else if(v.getId()==R.id.buttoneight){
                                    display.setText(str+"8");
                                    num1=num1+"8";
                                }
                                    else if(v.getId()==R.id.buttonnine){
                                        display.setText(str+"9");
                                        num1=num1+"9";
                                    }
                                        else if(v.getId()==R.id.buttonzero){
                                            display.setText(str+"0");
                                            num1=num1+"0";
                                        }
                                        else if(v.getId()==R.id.buttonreset){
                                            display.setText("0");
                                            num1="";
                                            num3="";
                                        }



    }

    void operandGetterOnClick(View v){

        str=display.getText().toString();

        if(v.getId()==R.id.button6){
            display.setText(str+"+");
          operand="+";
        }
        else if(v.getId()==R.id.button7){
            display.setText(str+"-");
            operand="-";
        }
            else if(v.getId()==R.id.button9){
                display.setText(str+"*");
                operand="*";
            }
                else if(v.getId()==R.id.button10){
                    display.setText(str+"/");
                    operand="/";
                }

                num3=num1;
                num1="";

    }
}
