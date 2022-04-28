package com.afd.dituacm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class Splashscreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        getSupportActionBar().hide();
        SharedPreferences channel=getSharedPreferences("welcomePages", Context.MODE_PRIVATE);
        boolean skip=channel.getBoolean("hasSeen",false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
if(skip){
    Intent i=new Intent(Splashscreen.this,LoginActivity.class);
    startActivity(i);
    finish();
}
else {
    Intent i = new Intent(Splashscreen.this, WelcomeScreen.class);
    startActivity(i);
    finish();
}
            }
        },1500);
    }
}