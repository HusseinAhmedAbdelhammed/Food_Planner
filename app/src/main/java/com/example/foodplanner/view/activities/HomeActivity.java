package com.example.foodplanner.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.foodplanner.R;
import com.example.foodplanner.database.SharedPrefrencesClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView=findViewById(R.id.bottomNav);
        NavController navController2= Navigation.findNavController(this,R.id.nav_host_fragment_home);
        NavigationUI.setupActionBarWithNavController(this,navController2);
        NavigationUI.setupWithNavController(bottomNavigationView,navController2);
    }
}