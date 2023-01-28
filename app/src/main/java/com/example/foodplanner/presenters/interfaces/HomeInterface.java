package com.example.foodplanner.presenters.interfaces;

import com.example.foodplanner.pojo.CategoriesList;
import com.example.foodplanner.pojo.Country;
import com.example.foodplanner.pojo.Meals;
import com.example.foodplanner.pojo.MealsList;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.CheckedOutputStream;

public interface HomeInterface {
     void showRandomMeals(List<MealsList> mealsArrayList);
     void showCats(CategoriesList categoriesList);
     void getCountries(MealsList mealsList);
     void showCountries(ArrayList<Country> countries);

}
