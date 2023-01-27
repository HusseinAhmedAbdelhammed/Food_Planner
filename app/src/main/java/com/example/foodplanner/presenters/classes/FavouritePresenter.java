package com.example.foodplanner.presenters.classes;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.foodplanner.pojo.MealsList;
import com.example.foodplanner.pojo.MealsTable;
import com.example.foodplanner.presenters.interfaces.FavouriteInterface;
import com.example.foodplanner.presenters.interfaces.FavouritePresenterInterface;
import com.example.foodplanner.repository.Repository;
import com.example.foodplanner.view.fragment.FavouriteFragment;

import java.util.List;

public class FavouritePresenter implements FavouritePresenterInterface {

    FavouriteInterface favouriteInterface;
    Context con;
    public static List<MealsTable> list;
    private static final String TAG = "FavouritePresenter";

    public static void setList(List<MealsTable> list) {
        FavouritePresenter.list = list;
    }

    public FavouritePresenter(Context con) {
        this.con = con;
    }

    public FavouritePresenter(Context context, FavouriteInterface favouriteInterface) {
        this.favouriteInterface = favouriteInterface;
        this.con = context;
    }

    @Override
    public void getAllFavMeals(List<MealsTable> mealList) {
        Toast.makeText(con, "favPresenter", Toast.LENGTH_SHORT).show();
//        FavouritePresenter.list = mealList;
        setList(mealList);
        favouriteInterface.showAllFavMeals(FavouritePresenter.list);
        Log.i(TAG, "getAllFavMeals: "+"*****" + FavouritePresenter.list);
    }

    public void deleteMeal(MealsTable meal){
        Repository.getInstance(con).deleteFavorite(meal);
    }

    public void allFavMeals(){

        Repository.getInstance(con).getFavorite(this);

    }
}
