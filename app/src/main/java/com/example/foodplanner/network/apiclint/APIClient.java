package com.example.foodplanner.network.apiclint;

import com.example.foodplanner.pojo.CategoriesList;
import com.example.foodplanner.pojo.MealsList;
import com.example.foodplanner.utils.Consts;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static APIClient instance;
    private APIClientInterface apiClientInterface;
    private APIClient(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(Consts.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        apiClientInterface=retrofit.create(APIClientInterface.class);
    }
    public static APIClient getInstance(){
        if(instance==null){
            instance=new APIClient();
        }
        return instance;
    }
    public Observable<MealsList> getRandomMeal(){
        return apiClientInterface.getRandomMeal();
    }
    public Observable<MealsList>getMealByName(String name){return apiClientInterface.getMealByName(name);}
    public Observable<MealsList>getMealByCountry(String country){return apiClientInterface.getMealByCountry(country);}
    public Observable<MealsList>getMealByCategory(String category){return apiClientInterface.getMealByCategory(category);}
    public Observable<MealsList>getMealByIngred(String ingred){return apiClientInterface.getMealByIngred(ingred);}
    public Single<CategoriesList> getCategories(){return apiClientInterface.getCategories();}
}
