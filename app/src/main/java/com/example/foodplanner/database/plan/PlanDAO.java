package com.example.foodplanner.database.plan;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.foodplanner.pojo.MealsTable;
import com.example.foodplanner.pojo.PlanModel;

import java.util.List;

@Dao
public interface PlanDAO {
    @Query("select * from plans")
    List<PlanModel> getAllPlans();
    @Query("select * from plans where pMealName LIKE :name")
    PlanModel getPlan(String name);
    @Insert
    void insertMeal(PlanModel planModel);
    @Delete
    void deleteMeal(PlanModel planModel);
}
