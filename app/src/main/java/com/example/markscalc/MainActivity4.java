package com.example.markscalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
     TextView tam,eng,math,phy,chem,bio,name,total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        tam=findViewById(R.id.finalTamil);
        eng=findViewById(R.id.finalEnglish);
        math=findViewById(R.id.finalMaths);
        phy=findViewById(R.id.finalPhy);
        chem=findViewById(R.id.finalChem);
        bio=findViewById(R.id.finalBio);
        name=findViewById(R.id.nameResult);
        total=findViewById(R.id.finalTotal);
        String m1,m2,m3,m4,m5,m6,mt;
        m1=Integer.toString(getIntent().getIntExtra("T",0));
        m2=Integer.toString(getIntent().getIntExtra("E",0));
        m3=Integer.toString(getIntent().getIntExtra("M",0));
        m4=Integer.toString(getIntent().getIntExtra("P",0));
        m5=Integer.toString(getIntent().getIntExtra("C",0));
        m6=Integer.toString(getIntent().getIntExtra("B",0));
        mt=Integer.toString(getIntent().getIntExtra("total",0));
        tam.setText(m1);
        eng.setText(m2);
        math.setText(m3);
        phy.setText(m4);
        chem.setText(m5);
        bio.setText(m6);
        total.setText(mt);
        name.setText("NAME: "+getIntent().getStringExtra("name"));
        Button btnNew=findViewById(R.id.btnNew);

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent(MainActivity4.this,MainActivity.class);
                startActivity(intent4);
            }
        });







    }
}