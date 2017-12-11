package com.njltech.android.swipesleft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.Calendar;

public class calculate extends AppCompatActivity {

    static int curDay, curMon, curYear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        Calendar cal = Calendar.getInstance();
        curDay = cal.get(Calendar.DAY_OF_MONTH);
        curMon = cal.get(Calendar.MONTH);
        curMon = curMon + 1;
        curYear = cal.get(Calendar.YEAR);

        Toast.makeText(calculate.this, "Current date is " + (curMon) + " / " + curDay + " / " + curYear, Toast.LENGTH_LONG).show();

        //https://stackoverflow.com/questions/4967799/how-to-know-the-calling-activity-in-android
        int callingActivity = getIntent().getIntExtra("calling-activity", 0);

        TextView perDay = findViewById(R.id.txtLeftPerDay);
        TextView perWeek = findViewById(R.id.txtLeftPerWeek);
        TextView perMonth = findViewById(R.id.txtLeftPerMonth);
        TextView displayDay = findViewById(R.id.txtDisplayPerDay);
        TextView displayWeek = findViewById(R.id.txtDisplayPerWeek);
        TextView displayMonth = findViewById(R.id.txtDisplayPerMonth);
        TextView startDate = findViewById(R.id.txtStartDate);
        TextView endDate = findViewById(R.id.txtEndDate);

        DecimalFormat df = new DecimalFormat(".##");

        switch (callingActivity){
            case ActivityConstants.swipes:
                //Called from swipes
                startDate.setText(curMon+"/"+curDay+"/"+curYear);
                endDate.setText(swipe.setMonth+"/"+swipe.setDay+"/"+swipe.setYear);

                LocalDate start = new LocalDate(curYear,curMon,curDay); //set start date
                LocalDate end = new LocalDate(swipe.setYear,swipe.setMonth,swipe.setDay); //set end date
                Days daysToEndSemester = Days.daysBetween(start, end); //calculate days between

                double daysLeft = daysToEndSemester.getDays(); //convert days to a double

                perDay.setText("Swipes per day:");
                perWeek.setText("Swipes per week:");
                perMonth.setText("Swipes per month:");

                double day = swipe.inputSwipes / daysLeft;
                displayDay.setText(String.valueOf(df.format(day)));

                if (daysLeft > 7){
                    double ans = daysLeft / 7;
                    double week = swipe.inputSwipes / ans;
                    displayWeek.setText(String.valueOf(df.format(week)));
                }
                else{
                    displayWeek.setText("N/A");
                }

                if (daysLeft > 30){
                    double ans = daysLeft / 30;
                    double month = swipe.inputSwipes / ans;
                    displayMonth.setText(String.valueOf(df.format(month)));
                }
                else{
                    displayMonth.setText("N/A");
                }
                break;

            case ActivityConstants.cash:
                //Called from cash
                startDate.setText(curMon+"/"+curDay+"/"+curYear);
                endDate.setText(cash.setMonth+"/"+cash.setDay+"/"+cash.setYear);

                LocalDate cashStart = new LocalDate(curYear,curMon,curDay); //set start date
                LocalDate cashEnd = new LocalDate(cash.setYear,cash.setMonth,cash.setDay); //set end date
                Days cashDaysToEndSemester = Days.daysBetween(cashStart, cashEnd); //calculate days between

                double cashDaysLeft = cashDaysToEndSemester.getDays(); //convert days to a double

                perDay.setText("Cash per day:");
                perWeek.setText("Cash per week:");
                perMonth.setText("Cash per month:");

                double cashDay = cash.inputCash / cashDaysLeft;
                displayDay.setText("$ " + String.valueOf(df.format(cashDay)));

                if (cashDaysLeft > 7){
                    double ans = cashDaysLeft / 7;
                    double cashWeek = cash.inputCash / ans;
                    displayWeek.setText("$ " + String.valueOf(df.format(cashWeek)));
                }
                else{
                    displayWeek.setText("N/A");
                }

                if (cashDaysLeft > 30){
                    double ans = cashDaysLeft / 30;
                    double cashMonth = cash.inputCash / ans;
                    displayMonth.setText("$ " + String.valueOf(df.format(cashMonth)));
                }
                else{
                    displayMonth.setText("N/A");
                }
                break;
        }

        Button reset = findViewById(R.id.btnReset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(calculate.this, swipe_cash.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
