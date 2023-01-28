package com.example.foodplanner.presenters.classes;

import android.util.Log;

import com.example.foodplanner.network.apiclint.APIClient;
import com.example.foodplanner.pojo.Country;
import com.example.foodplanner.pojo.Meals;
import com.example.foodplanner.pojo.MealsList;
import com.example.foodplanner.presenters.interfaces.HomeInterface;
import com.example.foodplanner.utils.Consts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HomePresenter {
    HomeInterface homeInterface;
    static int count;
    static ArrayList<String> countriesName;
    private static final String TAG = "HomePresenter";
   static ArrayList<Meals> countryList;
   ArrayList<Country> countries;



    public HomePresenter(HomeInterface homeInterface) {
        this.homeInterface = homeInterface;
        countryList = new ArrayList<>();
    }

    public void getRandomMeal() {
        ArrayList<Observable<MealsList>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(APIClient.getInstance().getRandomMeal());

        }
        Single<List<MealsList>> observable = Observable.fromIterable(list)
                .subscribeOn(Schedulers.io())//UpStream operation
                .flatMap(new Function<Observable<MealsList>, ObservableSource<? extends MealsList>>() {
                    @Override
                    public ObservableSource<? extends MealsList> apply(Observable<MealsList> mealsListObservable) throws Throwable {
                        return mealsListObservable;
                    }
                })
                .collect(new Supplier<List<MealsList>>() {
                    @Override
                    public List<MealsList> get() throws Throwable {
                        return new ArrayList<>();
                    }
                }, new BiConsumer<List<MealsList>, MealsList>() {
                    @Override
                    public void accept(List<MealsList> mealsLists, MealsList mealsList) throws Throwable {
                        mealsLists.add(mealsList);
                    }
                }).observeOn(AndroidSchedulers.mainThread());

        //.toList();//DownStream operation
//        Observer<MealsList> observer =new Observer<MealsList>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@NonNull MealsList mealsList) {
//
//                homeInterface.showRandomMeals(mealsList.getMeals(),count);
//
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };
        SingleObserver<List<MealsList>> singleMealObserver = new SingleObserver<List<MealsList>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull List<MealsList> mealsLists) {
                homeInterface.showRandomMeals(mealsLists);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        };
        observable.subscribe(singleMealObserver);
    }
    public ArrayList<Meals> getCounties(){
        Single<MealsList> observable = APIClient.getInstance().getCountries("list");
        Single<MealsList> single=observable.
                subscribeOn(Schedulers.io())
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
                homeInterface.getCountries(mealsList);
                Log.i(TAG, "onSuccess: " + countryList);

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i(Consts.TAG, e.getMessage());
            }
        };
        single.subscribe(singleObserver);
        return countryList;
    }

     ArrayList<String> fillCountriesCode() {
//        Log.i(TAG, "fillCountriesCode: " + countryList);
        return new ArrayList<>(Arrays.asList(
                "us","gb","ca","cn","hr","nl",
                "eg","fr","gr","in","ie","it",
                "jm","jp","kn","my", "mx","ma",
                "pl","pt","ru", "es","th","tn",
                "tr","zz", "vn"
        ));
    }

    public  void getCountriesWithFlags(MealsList mealsList){
        countries = new ArrayList<>();
        Log.i(TAG, "getCountriesWithFlags: " + mealsList.getMeals());
        Log.i(TAG, "getCountriesWithFlags: static" + mealsList.getMeals().size());
        Observable<Meals> observableNames = Observable.fromIterable(mealsList.getMeals());
//        Log.i(TAG, "getCountriesWithFlags: after" + countryList);
        Observable <String> observableAges = Observable.fromIterable(fillCountriesCode());
        Observable <Country> observableResult = Observable
                .zip(observableNames,observableAges,
                        (countryName,countryCode) ->
                                new Country(countryName.getStrArea(), countryCode) );
        observableResult
                .subscribe(country -> countries.add(country));
//        return countries;
        homeInterface.showCountries(countries);
    }

}
