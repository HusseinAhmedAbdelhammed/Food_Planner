package com.example.foodplanner.repository;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.foodplanner.database.favorite.MealDAO;
import com.example.foodplanner.database.instance.RoomInstance;
import com.example.foodplanner.database.plan.PlanDAO;
import com.example.foodplanner.network.firebase.FireStore;
import com.example.foodplanner.pojo.MealsTable;
import com.example.foodplanner.pojo.PlanModel;
import com.example.foodplanner.utils.Consts;
import com.example.foodplanner.utils.FireStoreData;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

public class Repository {
    private Context con;
    private static Repository instance;
    private RoomInstance dataBaseInstance;
    private PlanDAO planDAO;
    private MealDAO mealDAO;
    private FireStore fireStoredb;
    private Repository(Context con){
        this.con=con;
        dataBaseInstance=RoomInstance.getInstance(con);
        planDAO= dataBaseInstance.planDAO();
        mealDAO= dataBaseInstance.mealDAO();
    }
public static Repository getInstance(Context con){
        if(instance==null){
            instance=new Repository(con);
        }
        return instance;
    }
    public Single<List<PlanModel>> getPlans(){
        return planDAO.getAllPlans();
    }
    public Completable insertPlan(PlanModel planModel){
        return planDAO.insertMeal(planModel);
    }
    public Completable deletePlan(PlanModel planModel){
        return planDAO.deleteMeal(planModel);
    }
    public Single<List<MealsTable>>getFavorite(){
        return mealDAO.getAllMeals();
    }
    public Completable insertFavorite(MealsTable mealsTable){
        return mealDAO.insertMeal(mealsTable);
    }
    public Completable deleteFavorite(MealsTable mealsTable){
        return mealDAO.deleteMeal(mealsTable);
    }
    public void backup(ArrayList<Integer> favIDs,ArrayList<String> plans){
        fireStoredb=FireStore.getInstance();
        Map<String,Object> data=new HashMap<>();
        data.put("favIDs",favIDs);
        data.put("plans",plans);
        fireStoredb.getDb().collection(Consts.COLLECTION)
                .document(FireStoreData.getMail())
                .set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Log.i(Consts.TAG, "onSuccess: ");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i(Consts.TAG, "onFailure: "+e.getMessage());
                    }
                });
    }

}
