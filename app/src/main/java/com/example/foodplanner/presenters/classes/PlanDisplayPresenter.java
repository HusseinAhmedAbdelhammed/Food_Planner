package com.example.foodplanner.presenters.classes;

import android.content.Context;

import com.example.foodplanner.pojo.PlanModel;
import com.example.foodplanner.presenters.interfaces.PlanDisplayInterface;
import com.example.foodplanner.presenters.interfaces.PlanDisplayPresenterInterface;
import com.example.foodplanner.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class PlanDisplayPresenter implements PlanDisplayPresenterInterface {
    PlanDisplayInterface planDisplayInterface;
    Context context;
    ArrayList<PlanModel>sat=new ArrayList<>();
    ArrayList<PlanModel>sun=new ArrayList<>();
    ArrayList<PlanModel>mon=new ArrayList<>();
    ArrayList<PlanModel>tue=new ArrayList<>();
    ArrayList<PlanModel>wed=new ArrayList<>();
    ArrayList<PlanModel>thu=new ArrayList<>();
    ArrayList<PlanModel>fri=new ArrayList<>();
    public PlanDisplayPresenter(PlanDisplayInterface planDisplayInterface,Context context){
        this.planDisplayInterface=planDisplayInterface;
        this.context=context;
    }
    public void sendDay(String day){
        Repository.getInstance(context).getPlanByDay(day,this);
    }
    public void getDays(){
        Repository.getInstance(context).getPlans(this);
    }

    @Override
    public void getData(List<PlanModel> planModelList) {
        for(int i=0;i<planModelList.size();i++){
            if(planModelList.get(i).getDay().equals("Saturday")){
                sat.add(planModelList.get(i));
            }else if(planModelList.get(i).getDay().equals("Sunday")){
                sun.add(planModelList.get(i));
            }else if(planModelList.get(i).getDay().equals("Monday")){
                mon.add(planModelList.get(i));
            }else if(planModelList.get(i).getDay().equals("Tuesday")){
                tue.add(planModelList.get(i));
            }else if(planModelList.get(i).getDay().equals("Wednesday")){
                wed.add(planModelList.get(i));
            }else if(planModelList.get(i).getDay().equals("Thursday")){
                thu.add(planModelList.get(i));
            }else if(planModelList.get(i).getDay().equals("Friday")){
                fri.add(planModelList.get(i));
            }

        }
        planDisplayInterface.showSat(sat);
        planDisplayInterface.showSun(sun);
        planDisplayInterface.showMon(mon);
        planDisplayInterface.showTue(tue);
        planDisplayInterface.showThu(thu);
        planDisplayInterface.showFri(fri);
        planDisplayInterface.showWed(wed);
    }
}
