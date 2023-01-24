package com.example.foodplanner.pojo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "meals")
public class MealsTable {
    @PrimaryKey
    @ColumnInfo(name = "mealId")
    @NonNull
    private int mealId;
    @ColumnInfo(name = "mealName")
    private String mealName;
    @ColumnInfo(name = "recipe")
    private String recipe;
    @ColumnInfo(name = "instructions")
    private String instructions;
    @ColumnInfo(name="thum")
    private String thum;

    @ColumnInfo(name = "youTube")
    private String youTube;



    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getThum() {
        return thum;
    }

    public void setThum(String thum) {
        this.thum = thum;
    }

    public String getYouTube() {
        return youTube;
    }

    public void setYouTube(String youTube) {
        this.youTube = youTube;
    }

}
