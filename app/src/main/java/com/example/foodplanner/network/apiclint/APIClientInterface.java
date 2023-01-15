package com.example.foodplanner.network.apiclint;

import com.example.foodplanner.pojo.CategoriesList;
import com.example.foodplanner.pojo.MealsList;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIClientInterface {
    @GET("random.php")
    public Observable<MealsList>getRandomMeal();
    @GET("filter.php")
    public Observable<MealsList>getMealByCountry(@Query("a") String countryName);
    @GET("filter.php")
    public Observable<MealsList>getMealByCategory(@Query("c") String category);
    @GET("filter.php")
    public Observable<MealsList>getMealByIngred(@Query("i") String ingred);
    @GET("search.php")
    public Observable<MealsList>getMealByName(@Query("s") String name);
    @GET("categories.php")
    public Observable<CategoriesList>getCategories();
}
