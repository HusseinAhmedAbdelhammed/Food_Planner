package com.example.foodplanner.network.apiclint;

import com.example.foodplanner.pojo.MealsList;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface APIClientInterface {
    @GET("random.php")
    public Observable<MealsList>getRandomMeal();
}
