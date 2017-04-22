package com.example.android.layoutandgpa;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;


public class Order extends AppCompatActivity {

    Switch s;
    Chronometer c;
    DatePicker datePicker;
    TimePicker timePicker;
    TextView t1,t2,t3,t4,t5,t6,t7;
    EditText et1,et2;
    Button b1,b2;
    GridLayout grid,grid2;
    LinearLayout linear;
    String adult,child;
    int page = 0;
    int year,month,date,hour,min = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        s = (Switch)findViewById(R.id.switch1);
        c = (Chronometer)findViewById(R.id.chr);
        datePicker = (DatePicker)findViewById(R.id.dPicker);
        timePicker = (TimePicker)findViewById(R.id.tPicker);
        t1 = (TextView)findViewById(R.id.text1);
        t2 = (TextView)findViewById(R.id.text2);
        t3 = (TextView)findViewById(R.id.text3);
        t4 = (TextView)findViewById(R.id.text4);
        t5 = (TextView)findViewById(R.id.text5);
        t6 = (TextView)findViewById(R.id.text6);
        t7 = (TextView)findViewById(R.id.text7);
        et1 = (EditText)findViewById(R.id.e1);
        et2 = (EditText)findViewById(R.id.e2);
        b1 = (Button)findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        grid = (GridLayout)findViewById(R.id.gLayout);
        grid2 = (GridLayout)findViewById(R.id.g2Layout);
        linear = (LinearLayout)findViewById(R.id.lLayout);


        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    page = 1;
                    NextPage(page);
                }else{
                    page = 0;
                    c.setVisibility(View.INVISIBLE);
                    datePicker.setVisibility(View.INVISIBLE);
                    timePicker.setVisibility(View.INVISIBLE);
                    grid.setVisibility(View.INVISIBLE);
                    grid2.setVisibility(View.INVISIBLE);
                    linear.setVisibility(View.INVISIBLE);
                    t1.setVisibility(View.INVISIBLE);
                    c.stop();
                    c.setBase(SystemClock.elapsedRealtime());
                    et1.setText(null);
                    et2.setText(null);
                    hour = 0;
                    min = 0;
                }
            }
        });
    }
    public void onButton (View v){
        if (v.getId() == R.id.button2){
            page++;
            NextPage(page);
        }if(v.getId() == R.id.button1){
            page--;
            NextPage(page);
        }
    }
    public void NextPage(int page){
        if (page == 1){
            t1.setVisibility(View.VISIBLE);
            c.setVisibility(View.VISIBLE);
            datePicker.setVisibility(View.VISIBLE);
            linear.setVisibility(View.VISIBLE);
            b1.setEnabled(false);
            b2.setEnabled(true);
            c.start();
            timePicker.setVisibility(View.INVISIBLE);
            grid.setVisibility(View.INVISIBLE);
            grid2.setVisibility(View.INVISIBLE);

        }
        else if(page == 2){
            datePicker.setVisibility(View.INVISIBLE);
            timePicker.setVisibility(View.VISIBLE);
            linear.setVisibility(View.VISIBLE);
            grid.setVisibility(View.INVISIBLE);
            grid2.setVisibility(View.INVISIBLE);
            b1.setEnabled(true);
            b2.setEnabled(true);

            hour = timePicker.getHour();
            min = timePicker.getMinute();
        }
        else if (page == 3){
            grid.setVisibility(View.VISIBLE);
            linear.setVisibility(View.VISIBLE);
            datePicker.setVisibility(View.INVISIBLE);
            timePicker.setVisibility(View.INVISIBLE);
            grid2.setVisibility(View.INVISIBLE);
            b1.setEnabled(true);
            b2.setEnabled(true);


        }
        else if (page == 4){
            grid2.setVisibility(View.VISIBLE);
            linear.setVisibility(View.VISIBLE);
            datePicker.setVisibility(View.INVISIBLE);
            timePicker.setVisibility(View.INVISIBLE);
            grid.setVisibility(View.INVISIBLE);

            year = datePicker.getYear();
            month = datePicker.getMonth()+1;
            date = datePicker.getDayOfMonth();

            t4.setText("The Date will be : "+ year + " . " + month + " . " + date);
            t5.setText("The time will be : "+ hour + " hr " + min+" min");


            adult = et1.getText().toString();
            child = et2.getText().toString();

            t6.setText("Number of Adults : "+ adult+"");
            t7.setText("Number of Children : "+ child+"");
            b1.setEnabled(true);
            b2.setEnabled(false);
        }
    }
}
