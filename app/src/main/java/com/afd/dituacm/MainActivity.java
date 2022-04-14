package com.afd.dituacm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNav);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                new Fragment1()).commit();


    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNav = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selected = null;
            switch (item.getItemId()){
                case R.id.home_bottom:
                    selected = new Fragment1();
                    break;

                case R.id.message_bottom:
                    selected = new Fragment2();
                    break;

                case R.id.notifiactions_bottom:
                    selected = new Fragment3();
                    break;

                case R.id.resources_bottom:
                    selected = new Fragment4();
                    break;

                case R.id.settings_bottom:
                    selected = new Fragment5();
                    break;


            }

            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                    selected).commit();

            return true;
        }
    };


}