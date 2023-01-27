package com.example.foodplanner.presenters.interfaces;

import com.example.foodplanner.pojo.PlanModel;

import java.util.List;

public interface PlanDisplayInterface {
    void showSat(List<PlanModel> satlist);
    void showSun(List<PlanModel> sunlist);
    void showMon(List<PlanModel> monlist);
    void showTue(List<PlanModel> tuelist);
    void showWed(List<PlanModel> wedlist);
    void showThu(List<PlanModel> thulist);
    void showFri(List<PlanModel> frilist);
}
