package com.example.foodplanner.repository;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.foodplanner.database.favorite.MealDAO;
import com.example.foodplanner.database.instance.RoomInstance;
import com.example.foodplanner.database.plan.PlanDAO;
import com.example.foodplanner.network.firebase.FireStore;
import com.example.foodplanner.pojo.MealsTable;
import com.example.foodplanner.pojo.PlanModel;
import com.example.foodplanner.presenters.interfaces.FavouriteInterface;
import com.example.foodplanner.presenters.interfaces.FavouritePresenterInterface;
import com.example.foodplanner.presenters.interfaces.PlanDisplayPresenterInterface;
import com.example.foodplanner.utils.Consts;
import com.example.foodplanner.utils.FireStoreData;
import com.example.foodplanner.view.adapters.CategoryFragmentAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

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

    public void getPlanByDay(String day, PlanDisplayPresenterInterface presenterInterface){
        Single<List<PlanModel>> planByDay=planDAO.getPlan(day)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        SingleObserver<List<PlanModel>> planByDayObserver=new SingleObserver<List<PlanModel>>() {
            @Override
            public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<PlanModel> planModelList) {
//                if(planModelList.get(0).getDay()==null){
//                    Toast.makeText(con,"jjjj",Toast.LENGTH_LONG).show();
//
//                }
                presenterInterface.getData(planModelList);
            }

            @Override
            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                Toast.makeText(con,"planModelList.get(0).getMealName()",Toast.LENGTH_LONG).show();
            }
        };
        planByDay.subscribe(planByDayObserver);
    }
    public void getPlans( PlanDisplayPresenterInterface presenterInterface){
        Single<List<PlanModel>>getPlans=planDAO.getAllPlans()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        SingleObserver<List<PlanModel>> plansObserver=new SingleObserver<List<PlanModel>>() {
            @Override
            public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<PlanModel> planModels) {
                presenterInterface.getData(planModels);
            }

            @Override
            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

            }
        };
        getPlans.subscribe(plansObserver);
    }
    public void insertPlan(PlanModel planModel){
        Completable insertPlanObservable=planDAO.insertMeal(planModel)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        CompletableObserver insertObserver=new CompletableObserver() {
            @Override
            public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

            }

            @Override
            public void onComplete() {
                Toast.makeText(con,"plan inserted",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

            }
        };
        insertPlanObservable.subscribe(insertObserver);
    }
    public void deletePlan(PlanModel planModel){
        Completable deletePlan= planDAO.deleteMeal(planModel)
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread());
        CompletableObserver deleteObserver=new CompletableObserver() {
            @Override
            public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

            }

            @Override
            public void onComplete() {
                Toast.makeText(con,"plan deleted",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

            }
        };
        deletePlan.subscribe(deleteObserver);
    }
    //Single<List<MealsTable>>


    public void getFavorite(FavouritePresenterInterface favouritePresenterInterface2) {
        Single<List<MealsTable>> favouriteList = mealDAO.getAllMeals().subscribeOn(Schedulers.io())

                .observeOn(AndroidSchedulers.mainThread());
        SingleObserver<List<MealsTable>> favouriteObserver = new SingleObserver<List<MealsTable>>() {
            @Override
            public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<MealsTable> mealsTables) {


                favouritePresenterInterface2.getAllFavMeals(mealsTables);
                Toast.makeText(con,mealsTables.get(0).getMealName(),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

            }
        };
        favouriteList.subscribe(favouriteObserver);
    }

    public void insertFavorite(MealsTable mealsTable) {
        Completable insertObservable = mealDAO.insertMeal(mealsTable).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        CompletableObserver insertObserver = new CompletableObserver() {
            @Override
            public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

            }

            @Override
            public void onComplete() {
                Toast.makeText(con, "inset successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

            }
        };
        insertObservable.subscribe(insertObserver);

    }

    public void deleteFavorite(MealsTable mealsTable) {
        Completable deleteObsevable = mealDAO.deleteMeal(mealsTable).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        CompletableObserver deleteObserver = new CompletableObserver() {
            @Override
            public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {
            }

            @Override
            public void onComplete() {
                Toast.makeText(con, "deleted successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

            }
        };
        deleteObsevable.subscribe(deleteObserver);
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
