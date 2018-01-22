package com.example.demochat.testsuntist;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView user_sex,user_age,user_name,maleradio,femaleradio;
    Button submitbutton;
    EditText myname,myage;

    String selecetedradio="null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myname=(EditText) findViewById(R.id.myname);
        myage=(EditText) findViewById(R.id.myage);

        maleradio=(TextView)findViewById(R.id.maleradio);
        femaleradio=(TextView)findViewById(R.id.femaleradio);

        submitbutton=(Button)findViewById(R.id.submitbutton);
        user_sex=(TextView)findViewById(R.id.user_sex);
        user_age=(TextView)findViewById(R.id.user_age);
        user_name=(TextView)findViewById(R.id.user_name);


        myname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                GradientDrawable gd = new GradientDrawable();
                gd.setColor(Color.parseColor("#ffffff"));
                gd.setCornerRadius(10);
                gd.setStroke(2,getResources().getColor(R.color.colorAccent));
                selecetedradio="null";

                maleradio.setBackground(gd);
                femaleradio.setBackground(gd);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        myage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                selecetedradio="null";
                GradientDrawable gd = new GradientDrawable();
                gd.setColor(Color.parseColor("#ffffff"));
                gd.setCornerRadius(10);
                gd.setStroke(2,getResources().getColor(R.color.colorAccent));

                maleradio.setBackground(gd);
                femaleradio.setBackground(gd);


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        maleradio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selecetedradio.equals("female")) {

                    selecetedradio="male";
                    GradientDrawable gd = new GradientDrawable();
                    GradientDrawable gd1 = new GradientDrawable();

                    gd.setColor(Color.parseColor("#ffffff"));
                    gd.setCornerRadius(10);

                    gd1.setColor(Color.parseColor("#FF4081"));
                    gd1.setCornerRadius(10);

                    maleradio.setBackground(gd1);

                    femaleradio.setBackground(gd);

                }

                else {
                    selecetedradio="male";
                    GradientDrawable gd1 = new GradientDrawable();
                    gd1.setColor(Color.parseColor("#FF4081"));
                    gd1.setCornerRadius(10);

                    maleradio.setBackground(gd1);


                }

            }
        });


        femaleradio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selecetedradio.equals("male")) {

                    selecetedradio="female";
                    GradientDrawable gd = new GradientDrawable();
                    GradientDrawable gd1 = new GradientDrawable();

                    gd.setColor(Color.parseColor("#ffffff"));
                    gd.setCornerRadius(10);

                    gd1.setColor(Color.parseColor("#FF4081"));
                    gd1.setCornerRadius(10);

                    maleradio.setBackground(gd);

                    femaleradio.setBackground(gd1);

                }
                else {

                    selecetedradio="female";
                    GradientDrawable gd1 = new GradientDrawable();
                    gd1.setColor(Color.parseColor("#FF4081"));
                    gd1.setCornerRadius(10);
                    femaleradio.setBackground(gd1);
                }

            }
        });

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(myage.getText().length()>0 &&myname.getText().length()>0 &&selecetedradio!="null" ) {


                  user_age.setText(myage.getText().toString());
                  user_name.setText(myname.getText().toString());
                  user_sex.setText(selecetedradio);


              }
                else {
                  Toast.makeText(MainActivity.this,"either you have not filled details",Toast.LENGTH_LONG).show();
              }



            }
        });


    }
}
