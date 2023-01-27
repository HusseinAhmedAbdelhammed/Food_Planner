package com.example.foodplanner.pojo;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "plans")
public class PlanModel {
    @PrimaryKey
    @ColumnInfo(name = "planID")
    @NonNull
    private long planID;
    @ColumnInfo(name = "mealName")
    private String mealName;
    @ColumnInfo(name="mealThum")
    private String mealThum;
    @ColumnInfo(name = "day")
    private String day;
    @ColumnInfo(name = "type")
    private String type;

    public long getPlanID() {
        return planID;
    }

    public void setPlanID(long planID) {
        this.planID = planID;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealThum() {
        return mealThum;
    }

    public void setMealThum(String mealThum) {
        this.mealThum = mealThum;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
