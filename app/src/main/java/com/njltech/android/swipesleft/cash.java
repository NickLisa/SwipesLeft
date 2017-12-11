package com.njltech.android.swipesleft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class cash extends AppCompatActivity {

    public static int setYear, setMonth, setDay;
    public static double inputCash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash);

        final DatePicker dp = findViewById(R.id.datePicker);
        //dp.setOnDateChangedListener(dateChangedListener); //on date change calls dateChangedListener

        //Calculate button
        Button calculate = findViewById(R.id.btnCalculate);
        calculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setYear = dp.getYear();
                setMonth = (dp.getMonth()+1);
                setDay = dp.getDayOfMonth();

                EditText cashLeft = findViewById(R.id.inputCash);
                inputCash = Integer.parseInt(cashLeft.getText().toString()); //pulls value from editText
                Intent intent = new Intent(cash.this, calculate.class);
                intent.putExtra("calling-activity", ActivityConstants.cash); //identifies to calculate function that is should calculate swipes
                startActivity(intent);
                finish();
            }
        });
    }

    //When date is changed this sets the new date variables
    private DatePicker.OnDateChangedListener dateChangedListener = new DatePicker.OnDateChangedListener() {
        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            setYear = view.getYear();
            setMonth = (view.getMonth()+1);
            setDay = view.getDayOfMonth();

            Toast.makeText(cash.this, "Picked date is " + (view.getMonth()+1) +
                    " / " + view.getDayOfMonth() +
                    " / " + view.getYear(), Toast.LENGTH_LONG).show();
        }
    };
}