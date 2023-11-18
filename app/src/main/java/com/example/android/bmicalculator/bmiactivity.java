package com.example.android.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class bmiactivity extends AppCompatActivity {

    android.widget.Button mrecalculcatebmi;
    TextView mbmidisplay,mbmicategory,mgender;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    float floatbmi;
    String height,weight;
    float floatheight,floatweight;
    RelativeLayout mbackground;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        ColorDrawable colorDrawable =new ColorDrawable(Color.parseColor("#1e1d1d"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent=getIntent();
        mbmidisplay=findViewById(R.id.bmidisplay);
        mbmicategory=findViewById(R.id.bmicategory);
        mgender=findViewById(R.id.genderdisplay);
        mbackground = findViewById(R.id.contentlayout);
        mimageview =findViewById(R.id.imageview);
        mrecalculcatebmi = findViewById(R.id.recalculatebmi);

        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        floatheight=Float.parseFloat(height);
        floatweight=Float.parseFloat(weight);
        floatheight=floatheight/100;
        floatbmi=floatweight/(floatheight*floatheight);

        mbmi=Float.toString(floatbmi);                   //float to string

        if(floatbmi>60)
        {
            mbmicategory.setText("Severe Thickness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
        }

        else if(floatbmi<16.9 && floatbmi >16)
        {
            mbmicategory.setText("Moderate Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }

        else if(floatbmi<18.4 && floatbmi > 17)
        {
            mbmicategory.setText("Mild Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
        }

        else if(floatbmi<25 && floatbmi >18.4)
        {
            mbmicategory.setText("Normal");
            mimageview.setImageResource(R.drawable.ok);

        }
        else if(floatbmi<29.4 && floatbmi >25)
        {
            mbmicategory.setText("Severe Thickness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }

        else
        {
                mbmicategory.setText("Obese Class 1");
                mbackground.setBackgroundColor(Color.RED);
                mimageview.setImageResource(R.drawable.warning);

        }

        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);





        mrecalculcatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bmiactivity.this,MainActivity.class);
                startActivity(intent);

                finish();        // do not go back by pressing back button
            }
        });
    }
}