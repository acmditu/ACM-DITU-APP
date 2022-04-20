package com.afd.dituacm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Projects extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        getSupportActionBar().hide();
        TextView myText = findViewById(R.id.button);
        TextView myText1 = findViewById(R.id.button1);
        TextView myText2 = findViewById(R.id.loginText);

        myText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Projects.this,SignupActivity.class);
                startActivity(i);
            }
        });
        myText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Projects.this,Connect.class);
                startActivity(i);
            }
        });
        myText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Projects.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }
}