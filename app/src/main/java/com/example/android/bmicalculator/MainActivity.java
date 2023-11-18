package com.example.android.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    android.widget.Button mcalculcatebmi;
    TextView mcurrentweight, mcurrentheight, mcurrentage;
    ImageView mincrementage, mincrementweight, mdecrementweight, mdecrementage;
    SeekBar mseekbarforheight;
    RelativeLayout mmale, mfemale;
    int intweight = 55;    // for storing weight in int
    int intage = 22;          // for storing age in int
    int currentprogress;
    String mintprogress = "170";
    String typeofuser = "0";
    String weight2 = "55";            //to set text on currentweight (by converting intweight to String)
    String age2 = "22";                  //to set text on currentage (by converting intage to String)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        getSupportActionBar().hide();
        mcalculcatebmi = findViewById(R.id.calculatebmi);
        mcurrentage = findViewById(R.id.currentage);
        mcurrentweight = findViewById(R.id.currentweight);
        mcurrentheight = findViewById(R.id.currentheight);
        mdecrementage = findViewById(R.id.decrementage);
        mincrementage = findViewById(R.id.incrementage);
        mdecrementweight = findViewById(R.id.decrementweight);
        mincrementweight = findViewById(R.id.incrementweight);
        mseekbarforheight = findViewById(R.id.seekbarforheight);
        mmale = findViewById(R.id.male);
        mfemale = findViewById(R.id.female);

        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                typeofuser = "Male";

            }
        });


        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                typeofuser = "Female";

            }
        });


        mseekbarforheight.setMax(300);         //set max limit on seekbar
        mseekbarforheight.setProgress(170);    // set by default progeress
        mseekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress = progress;
                mintprogress = String.valueOf(currentprogress);          // typecast int to String
                mcurrentheight.setText(mintprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        mincrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage = intage + 1;
                age2 = String.valueOf(intage);
                mcurrentage.setText(age2);

            }
        });

        mincrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight = intweight + 1;
                weight2 = String.valueOf(intweight);           //int to string
                mcurrentweight.setText(weight2);

            }
        });


        mdecrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight = intweight - 1;
                weight2 = String.valueOf(intweight);
                mcurrentweight.setText(weight2);

            }
        });

        mdecrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage = intage - 1;
                age2 = String.valueOf(intage);           //int to string
                mcurrentage.setText(age2);

            }
        });


        mcalculcatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (typeofuser.equals("0")) {
                    Toast.makeText(getApplicationContext(), "Select Your Gender First", Toast.LENGTH_SHORT).show();
                } else if (mintprogress.equals("0")) {
                    Toast.makeText(getApplicationContext(), "Select Your Height First", Toast.LENGTH_SHORT).show();

                } else if (intage <= 0) {
                    Toast.makeText(getApplicationContext(), "Age is incorrect", Toast.LENGTH_SHORT).show();

                } else if (intweight <= 0) {
                    Toast.makeText(getApplicationContext(), "Weight is incorrect", Toast.LENGTH_SHORT).show();

                } else {
                    Intent intent = new Intent(MainActivity.this, bmiactivity.class);
                    startActivity(intent);
                    intent.putExtra("gender", typeofuser);
                    intent.putExtra("height", mintprogress);
                    intent.putExtra("weight", weight2);
                    intent.putExtra("age", age2);
                    startActivity(intent);

                }


            }
        });
    }
}