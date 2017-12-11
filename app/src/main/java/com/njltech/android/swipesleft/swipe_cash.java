package com.njltech.android.swipesleft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class swipe_cash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_swipe_cash);

        SetActionBar();

        //Swipes button
        Button swipe = findViewById(R.id.btnSwipesLeft);
        swipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(swipe_cash.this, swipe.class);
                startActivity(intent);
                finish();
            }
        });

        //Cash button
        Button cash = findViewById(R.id.btnCashLeft);
        cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(swipe_cash.this, cash.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void SetActionBar(){
        final int callActivity = getIntent().getIntExtra("call-activity", 0);

        switch(callActivity){
            case ActivityConstants.rutgers:
                setTitle("     Rutgers University");
                getSupportActionBar().setIcon(R.drawable.ru_logo_small);
                break;
            case ActivityConstants.psu:
                setTitle("     Penn State University");
                getSupportActionBar().setIcon(R.drawable.psu_logo_small);
                break;
            case ActivityConstants.esu:
                setTitle("     East Stroudsburg University");
                getSupportActionBar().setIcon(R.drawable.esu_logo_small);
                break;
            case ActivityConstants.moravian:
                setTitle("     Moravian College");
                getSupportActionBar().setIcon(R.drawable.moravian_logo_small);
                break;
            case ActivityConstants.rowan:
                setTitle("     Rowan University");
                getSupportActionBar().setIcon(R.drawable.rowan_logo_small);
                break;
            case ActivityConstants.usc:
                setTitle("     University of South Carolina");
                getSupportActionBar().setIcon(R.drawable.usc_logo_small);
                break;
        }
    }
}

//TODO: Don't allow dates before todays date on both swipes.java and cash.java