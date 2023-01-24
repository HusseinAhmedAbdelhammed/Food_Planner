package com.example.foodplanner.utils;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.example.foodplanner.pojo.Meals;
import com.example.foodplanner.view.activities.MealDetailsActivity;

public class MealSender {
    public static final String PASSED_MEAL = "PASSED_MEAL";
    public static void sendMeal(View view, Context context, Meals meals){
        Intent intent = new Intent(context, MealDetailsActivity.class);
        intent.putExtra(PASSED_MEAL, meals);
        view.getContext().startActivity(intent);
    }
}
