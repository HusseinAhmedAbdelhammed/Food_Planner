package com.example.foodplanner.database.instance;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.foodplanner.database.favorite.MealDAO;
import com.example.foodplanner.pojo.MealsTable;

@Database(entities = {MealsTable.class, PlanModel.class},version = 1)
public abstract class RoomInstance extends RoomDatabase {
    private static RoomInstance instance=null;
    public abstract MealDAO mealDAO();
    public static synchronized RoomInstance getInstance(Context con){
        if(instance==null){
            instance= Room.databaseBuilder(con.getApplicationContext(),RoomInstance.class,"mealsDB").build();
        }
        return instance;
    }

}
