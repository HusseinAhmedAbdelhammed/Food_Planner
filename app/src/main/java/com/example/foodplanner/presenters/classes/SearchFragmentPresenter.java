package com.example.foodplanner.presenters.classes;

import android.util.Log;

import com.example.foodplanner.network.apiclint.APIClient;
import com.example.foodplanner.pojo.MealsList;
import com.example.foodplanner.presenters.interfaces.SearchFragmentInterface;
import com.example.foodplanner.utils.Consts;
import com.example.foodplanner.view.adapters.SearchAdapter;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SearchFragmentPresenter {
    SearchFragmentInterface searchFragmentInterface;
    SearchAdapter searchAdapter;

    public SearchFragmentPresenter(SearchAdapter searchAdapter) {
        this.searchAdapter = searchAdapter;
    }

    public SearchFragmentPresenter(SearchFragmentInterface searchFragmentInterface){
        this.searchFragmentInterface=searchFragmentInterface;
    }
    public void getSearchResults(String target,String search){
        switch (target){
            case Consts.CAT_TARGET:
                observe(APIClient.getInstance().getMealByCategory(search));
                break;
            case Consts.AREA_TARGET:
                observe(APIClient.getInstance().getMealByCountry(search));
                break;
            case Consts.ING_TARGET:
                observe(APIClient.getInstance().getMealByIngred(search));
                break;
            default:
                observe(APIClient.getInstance().getMealByName(search));
        }
    }
    public void observe(Single<MealsList> observable){
        Single<MealsList>single=observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        SingleObserver<MealsList>singleObserver=new SingleObserver<MealsList>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull MealsList mealsList) {
                Log.i(Consts.TAG, "onSuccess: list" + mealsList);
                if(mealsList.getMeals() != null) {
                    Log.i(Consts.TAG, "onSuccess:cat  " + mealsList.getMeals().get(0).getStrCategory());
                }
                searchFragmentInterface.showResult(mealsList);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i(Consts.TAG, e.getMessage());
            }
        };
        single.subscribe(singleObserver);
    }
}
