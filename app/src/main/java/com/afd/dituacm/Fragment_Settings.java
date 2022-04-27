package com.afd.dituacm;
import android.media.Image;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import javax.net.ssl.SSLEngineResult;

public class Fragment_Settings extends Fragment {

    DrawerLayout drawerLayout;
    NavigationView navview;
    Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings,container,false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        drawerLayout=view.findViewById(R.id.drawerlayout);
        navview=view.findViewById(R.id.navigationview);
        toolbar=view.findViewById(R.id.toolbar);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(getActivity(),drawerLayout,toolbar,R.string.navigation_open,R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        
        return view;
    }
}
