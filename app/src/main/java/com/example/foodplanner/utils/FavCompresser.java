package com.example.foodplanner.utils;

import android.content.Context;
import android.widget.Toast;

import com.example.foodplanner.pojo.MealsTable;
import com.example.foodplanner.pojo.PlanModel;
import com.example.foodplanner.presenters.interfaces.FavCompresserInterface;
import com.example.foodplanner.repository.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavCompresser implements FavCompresserInterface {
    public Map<String,Object> meals;
    public ArrayList<Map<String,Object>> mealsList;
    public Map<String,Object> plans;
    public ArrayList<Map<String,Object>> plansList;
    public Context context;
    public FavCompresser(Context context){
        this.context=context;
    }

    public void favBackup(){
        Repository.getInstance(context).getFavoriteMap(this);
    }
    public void planBackup(){
        Repository.getInstance(context).getPlansMap(this);
    }
    public void dataTest(){
        Repository.getInstance(context).getDataFromFireStore();
    }

    @Override
    public void insertMealsMap(List<MealsTable> mealsTableList) {
        mealsList=new ArrayList<>();
        for(int i=0;i<mealsTableList.size();i++){
            meals=new HashMap<>();
            meals.put("id",mealsTableList.get(i).getMealId());
            meals.put("name",mealsTableList.get(i).getMealName());
            meals.put("thum",mealsTableList.get(i).getThum());
            meals.put("instructions",mealsTableList.get(i).getInstructions());
            meals.put("recipe",mealsTableList.get(i).getRecipe());
            meals.put("youTube",mealsTableList.get(i).getYouTube());
            mealsList.add(meals);
        }
        Repository.getInstance(context).backup(mealsList);

    }

    @Override
    public void insertPlansMap(List<PlanModel> plansListd) {
        plansList=new ArrayList<>();

        for(int i=0;i<plansListd.size();i++){
            plans=new HashMap<>();
            plans.put("planId",plansListd.get(i).getPlanID());
            plans.put("planMealName",plansListd.get(i).getMealName());
            plans.put("day",plansListd.get(i).getDay());
            plans.put("type",plansListd.get(i).getType());
            plans.put("planThum",plansListd.get(i).getMealThum());
            plansList.add(plans);
        }
        if(plansList.size()==0){
            Toast.makeText(context, "noooooooooooooooooo", Toast.LENGTH_LONG).show();
        }
        Repository.getInstance(context).backupPlan(plansList);
    }
}
