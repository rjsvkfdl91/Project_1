package com.example.android.layoutandgpa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView layout = (TextView)findViewById(R.id.layout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent layoutIntent = new Intent(MainActivity.this, Layout.class);
                startActivity(layoutIntent);
            }
        });

        TextView gpa = (TextView)findViewById(R.id.gpa);
        gpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent layoutIntent = new Intent(MainActivity.this, GPA.class);
                startActivity(layoutIntent);
            }
        });

        TextView order = (TextView)findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent layoutIntent = new Intent(MainActivity.this, Order.class);
                startActivity(layoutIntent);
            }
        });



    }
}
