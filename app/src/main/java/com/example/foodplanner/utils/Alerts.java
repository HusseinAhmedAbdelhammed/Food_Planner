package com.example.foodplanner.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

import com.example.foodplanner.R;
import com.example.foodplanner.view.activities.MealDetailsActivity;

public class Alerts {
    public static void setAlert(Context context, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message);
        builder.setTitle("Alert !");
        builder.setCancelable(false);
        builder.setPositiveButton("LogIn", (DialogInterface.OnClickListener) (dialog, which) -> {
            NavigatorClass.navigateBetweenActivities(context, NavigatorClass.MAIN);
        });
        builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
            dialog.cancel();
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public static void setAlert(Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Sorry you are OFFLINE you can see your favourite and plan meals only");
        builder.setTitle("OOPS!");
        builder.setCancelable(false);
        builder.setPositiveButton("Favourite", (DialogInterface.OnClickListener) (dialog, which) -> {
            NavigatorClass.navigateBetweenFragments(DataSaver.getView(), R.id.favouriteFragment);
        });
        builder.setNegativeButton("Plane", (DialogInterface.OnClickListener) (dialog, which) -> {
            NavigatorClass.navigateBetweenFragments(DataSaver.getView(), R.id.planFragment);
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
