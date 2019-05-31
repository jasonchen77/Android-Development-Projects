package com.example.jchen319_utility;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    EditText principal, rate, time;
    RadioButton perMonth, perYear, months, years;
    TextView result;
    String ratePer, timeMorY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principal = (EditText) findViewById(R.id.editTextPrincipal);
        rate = (EditText) findViewById(R.id.editTextRate);
        time = (EditText) findViewById(R.id.editTextTime);
        result = (TextView) findViewById(R.id.textViewResults);

        perMonth = (RadioButton) findViewById(R.id.radioButtonPerMonth);
        if (perMonth != null){
            perMonth.setOnCheckedChangeListener(this);
        }
        perYear = (RadioButton) findViewById(R.id.radioButtonPerYear);
        if (perYear != null){
            perYear.setOnCheckedChangeListener(this);
        }
        months = (RadioButton) findViewById(R.id.radioButtonMonths);
        if (months != null) {
            months.setOnCheckedChangeListener(this);
        }
        years = (RadioButton) findViewById(R.id.radioButtonYears);
        if (years != null) {
            years.setOnCheckedChangeListener(this);
        }
    }

    public void calculate(View view){

        float interest;
        float total;
        float p = Integer.valueOf(principal.getText().toString());
        float r = Integer.valueOf(rate.getText().toString());
        float t = Integer.valueOf(time.getText().toString());

        if (ratePer.equals("PerMonth") && timeMorY.equals("Months")){
            interest = p * r * t / 100;
        }
        else if (ratePer.equals("PerMonth") && timeMorY.equals("Years")){
            interest = p * r * t * 12 / 100;
        }
        else if (ratePer.equals("PerYear") && timeMorY.equals("Months")){
            interest = p * r * t / 12 / 100;
        }
        else {
            interest = p * r * t / 100;
        }

        total = p + interest;

        result.setText("Interest: $" + String.format("%.2f", interest) + "\nTotal: $" + String.format("%.2f", total));
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        switch (buttonView.getId()){

            case R.id.radioButtonPerMonth:
                if (isChecked){
                    ratePer = "PerMonth";
                }
                break;

            case R.id.radioButtonPerYear:
                if (isChecked){
                    ratePer = "PerYear";
                }
                break;

            case R.id.radioButtonMonths:
                if (isChecked){
                    timeMorY = "Months";
                }
                break;

            case R.id.radioButtonYears:
                if (isChecked){
                    timeMorY = "Years";
                }
                break;
        }
    }
}
