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
    @ColumnInfo(name = "planMName")
    private String planMName;
    @ColumnInfo(name="planThum")
    private String planThum;

    @ColumnInfo(name = "day")
    private String day;
    @ColumnInfo(name = "type")
    private String type;


    public long getPlanId() {
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





    public String getPlanThum() {
        return planThum;
    }

    public void setPlanThum(String planThum) {
        this.planThum = planThum;
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
