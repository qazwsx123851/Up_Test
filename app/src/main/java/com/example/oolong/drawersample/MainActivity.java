package com.example.oolong.drawersample;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private TextView tvname;
    //使用代码块直接设置NightMode
    static {
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Title");
        setupToolbarMenu();
        setupNavigationDrawerMenu();
    }

    private void setupToolbarMenu() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("首頁");
    }

    private void setupNavigationDrawerMenu() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                mToolbar,
                R.string.drawer_open,
                R.string.drawer_close);
        mDrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    @Override // Called when Any Navigation Item is Clicked
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        String itemName = (String) item.getTitle();
        tvname = findViewById(R.id.tvname);
        Toast.makeText(MainActivity.this, itemName + " Clicked", Toast.LENGTH_SHORT).show();
        closeDrawer();
        switch (item.getItemId()) {
            case R.id.item_facebook:
                // Put your Item specific Code here
                tvname.setText("FaceBook");
                break;
            case R.id.item_bag:
                // Put your item specific Code here
                break;
        }
        return true;
    }

    // Close the Drawer
    private void closeDrawer() {
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    // Open the Drawer
    private void showDrawer() {
        mDrawerLayout.openDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START))
            closeDrawer();
        else
            super.onBackPressed();
    }

    public void butclick(View view) {
        Toast.makeText(MainActivity.this,  " Clicked", Toast.LENGTH_SHORT).show();
    }
}
