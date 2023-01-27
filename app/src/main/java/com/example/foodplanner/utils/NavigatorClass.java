package com.example.foodplanner.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import android.window.SplashScreen;

import android.widget.ImageView;


import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.foodplanner.R;
import com.example.foodplanner.view.activities.HomeActivity;

import com.example.foodplanner.view.activities.MainActivity;
import com.example.foodplanner.view.fragment.SplashFragment;

import com.example.foodplanner.view.activities.PlanActivity;


public class NavigatorClass {
    static Intent intent;
    public static final int HOME=1;
    public static final int MAIN = 2;
    public static void navigateBetweenFragments(View view, int distension){
        Navigation.findNavController(view).navigate(distension);
    }
    public static void navigateBetweenFragments(View distention){
//        Navigation.findNavController(activity, distension);
        Navigation.findNavController(distention);
//        Navigation.findNavController(context).navigate(distension);
    }
    public static void navigateBetweenActivities(Context context,int distension){
        switch (distension){
            case HOME:
                intent=new Intent(context, HomeActivity.class);
                context.startActivity(intent);
                break;
            case MAIN:
                intent=new Intent(context, MainActivity.class);
                context.startActivity(intent);
                break;
        }


    }
    public static void navigateToPlan(Context context, String extra, ImageView imageView){
        String localUrl=ImageLoader.saveImageToRoom(imageView,context,extra);
        intent=new Intent(context, PlanActivity.class);
        intent.putExtra("mealName",extra);
        intent.putExtra("mealThum",localUrl);
        context.startActivity(intent);
    }
}
