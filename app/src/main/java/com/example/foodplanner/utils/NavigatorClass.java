package com.example.foodplanner.utils;

import android.content.Context;
import android.content.Intent;

import com.example.foodplanner.view.activities.TestActivity;

public class NavigatorClass {
    public static Intent intent;
    public static final int TEST=1;
    public static void navigate(Context con,int pos){
        switch (pos){
            case TEST:
                intent=new Intent(con, TestActivity.class);
                con.startActivity(intent);

        }
    }
}
