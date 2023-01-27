package com.example.foodplanner.presenters.classes;

import android.content.Context;

import com.example.foodplanner.pojo.PlanModel;
import com.example.foodplanner.repository.Repository;

public class PlanActivityPresenter {
    private Context con;
    public PlanActivityPresenter(Context con){
        this.con=con;
    }
    public void insertPlan(PlanModel planModel){
        Repository.getInstance(con).insertPlan(planModel);
    }

}
