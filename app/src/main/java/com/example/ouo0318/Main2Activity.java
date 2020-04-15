package com.example.ouo0318;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Main2Activity extends AppCompatActivity {

    private TextView name;
    private ImageView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView name =(TextView) findViewById(R.id.ivname);
        ImageView view =(ImageView) findViewById(R.id.ivpic);
        TextView info=(TextView) findViewById(R.id.ivinfo);


        Bundle bundle = this.getIntent().getExtras();
        String h = bundle.getString("height");
        String w = bundle.getString("wehight");
        String n = bundle.getString("name");

        double bmi = Double.parseDouble(w) /(Double.parseDouble(h) /100.0 * Double.parseDouble(h) /100.0);
        DecimalFormat df= new DecimalFormat( "#.##" );


        String msg= " ";
        if (bmi<18.5) {
            msg="過輕";
            view.setImageResource(R.drawable.a1);
        } else if (bmi>25) {
            msg="過重";
            view.setImageResource(R.drawable.a3);
        } else {
            msg="正常";
            view.setImageResource(R.drawable.a2);
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        info.setText(n+"您的BMI是"+df.format(bmi));


    }
}
