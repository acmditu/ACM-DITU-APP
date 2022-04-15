package com.afd.dituacm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNav);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                new Fragment_Home()).commit();


    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNav = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selected = null;
            switch (item.getItemId()){
                case R.id.home_bottom:
                    selected = new Fragment_Home();
                    break;

                case R.id.message_bottom:
                    selected = new Fragment_Message();
                    break;

                case R.id.notifiactions_bottom:
                    selected = new Fragment_Notification();
                    break;

                case R.id.resources_bottom:
                    selected = new Fragment_Resources();
                    break;

                case R.id.settings_bottom:
                    selected = new Fragment_Settings();
                    break;


            }

            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                    selected).commit();

            return true;
        }
    };


}