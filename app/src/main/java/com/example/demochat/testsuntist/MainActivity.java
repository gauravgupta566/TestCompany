package com.example.demochat.testsuntist;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    TextView maleradio,femaleradio,companytitle;
    Button submitbutton;
    EditText myname,myage;
    RecyclerView friends_recyclerview;

    String selecetedradio="null";
    Typeface typeface;

    ArrayList<Model> arrayList=new ArrayList<>();

    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     typeface=  Typeface.createFromAsset(getAssets(),"futuramediumbt.ttf");

        companytitle=(TextView)findViewById(R.id.companytitle);
        companytitle.setTypeface(typeface);

        friends_recyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        myname=(EditText) findViewById(R.id.myname);
        myage=(EditText) findViewById(R.id.myage);

        maleradio=(TextView)findViewById(R.id.maleradio);
        femaleradio=(TextView)findViewById(R.id.femaleradio);

        submitbutton=(Button)findViewById(R.id.submitbutton);

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

                    gd1.setColor(Color.parseColor("#e31208"));
                    gd1.setCornerRadius(10);

                    maleradio.setBackground(gd1);

                    femaleradio.setBackground(gd);

                }

                else {
                    selecetedradio="male";
                    GradientDrawable gd1 = new GradientDrawable();
                    gd1.setColor(Color.parseColor("#e31208"));
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

                    gd1.setColor(Color.parseColor("#e31208"));
                    gd1.setCornerRadius(10);

                    maleradio.setBackground(gd);

                    femaleradio.setBackground(gd1);

                }
                else {

                    selecetedradio="female";
                    GradientDrawable gd1 = new GradientDrawable();
                    gd1.setColor(Color.parseColor("#e31208"));
                    gd1.setCornerRadius(10);
                    femaleradio.setBackground(gd1);
                }

            }
        });

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(myage.getText().length()>0 &&myname.getText().length()>0 &&selecetedradio!="null" ) {
                 arrayList.add(new Model(myname.getText().toString(),myage.getText().toString(),selecetedradio));



                  LinearLayoutManager  linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                  linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                  friends_recyclerview.setLayoutManager(linearLayoutManager);
                  friends_recyclerview.setHasFixedSize(true);

                  adapter=new Adapter(MainActivity.this,arrayList);
                  friends_recyclerview.setAdapter(adapter);


              }
                else {
                  if(arrayList.size()>0) {

                    LinearLayoutManager  linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                      linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                      friends_recyclerview.setLayoutManager(linearLayoutManager);
                      friends_recyclerview.setHasFixedSize(true);

                      adapter=new Adapter(MainActivity.this,arrayList);
                      friends_recyclerview.setAdapter(adapter);
                  }
                  else {
                      Toast.makeText(MainActivity.this, "either you have not filled details", Toast.LENGTH_LONG).show();
                  }
              }



            }
        });


    }
}
