package com.example.foodplanner.presenters.classes;

import android.util.Log;

import com.example.foodplanner.network.apiclint.APIClient;
import com.example.foodplanner.pojo.CategoriesList;
import com.example.foodplanner.presenters.interfaces.HomeInterface;
import com.example.foodplanner.presenters.interfaces.TestFragmentInterface;
import com.example.foodplanner.view.fragment.HomeFragment;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TestFragmentPresenter {
    TestFragmentInterface testFragmentInterface;
    HomeInterface homeInterface;
    APIClient client;
    private static final String TAG = "SONIC";
    public TestFragmentPresenter(TestFragmentInterface fInterface){
        Log.i(TAG,"hello");
        testFragmentInterface=fInterface;
        client=APIClient.getInstance();
    }
    public TestFragmentPresenter(HomeInterface homeInterface){
        Log.i(TAG,"hello");
        this.homeInterface=homeInterface;
        client=APIClient.getInstance();
    }
    public void getCateg(){
        Log.i(TAG,"HI");
        Observable<CategoriesList>catOps=client.getCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        Observer<CategoriesList>observer=new Observer<CategoriesList>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.i(TAG, "NOT AM ERROR");

            }

            @Override
            public void onNext(@NonNull CategoriesList categoriesList) {
                homeInterface.showCateg(categoriesList);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i(TAG, e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        catOps.subscribe(observer);

    }
}
