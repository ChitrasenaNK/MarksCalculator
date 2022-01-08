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

public class MainActivity2 extends AppCompatActivity {


    EditText markTam,markEng,markMath,markPhy,markChem,markCs;
    Button btn2;
    double tam,eng,mat,phy,chem,cs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initViews2();
         Double avg =getIntent().getDoubleExtra("avg",0.00);
         String name=getIntent().getStringExtra("name");




        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validate2())
                {
                    tam=((Double.parseDouble(markTam.getText().toString()))*20/90)+avg;
                    eng=((Double.parseDouble(markEng.getText().toString()))*20/90)+avg;
                    mat=((Double.parseDouble(markMath.getText().toString()))*20/90)+avg;
                    phy=((Double.parseDouble(markPhy.getText().toString()))*20/70)+avg;
                    chem=((Double.parseDouble(markChem.getText().toString()))*20/70)+avg;
                    cs=((Double.parseDouble(markCs.getText().toString()))*20/70)+avg;

                    Intent intent2 = new Intent(MainActivity2.this, MainActivity3.class);
                    intent2.putExtra("tam",tam);
                    intent2.putExtra("eng",eng);
                    intent2.putExtra("math",mat);
                    intent2.putExtra("phy",phy);
                    intent2.putExtra("chem",chem);
                    intent2.putExtra("cs",cs);
                    intent2.putExtra("name",name);


                    startActivity(intent2);
                }
                }




    });

    }
    public boolean validate2()
    {
        if((markTam.getText().toString().length()==0)||(markEng.getText().toString().length()==0)||(markMath.getText().toString().length()==0)
                ||(markPhy.getText().toString().length()==0)||(markChem.getText().toString().length()==0)
                ||(markCs.length()==0))
        {
            Toast.makeText(MainActivity2.this, "Enter the missing field", Toast.LENGTH_SHORT).show();
            return false;
        }

        if((Integer.parseInt(markTam.getText().toString())>90)||(Integer.parseInt(markEng.getText().toString())>90)||
                (Integer.parseInt(markMath.getText().toString())>90)||(Integer.parseInt(markPhy.getText().toString())>70)
                ||(Integer.parseInt(markChem.getText().toString())>70)||
                (Integer.parseInt(markCs.getText().toString())>70))
        {
            Toast.makeText(MainActivity2.this, "Enter appropriate value", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;

    }
    public void initViews2()
    {

        markTam=(EditText)findViewById(R.id.markTam);
        markEng=(EditText)findViewById(R.id.markEng);
        markMath=(EditText)findViewById(R.id.markMath);
        markPhy=(EditText)findViewById(R.id.markPhy);
        markChem=(EditText)findViewById(R.id.markChem);
        markCs=(EditText)findViewById(R.id.markCs);
        btn2=(Button)findViewById(R.id.btn2);
    }
}