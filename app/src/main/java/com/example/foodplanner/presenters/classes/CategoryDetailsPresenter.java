package com.example.foodplanner.presenters.classes;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.example.foodplanner.pojo.Meals;
import java.util.ArrayList;

public class CategoryDetailsPresenter {
    Context context;
   public static ArrayList<Meals> list;
    private static final String TAG = "CategoryDetailsPresente";

    public static ArrayList<Meals> getList() {
        return CategoryDetailsPresenter.list;
    }

    public static void setList(ArrayList<Meals> list) {
        CategoryDetailsPresenter.list = list;
        Log.i(TAG, "setList: " + list.size());
     }

    public CategoryDetailsPresenter(Context context) {
        this.context = context;
    }
    public void getMeal(ArrayList<Meals> list){
        setList(list);
        CategoryDetailsPresenter.list = list;

    }

}
