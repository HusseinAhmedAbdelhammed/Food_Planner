package com.example.foodplanner.utils;

import android.view.View;

public class DataSaver {
    public static String guest = "";

    public static View view;
    

    public static String getGuest() {
        return guest;
    }

    public static void setGuest(String guest) {
        DataSaver.guest = guest;
    }

    public static View getView() {
        return view;
    }

    public static void setView(View view) {
        DataSaver.view = view;
    }
}
