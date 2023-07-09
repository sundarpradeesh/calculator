package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    Button one,two,three,plus,equals,minus;
    TextView output;
    String res="";
    double sum=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one =findViewById(R.id.button);
        two = findViewById(R.id.button2);
        three = findViewById(R.id.button3);
        output = findViewById(R.id.textView2);
        plus = findViewById(R.id.button4);
        minus = findViewById(R.id.button6);
        equals = findViewById(R.id.button5);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                res+="1";
                output.setText(res);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res+="2";
                output.setText(res);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res+="3";
                output.setText(res);
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res+="+";
                output.setText(res);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res+="-";
                output.setText(res);
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LinkedList<Double> numbers = new LinkedList<>();
                LinkedList<Character> symbols = new LinkedList<>();

                int start=0;
                for(int i=0;i<res.length();i++)
                {
                    if(res.charAt(i)=='+'||res.charAt(i)=='-'||res.charAt(i)=='x'||res.charAt(i)=='/')
                    {
                        try{
                            numbers.add(Double.parseDouble(res.substring(start,i)));
                            start=i+1;
                            symbols.add(res.charAt(i));
                        }
                        catch(Exception e)
                        {
                            output.setText("Math Error!");
                        }
                    }
                }
                try {
                    numbers.add(Double.parseDouble(res.substring(start, res.length())));
                    if(numbers!=null)
                    {
                        sum+=numbers.get(0);
                    }
                    for(int i=1;i<numbers.size();i++)
                    {
                        if(symbols.get(i-1)=='+')
                        {
                            sum+=numbers.get(i);
                        }
                        else if(symbols.get(i-1)=='-')
                        {
                            sum-=numbers.get(i);
                        }
                        else if(symbols.get(i-1)=='x')
                        {
                            sum*=numbers.get(i);
                        }
                        else if(symbols.get(i-1)=='/')
                        {
                            sum/=numbers.get(i);
                        }
                        else{
                            output.setText("Math Error!");
                        }
                    }
                  //  hist.push(res+" = "+String.valueOf(sum));
                    output.setText(res+"\r\n\r\n= "+String.valueOf(sum));

                    res=String.valueOf(sum);
                    sum=0;
                }
                catch (Exception e)
                {
                    output.setText("Math Error!");
                }


            }
        });



    }
}