package com.example.foodplanner.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.foodplanner.R;
import com.example.foodplanner.utils.Consts;
import com.example.foodplanner.utils.DataSaver;
import com.example.foodplanner.utils.NavigatorClass;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);
        NavHostFragment navHost = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHost.getNavController();
        NavInflater navInflater = navController.getNavInflater();
        NavGraph graph = navInflater.inflate(R.navigation.splach_login_signup_navigator);
        if (DataSaver.getGuest().equals(Consts.GUEST)) {
            graph.setStartDestination(R.id.loginFragment);
        } else {
            graph.setStartDestination(R.id.splashFragment);
        }
        navController.setGraph(graph);
    }
}