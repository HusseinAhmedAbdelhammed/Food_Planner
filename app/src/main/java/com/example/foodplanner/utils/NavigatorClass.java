package com.example.foodplanner.utils;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.navigation.Navigation;

import com.example.foodplanner.view.activities.HomeActivity;

public class NavigatorClass {
    static Intent intent;
    public static final int HOME=1;
    public static void navigateBetweenFragments(View view, int distension){
        Navigation.findNavController(view).navigate(distension);

    }
    public static void navigateBetweenActivities(Context context,int distension){
        switch (distension){
            case HOME:
                intent=new Intent(context, HomeActivity.class);
                context.startActivity(intent);
                break;

        }

    }
}
