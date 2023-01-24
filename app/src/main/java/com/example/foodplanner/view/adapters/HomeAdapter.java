package com.example.foodplanner.view.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.foodplanner.R;
import com.example.foodplanner.pojo.Meals;
import com.example.foodplanner.utils.ImageLoader;
import com.example.foodplanner.utils.MealSender;
import com.example.foodplanner.view.activities.MealDetailsActivity;
import java.io.Serializable;
import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> implements Serializable{
    private final Context con;
    private ArrayList<Meals> meals;
    Meals  passedMeal;


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
    public void onBindViewHolder(@NonNull HomeViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.mealName.setText(meals.get(position).getStrMeal());
        ImageLoader.loadImage(con,meals.get(position).getStrMealThumb(),holder.mealThum);
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(con, meals.get(position).getStrMeal(),
                        Toast.LENGTH_SHORT).show();
                MealSender.sendMeal(view, con,meals.get(position) );
            }
        });
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public Meals getPassedMeal() {
        return passedMeal;
    }

    public void setPassedMeal(Meals passedMeal) {
        this.passedMeal = passedMeal;
    }
}
