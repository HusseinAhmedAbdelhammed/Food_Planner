package com.example.foodplanner.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.foodplanner.pojo.MealsTable;
import com.example.foodplanner.pojo.PlanModel;
import com.example.foodplanner.repository.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataGetter {
    static ArrayList<MealsTable> receivedFav;
    static ArrayList<PlanModel> receivedPlan;


    public static void getFav(Context context,Map<String,Object>data){
        Toast.makeText(context, "hi from getFav", Toast.LENGTH_LONG).show();
        receivedFav=new ArrayList<>();
        Log.i("testtest", "getFav: ");
        for (int i=0;i< data.size();i++){
            Map<String,Object>objectMap=new HashMap<>();
            objectMap= (Map<String, Object>) data.get("meal"+i);
            receivedFav.add(new MealsTable(((Long)objectMap.get("id")).intValue(),objectMap.get("name").toString(),
                    objectMap.get("recipe").toString(),objectMap.get("instructions").toString(),
                    objectMap.get("thum").toString(),objectMap.get("youTube").toString()));
        }

        for (int i=0;i<receivedFav.size();i++){
            Log.i("testtest", "getFav: ");
            Repository.getInstance(context).insertFavorite(receivedFav.get(i));
        }

    }
    public static void getPlan(Context context,Map<String,Object>data){
        receivedPlan=new ArrayList<>();
        for (int i=0;i<data.size();i++){
            Map<String,Object>objectMap=new HashMap<>();
            objectMap= (Map<String, Object>) data.get("plan"+i);
            receivedPlan.add(new PlanModel());
            receivedPlan.get(i).setPlanID((Long) objectMap.get("planId"));
            receivedPlan.get(i).setMealName(objectMap.get("planMealName").toString());
            receivedPlan.get(i).setDay(objectMap.get("day").toString());
            receivedPlan.get(i).setType(objectMap.get("type").toString());
            receivedPlan.get(i).setMealThum(objectMap.get("planThum").toString());
        }
        for (int i=0;i<receivedPlan.size();i++){
            Repository.getInstance(context).insertPlan(receivedPlan.get(i));
            Toast.makeText(context, "data inserted", Toast.LENGTH_LONG).show();
        }
    }
}
