package com.example.android.layoutandgpa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class GPA extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2,e3;
    ImageView mGrade;
    Animation anim;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gp);

        b1 = (Button)findViewById(R.id.result);
        b2 = (Button)findViewById(R.id.clear);
        e1 = (EditText)findViewById(R.id.one);
        e2 = (EditText)findViewById(R.id.two);
        e3 = (EditText)findViewById(R.id.three);
        mGrade = (ImageView)findViewById(R.id.image);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int class1 = Integer.parseInt(e1.getText().toString());
                int class2 = Integer.parseInt(e2.getText().toString());
                int class3 = Integer.parseInt(e3.getText().toString());
                int total = class1+class2+class3;
                double mean = total/3;


                mGrade.setVisibility(View.VISIBLE);
                if (mean >= 90){
                    mGrade.setImageResource(R.drawable.a);
                    anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                    mGrade.startAnimation(anim);
                }else if (mean >= 80){
                    mGrade.setImageResource(R.drawable.b);
                    anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                    mGrade.startAnimation(anim);
                }else
                    mGrade.setImageResource(R.drawable.c);
                    anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                    mGrade.startAnimation(anim);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(null);
                e2.setText(null);
                e3.setText(null);

                mGrade.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),"Initiallization",Toast.LENGTH_LONG).show();
            }
        });
    }
}
