package com.example.foodplanner.presenters.classes;

import android.content.Context;

import com.example.foodplanner.pojo.MealsTable;
import com.example.foodplanner.presenters.interfaces.FavouritePresenterInterface;
import com.example.foodplanner.repository.Repository;
import com.example.foodplanner.view.fragment.FavouriteFragment;

import java.util.List;

public class FavouritePresenter implements FavouritePresenterInterface {

    FavouriteFragment favouriteFragment;
    Context con;

    public FavouritePresenter(Context context, FavouriteFragment favouriteFragment) {
        this.favouriteFragment = favouriteFragment;
        this.con = context;
    }

    @Override
    public void getAllFavMeals(List<MealsTable> mealList) {
        favouriteFragment.showAllFavMeals(mealList);
    }

    public void deleteMeal(MealsTable meal){
        Repository.getInstance(con, this).deleteFavorite(meal);
    }

    public void allFavMeals(){
        Repository.getInstance(con, this).getFavorite();
    }
}
