package com.example.lab5_bai1_2;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, toolbar, R.string.open, R.string.close);
        abdt.setDrawerIndicatorEnabled(true);
        abdt.syncState();
        drawerLayout.addDrawerListener(abdt);

        NavigationView nav = findViewById(R.id.nav_view);
        nav.setNavigationItemSelectedListener(item -> {
            Fragment fragment = new Home();
            toolbar.setTitle(R.string.trang_chu);
            if (item.getItemId() == R.id.nav_bookmark){
                toolbar.setTitle(R.string.dau_trang);
                fragment = new BookmarkFragment();
            } if (item.getItemId() == R.id.nav_setting){
                toolbar.setTitle(R.string.cai_dat);
                fragment = new SettingsFragment();
            } if (item.getItemId() == R.id.nav_logout){
                finish();
            }
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment)
                    .commit();
            drawerLayout.close();
            return true;
        });
    }
}