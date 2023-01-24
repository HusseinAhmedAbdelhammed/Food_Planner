package com.example.foodplanner.database.plan;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

import com.example.foodplanner.pojo.MealsTable;
import com.example.foodplanner.pojo.PlanModel;

import java.util.List;

@Dao
public interface PlanDAO {
    @Query("select * from plans")
    Single<List<PlanModel>> getAllPlans();
    @Query("select * from plans where day LIKE :day")
    Single<PlanModel> getPlan(String day);
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insertMeal(PlanModel planModel);
    @Delete
    Completable deleteMeal(PlanModel planModel);
}
