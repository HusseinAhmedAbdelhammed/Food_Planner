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
}
