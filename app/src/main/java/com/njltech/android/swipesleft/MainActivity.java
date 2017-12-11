package com.njltech.android.swipesleft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        setContentView(R.layout.activity_main);

        Button ru = findViewById(R.id.rutgers);
        ru.setOnClickListener(this);
        Button psu = findViewById(R.id.psu);
        psu.setOnClickListener(this);
        Button esu = findViewById(R.id.esu);
        esu.setOnClickListener(this);
        Button moravian = findViewById(R.id.moravian);
        moravian.setOnClickListener(this);
        Button rowan = findViewById(R.id.rowan);
        rowan.setOnClickListener(this);
        Button usc = findViewById(R.id.usc);
        usc.setOnClickListener(this);
    }

    public void onClick (View v){
        switch(v.getId()){
            case R.id.rutgers:
                Intent rutgers = new Intent(this, swipe_cash.class);
                rutgers.putExtra("call-activity", ActivityConstants.rutgers);
                startActivity(rutgers);
                break;
            case R.id.psu:
                Intent psu = new Intent(this, swipe_cash.class);
                psu.putExtra("call-activity", ActivityConstants.psu);
                startActivity(psu);
                break;
            case R.id.esu:
                Intent esu = new Intent(this, swipe_cash.class);
                esu.putExtra("call-activity", ActivityConstants.esu);
                startActivity(esu);
                break;
            case R.id.moravian:
                Intent moravian = new Intent(this, swipe_cash.class);
                moravian.putExtra("call-activity", ActivityConstants.moravian);
                startActivity(moravian);
                break;
            case R.id.rowan:
                Intent rowan = new Intent(this, swipe_cash.class);
                rowan.putExtra("call-activity", ActivityConstants.rowan);
                startActivity(rowan);
                break;
            case R.id.usc:
                Intent usc = new Intent(this, swipe_cash.class);
                usc.putExtra("call-activity", ActivityConstants.usc);
                startActivity(usc);
                break;
        }
    }
}
//TODO: Animation
//TODO: Better icon
//TODO: Better tablet support
//TODO: External link