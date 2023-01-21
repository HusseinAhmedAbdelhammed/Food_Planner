package com.example.foodplanner.repository;

import android.content.Context;

import com.example.foodplanner.database.favorite.MealDAO;
import com.example.foodplanner.database.instance.RoomInstance;
import com.example.foodplanner.database.plan.PlanDAO;
import com.example.foodplanner.pojo.MealsTable;
import com.example.foodplanner.pojo.PlanModel;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

public class Repository {
    private Context con;
    private static Repository instance;
    private RoomInstance dataBaseInstance;
    private PlanDAO planDAO;
    private MealDAO mealDAO;
    private Repository(Context con){
        this.con=con;
        dataBaseInstance=RoomInstance.getInstance(con);
        planDAO= dataBaseInstance.planDAO();
        mealDAO= dataBaseInstance.mealDAO();
    }
public static Repository getInstance(Context con){
        if(instance==null){
            instance=new Repository(con);
        }
        return instance;
    }
    public Single<List<PlanModel>> getPlans(){
        return planDAO.getAllPlans();
    }
    public Completable insertPlan(PlanModel planModel){
        return planDAO.insertMeal(planModel);
    }
    public Completable deletePlan(PlanModel planModel){
        return planDAO.deleteMeal(planModel);
    }
    public Single<List<MealsTable>>getFavorite(){
        return mealDAO.getAllMeals();
    }
    public Completable insertFavorite(MealsTable mealsTable){
        return mealDAO.insertMeal(mealsTable);
    }
    public Completable deleteFavorite(MealsTable mealsTable){
        return mealDAO.deleteMeal(mealsTable);
    }

}
