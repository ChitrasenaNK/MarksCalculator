package com.example.markscalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText name,mark1,mark2,mark3;

    Button btn1;
   double m1,m2,m3,avg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();




        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(validate())
                {

                    m1=Double.parseDouble(mark1.getText().toString());
                    m2=Double.parseDouble(mark2.getText().toString());
                    m3=Double.parseDouble(mark3.getText().toString());
                    String person=name.getText().toString();
                    avg=(m1+m2+m3)/6;
                    Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                    intent.putExtra("avg",avg);

                    intent.putExtra("name",name.getText().toString());
                    startActivity(intent);

                }




            }
        });

    }
    public boolean validate()
    {
        if((mark1.getText().toString().length()==0)||(mark2.getText().toString().length()==0)||(mark3.getText().toString().length()==0)) {

            Toast.makeText(this, "Enter the missing field", Toast.LENGTH_LONG).show();
            return false;
        }
        if((Integer.parseInt(mark1.getText().toString())>100)||(Integer.parseInt(mark2.getText().toString())>100)||
                (Integer.parseInt(mark3.getText().toString())>100))
        {
            Toast.makeText(this, "Enter appropriate value", Toast.LENGTH_LONG).show();
            return false;
        }
        if((name.getText().toString().length()==0))
        {
            Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show();
            return false;
        }

            return true;


    }
    public void initViews()
    {

        mark1=(EditText)findViewById(R.id.mark1);
        mark2=(EditText)findViewById(R.id.mark2);
        mark3=(EditText)findViewById(R.id.mark3);
        name=(EditText)findViewById(R.id.name);
        btn1=(Button)findViewById(R.id.btn1);



    }
}