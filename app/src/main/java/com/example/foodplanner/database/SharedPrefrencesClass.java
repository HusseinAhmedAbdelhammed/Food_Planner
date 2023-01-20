package com.example.foodplanner.database;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefrencesClass {
    SharedPreferences sharedPref;
    static boolean isFirstTime;
    static boolean isLogedIn;
    static String fileName = "foodPlanner";
    static SharedPreferences.Editor editor;


    public SharedPrefrencesClass(Activity activity) {
        sharedPref =activity.getSharedPreferences(fileName,Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        isFirstTime = sharedPref.getBoolean("firstTime", true);
        isLogedIn = sharedPref.getBoolean("logedIn", true);
    }

    public static boolean isIsFirstTime() {
        return isFirstTime;
    }

    public static void setIsFirstTime(boolean isFirstTime) {
        editor.putBoolean("firstTime", isFirstTime);
        editor.commit();
        SharedPrefrencesClass.isFirstTime = isFirstTime;
    }

}
