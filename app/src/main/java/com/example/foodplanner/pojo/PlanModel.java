package com.example.foodplanner.pojo;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "plans")
public class PlanModel {
    @PrimaryKey
    @ColumnInfo(name = "pMealId")
    @NonNull
    private int pMealId;
    @ColumnInfo(name = "pMealName")
    private String pMealName;
    @ColumnInfo(name = "pRecipe")
    private String pRecipe;
    @ColumnInfo(name = "pInstructions")
    private String pInstructions;
    @ColumnInfo(name="pThum")
    private String pThum;
    @ColumnInfo(name = "pYouTube")
    private String pYouTube;
    @ColumnInfo(name = "day")
    private String day;
    @ColumnInfo(name = "type")
    private String type;

    public int getpMealId() {
        return pMealId;
    }

    public void setpMealId(int pMealId) {
        this.pMealId = pMealId;
    }

    public String getpMealName() {
        return pMealName;
    }

    public void setpMealName(String pMealName) {
        this.pMealName = pMealName;
    }

    public String getpRecipe() {
        return pRecipe;
    }

    public void setpRecipe(String pRecipe) {
        this.pRecipe = pRecipe;
    }

    public String getpInstructions() {
        return pInstructions;
    }

    public void setpInstructions(String pInstructions) {
        this.pInstructions = pInstructions;
    }

    public String getpThum() {
        return pThum;
    }

    public void setpThum(String pThum) {
        this.pThum = pThum;
    }

    public String getpYouTube() {
        return pYouTube;
    }

    public void setpYouTube(String pYouTube) {
        this.pYouTube = pYouTube;
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
