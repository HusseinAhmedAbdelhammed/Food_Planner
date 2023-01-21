package com.example.foodplanner.database.favorite;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

import com.example.foodplanner.pojo.MealsTable;

import java.util.List;

@Dao
public interface MealDAO {
    @Query("select * from meals")
    Single<List<MealsTable>> getAllMeals();
    @Query("select * from meals where mealName LIKE :name")
    Single<MealsTable> getMeal(String name);
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insertMeal(MealsTable mealsTable);
    @Delete
    Completable deleteMeal(MealsTable mealsTable);
}
