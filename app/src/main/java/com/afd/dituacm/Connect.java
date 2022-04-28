package com.afd.dituacm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Connect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        getSupportActionBar().hide();


        TextView myText = findViewById(R.id.forwardbutton);
        TextView myText1 = findViewById(R.id.backwardButton);
        TextView myText2 = findViewById(R.id.loginText);

        myText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Connect.this,Project.class);
                startActivity(i);
                finish();
            }
        });
        myText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Connect.this,WelcomeScreen.class);
                startActivity(i);
            }
        });
        myText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Connect.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}