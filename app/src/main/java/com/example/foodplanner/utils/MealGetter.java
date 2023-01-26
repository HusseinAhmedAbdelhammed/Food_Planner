package com.example.foodplanner.utils;

import android.content.Context;
import android.view.View;

import com.example.foodplanner.network.apiclint.APIClient;
import com.example.foodplanner.pojo.Meals;
import com.example.foodplanner.pojo.MealsList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MealGetter {
    static Meals meal;

    public static void getMeal(String MealName, View view, Context context){

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
}
