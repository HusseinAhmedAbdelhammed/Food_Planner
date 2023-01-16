package com.example.foodplanner.presenters.classes;

import android.util.Log;

import com.example.foodplanner.network.apiclint.APIClient;
import com.example.foodplanner.pojo.CategoriesList;
import com.example.foodplanner.presenters.interfaces.TestFragmentInterface;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TestFragmentPresenter {
    TestFragmentInterface testFragmentInterface;
    APIClient client;
    public TestFragmentPresenter(TestFragmentInterface fInterface){
        testFragmentInterface=fInterface;
        client=APIClient.getInstance();
    }
    public void getCateg(){
        Observable<CategoriesList>catOps=client.getCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        Observer<CategoriesList>observer=new Observer<CategoriesList>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull CategoriesList categoriesList) {
                testFragmentInterface.showCategories(categoriesList);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i("SONIC", e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        catOps.subscribe(observer);

    }
}
