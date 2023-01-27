package com.example.foodplanner.view.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.R;
import com.example.foodplanner.pojo.Category;
import com.example.foodplanner.pojo.Meals;
import com.example.foodplanner.pojo.MealsTable;
import com.example.foodplanner.utils.ImageLoader;
import com.example.foodplanner.utils.MealGetter;

import java.util.ArrayList;
import java.util.List;

public class CategoryDetailsAdapter extends RecyclerView.Adapter<CategoryDetailsViewHolder> {
    private final Context con;
    private ArrayList<Category> categories;
    ArrayList<Meals> mealList;
    boolean check = true;
    private static final String TAG = "CategoryDetailsAdapter";

    public CategoryDetailsAdapter(Context con, ArrayList<Meals> mealList) {
        this.mealList = mealList;
//        Log.i(TAG, "CategoryDetailsAdapter: list "+ mealList.size());
        this.con = con;
        check = false;
        Log.i(TAG, "CategoryFragmentAdapter:  fav");
    }

    @NonNull
    @Override
    public CategoryDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder: ");
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.fav_layout,parent,false);
        CategoryDetailsViewHolder viewHolder=new CategoryDetailsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryDetailsViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.favName.setText(mealList.get(position).getStrMeal());
        ImageLoader.loadImage(con,mealList.get(position).getStrMealThumb(),holder.favImg);
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MealGetter.getMealByName(mealList.get(position).getStrMeal(), view, con);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }
}
