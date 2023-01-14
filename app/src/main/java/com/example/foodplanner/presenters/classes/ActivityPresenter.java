package com.example.foodplanner.presenters.classes;

import com.example.foodplanner.network.apiclint.APIClient;
import com.example.foodplanner.pojo.MealsList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ActivityPresenter {
    public void getRandomMeal(){
        Observable<MealsList> observable= APIClient.getInstance().getRandomMeal()
                .subscribeOn(Schedulers.io())//UpStream operation
                .observeOn(AndroidSchedulers.mainThread());//DownStream operation
        Observer<MealsList> observer =new Observer<MealsList>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull MealsList mealsList) {
                //call interface method or add the mealsList inside an arrayList
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);
    }
}
