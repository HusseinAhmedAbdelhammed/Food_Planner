package com.example.foodplanner.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.R;
import com.example.foodplanner.pojo.Meals;
import com.example.foodplanner.utils.ImageLoader;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {
    private final Context con;
    private ArrayList<Meals> meals;

    public HomeAdapter(Context con, ArrayList<Meals> meals) {
        this.con = con;
        this.meals = meals;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.random_layout,parent,false);
        HomeViewHolder viewHolder=new HomeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.mealName.setText(meals.get(position).getStrMeal());
        ImageLoader.loadImage(con,meals.get(position).getStrMealThumb(),holder.mealThum);
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }
}
