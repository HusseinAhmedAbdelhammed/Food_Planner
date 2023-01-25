package com.example.foodplanner.presenters.classes;

import android.content.Context;

import com.example.foodplanner.pojo.MealsTable;
import com.example.foodplanner.repository.Repository;

public class MealDetailsPresenter {
    Context context;

    public MealDetailsPresenter(Context context) {
        this.context = context;
    }

   public void insertMeal(MealsTable mealsTable){
        Repository.getInstance(context).insertFavorite(mealsTable);
    }
}
