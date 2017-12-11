package com.njltech.android.swipesleft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Timer set to 4 seconds
        TimerTask task = new TimerTask(){
            @Override
            public void run(){
                finish();
                startActivity(new Intent(Splash.this, MainActivity.class));//CHANGE TO MAIN ACTIVITY AFTER TESTING
            }
        };
        Timer opening = new Timer();
        opening.schedule(task,3000);
    }
}
