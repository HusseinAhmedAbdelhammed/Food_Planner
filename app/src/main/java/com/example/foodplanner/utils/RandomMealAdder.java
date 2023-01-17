package com.example.foodplanner.utils;

import com.example.foodplanner.pojo.Meals;

import java.util.ArrayList;

public class RandomMealAdder {
    private static ArrayList<Meals>randMeals=new ArrayList<>();
    public static void addRandomMeal(Meals meals){
        randMeals.add(meals);
    }
    public static  ArrayList<Meals> returnMeal(){
        return randMeals;
    }
}
