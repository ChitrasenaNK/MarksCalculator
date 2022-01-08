package com.example.markscalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    EditText markT,markE,markM,markP,markC,markCs;
    Button btnCalc;
    Double tamil,english,maths,physics,chemistry,csbio;
    int t,e,m,p,c,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initViews3();
        tamil=getIntent().getDoubleExtra("tam",0.00);
        english=getIntent().getDoubleExtra("eng",0.00);
        maths=getIntent().getDoubleExtra("math",0.00);
        physics=getIntent().getDoubleExtra("phy",0.00);
        chemistry=getIntent().getDoubleExtra("chem",0.00);
        csbio=getIntent().getDoubleExtra("cs",0.00);
        String name=getIntent().getStringExtra("name");
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate3())
                {
                    t=(int)Math.round(tamil+((Double.parseDouble(markT.getText().toString()))*3));
                    e=(int)Math.round(english+((Double.parseDouble(markE.getText().toString()))*3));
                    m=(int)Math.round(maths+((Double.parseDouble(markM.getText().toString()))*3));
                    p=(int)Math.round(physics+((Double.parseDouble(markP.getText().toString()))));
                    c=(int)Math.round(chemistry+((Double.parseDouble(markC.getText().toString()))));
                    b=(int)Math.round(csbio+((Double.parseDouble(markCs.getText().toString()))));
                    int total=t+e+m+p+c+b;

                    Intent i=new Intent(MainActivity3.this, MainActivity4.class);
                    i.putExtra("T",t);
                    i.putExtra("E",e);
                    i.putExtra("M",m);
                    i.putExtra("P",p);
                    i.putExtra("C",c);
                    i.putExtra("B",b);
                    i.putExtra("name",name);
                    i.putExtra("total",total);

                    startActivity(i);

                }
            }
        });
    }
    public boolean validate3()
    {
        if((markT.getText().toString().length()==0)||(markE.getText().toString().length()==0)||(markM.getText().toString().length()==0)
                ||(markP.getText().toString().length()==0)||(markC.getText().toString().length()==0)
                ||(markCs.length()==0))
        {
            Toast.makeText(MainActivity3.this, "Enter the missing field", Toast.LENGTH_SHORT).show();
            return false;
        }

        if((Integer.parseInt(markT.getText().toString())>10)||(Integer.parseInt(markE.getText().toString())>10)||
                (Integer.parseInt(markM.getText().toString())>10)||(Integer.parseInt(markP.getText().toString())>30)
                ||(Integer.parseInt(markC.getText().toString())>30)||
                (Integer.parseInt(markCs.getText().toString())>30))
        {
            Toast.makeText(MainActivity3.this, "Enter appropriate value", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;

    }
    public void initViews3()
    {

        markT=(EditText)findViewById(R.id.markT);
        markE=(EditText)findViewById(R.id.markE);
        markM=(EditText)findViewById(R.id.markM);
        markP=(EditText)findViewById(R.id.markP);
        markC=(EditText)findViewById(R.id.markC);
        markCs=(EditText)findViewById(R.id.markCS);
        btnCalc=(Button)findViewById(R.id.btnCalc);
    }
}