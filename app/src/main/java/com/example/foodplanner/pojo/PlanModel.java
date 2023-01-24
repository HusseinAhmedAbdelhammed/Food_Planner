package com.example.foodplanner.pojo;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "plans")
public class PlanModel {
    @PrimaryKey
    @ColumnInfo(name = "planId")
    @NonNull
    private long planId;
    @ColumnInfo(name = "breakfastMeal")
    private String breakfastMeal;
    @ColumnInfo(name = "dinnerMeal")
    private String dinnerMeal;
    @ColumnInfo(name = "lunchMeal")
    private String lunchMeal;
    @ColumnInfo(name="breakfastThum")
    private String breakfastThum;
    @ColumnInfo(name="dinnerThum")
    private String dinnerThum;
    @ColumnInfo(name="lunchThum")
    private String lunchThum;
    @ColumnInfo(name = "day")
    private String day;

    public long getPlanId() {
        return planId;
    }

    public void setPlanId(long planId) {
        this.planId = planId;
    }

    public String getBreakfastMeal() {
        return breakfastMeal;
    }

    public void setBreakfastMeal(String breakfastMeal) {
        this.breakfastMeal = breakfastMeal;
    }

    public String getDinnerMeal() {
        return dinnerMeal;
    }

    public void setDinnerMeal(String dinnerMeal) {
        this.dinnerMeal = dinnerMeal;
    }

    public String getLunchMeal() {
        return lunchMeal;
    }

    public void setLunchMeal(String lunchMeal) {
        this.lunchMeal = lunchMeal;
    }

    public String getBreakfastThum() {
        return breakfastThum;
    }

    public void setBreakfastThum(String breakfastThum) {
        this.breakfastThum = breakfastThum;
    }

    public String getDinnerThum() {
        return dinnerThum;
    }

    public void setDinnerThum(String dinnerThum) {
        this.dinnerThum = dinnerThum;
    }

    public String getLunchThum() {
        return lunchThum;
    }

    public void setLunchThum(String lunchThum) {
        this.lunchThum = lunchThum;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
