package com.example.foodplanner.database.favorite;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.foodplanner.pojo.MealsTable;

import java.util.List;

@Dao
public interface MealDAO {
    @Query("select * from meals")
    List<MealsTable> getAllMeals();
    @Query("select * from meals where mealName LIKE :name")
    MealsTable getMeal(String name);
    @Insert
    void insertMeal(MealsTable mealsTable);
    @Delete
    void deleteMeal(MealsTable mealsTable);
}
