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
    private int planId;
    @ColumnInfo(name = "planMName")
    private String planMName;
    @ColumnInfo(name = "planRecipe")
    private String planRecipe;
    @ColumnInfo(name = "planInstructions")
    private String planInstructions;
    @ColumnInfo(name="planThum")
    private String planThum;
    @ColumnInfo(name = "planYouTube")
    private String planYouTube;
    @ColumnInfo(name = "day")
    private String day;
    @ColumnInfo(name = "type")
    private String type;


    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getPlanMName() {
        return planMName;
    }

    public void setPlanMName(String planMName) {
        this.planMName = planMName;
    }

    public String getPlanRecipe() {
        return planRecipe;
    }

    public void setPlanRecipe(String planRecipe) {
        this.planRecipe = planRecipe;
    }

    public String getPlanInstructions() {
        return planInstructions;
    }

    public void setPlanInstructions(String planInstructions) {
        this.planInstructions = planInstructions;
    }

    public String getPlanThum() {
        return planThum;
    }

    public void setPlanThum(String planThum) {
        this.planThum = planThum;
    }

    public String getPlanYouTube() {
        return planYouTube;
    }

    public void setPlanYouTube(String planYouTube) {
        this.planYouTube = planYouTube;
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
