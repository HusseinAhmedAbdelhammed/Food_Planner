package com.example.foodplanner.database;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefrencesClass {
    static SharedPreferences sharedPref;
    static boolean isFirstTime;
    static boolean isLogedIn;
    static String sharedPrefEmail;
    static String fileName = "foodPlanner";
    static SharedPreferences.Editor editor;


    public SharedPrefrencesClass(Activity activity) {
        sharedPref =activity.getSharedPreferences(fileName,Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        isFirstTime = sharedPref.getBoolean("firstTime", true);
        isLogedIn = sharedPref.getBoolean("logedIn", false);
    }

    public static boolean isIsFirstTime() {
        return isFirstTime;
    }

    public static void setIsFirstTime(boolean isFirstTime) {
        editor.putBoolean("firstTime", isFirstTime);
        editor.commit();
        SharedPrefrencesClass.isFirstTime = isFirstTime;
    }

    public static boolean isIsLogedIn() {
        return isLogedIn;
    }

    public static void setIsLogedIn(boolean isLogedIn) {
        editor.putBoolean("logedIn", isLogedIn);
        editor.commit();
        SharedPrefrencesClass.isLogedIn = isLogedIn;
    }

    public static void setEmailWithSaredPref(String email){
        editor.putString("sharedPrefEmail", email);
        editor.commit();
        SharedPrefrencesClass.sharedPrefEmail  = email;
    }

    public static String getSharedPrefEmail() {
        return sharedPref.getString("sharedPrefEmail",sharedPrefEmail);
    }
}
