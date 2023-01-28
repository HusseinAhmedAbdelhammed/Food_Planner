package com.example.foodplanner.presenters.interfaces;

import com.example.foodplanner.pojo.MealsTable;
import com.example.foodplanner.pojo.PlanModel;

import java.util.List;

public interface FavCompresserInterface {
    void insertMealsMap(List<MealsTable>mealsTableList);
    void insertPlansMap(List<PlanModel> plans);
}
