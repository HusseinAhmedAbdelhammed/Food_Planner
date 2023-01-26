package com.example.foodplanner.presenters.classes;

import android.content.Context;

import com.example.foodplanner.pojo.MealsTable;
import com.example.foodplanner.presenters.interfaces.FavouriteInterface;
import com.example.foodplanner.presenters.interfaces.FavouritePresenterInterface;
import com.example.foodplanner.repository.Repository;
import com.example.foodplanner.view.fragment.FavouriteFragment;

import java.util.List;

public class FavouritePresenter implements FavouritePresenterInterface {

    FavouriteInterface favouriteInterface;
    Context con;

    public FavouritePresenter(Context context, FavouriteInterface favouriteInterface) {
        this.favouriteInterface = favouriteInterface;
        this.con = context;
    }

    @Override
    public void getAllFavMeals(List<MealsTable> mealList) {
        favouriteInterface.showAllFavMeals(mealList);
    }

    public void deleteMeal(MealsTable meal){
        Repository.getInstance(con, this).deleteFavorite(meal);
    }

    public void allFavMeals(){
        Repository.getInstance(con, this).getFavorite();
    }
}
