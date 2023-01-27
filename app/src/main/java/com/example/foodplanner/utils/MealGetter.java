package com.example.foodplanner.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.View;

import com.example.foodplanner.R;
import com.example.foodplanner.network.apiclint.APIClient;
import com.example.foodplanner.pojo.Meals;
import com.example.foodplanner.pojo.MealsList;
import com.example.foodplanner.presenters.classes.CategoryDetailsPresenter;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MealGetter {
    static Meals meal;
    static ArrayList<Meals> mealList  = new ArrayList<>();
    private static final String TAG = "MealGetter";
    @SuppressLint("StaticFieldLeak")
    static CategoryDetailsPresenter presenter;

    public static void getMealByName(String MealName, View view, Context context){

        Single<MealsList>mealsListSingle= APIClient.getInstance().getMealByName(MealName).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        SingleObserver<MealsList>mealsListSingleObserver=new SingleObserver<MealsList>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                meal=new Meals();
            }

            @Override
            public void onSuccess(@NonNull MealsList mealsList) {
                meal=mealsList.getMeals().get(0);
                MealSender.sendMeal(view,context, meal);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        };
        mealsListSingle.subscribe(mealsListSingleObserver);
    }

    public static void getMealByCategory (String Category, View view, Context context){
        Single<MealsList>mealsListObservable = APIClient.getInstance().getMealByCategory(Category)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        SingleObserver<MealsList> mealsListSingleObserver = new SingleObserver<MealsList>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
//                mealList = new ArrayList<>();
                presenter = new CategoryDetailsPresenter(context);

            }

            @Override
            public void onSuccess(@NonNull MealsList mealsList) {
//                mealList= mealsList.getMeals();
                Log.i(TAG, "onSuccess: " + mealsList.getMeals().size());
                presenter.getMeal(mealsList.getMeals());
                NavigatorClass.navigateBetweenFragments(view, R.id.action_homeFragment_to_catFragment2);

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        };
        mealsListObservable.subscribe(mealsListSingleObserver);
    }
}
