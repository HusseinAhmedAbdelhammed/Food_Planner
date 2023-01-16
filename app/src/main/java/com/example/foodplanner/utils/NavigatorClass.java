package com.example.foodplanner.utils;

import android.view.View;

import androidx.navigation.Navigation;

public class NavigatorClass {
    public static void navigateBetweenFragments(View view, int distension){
        Navigation.findNavController(view).navigate(distension);

    }
}
