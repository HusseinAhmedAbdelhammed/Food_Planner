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
}
