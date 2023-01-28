package com.example.foodplanner.network.apiclint;

import com.example.foodplanner.pojo.CategoriesList;
import com.example.foodplanner.pojo.MealsList;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIClientInterface {
    @GET("random.php")
    public Observable<MealsList>getRandomMeal();
    @GET("filter.php")
    public Single<MealsList>getMealByCountry(@Query("a") String countryName);
    @GET("filter.php")
    public Single<MealsList>getMealByCategory(@Query("c") String category);
    @GET("filter.php")
    public Single<MealsList>getMealByIngred(@Query("i") String ingred);
    @GET("search.php")
    public Single<MealsList> getMealByName(@Query("s") String name);
    @GET("categories.php")
    public Single<CategoriesList> getCategories();
    @GET("list.php")
    public Single<MealsList> getCountryList(@Query("a") String list);

}
