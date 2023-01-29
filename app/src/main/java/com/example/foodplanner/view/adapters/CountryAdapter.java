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
import com.example.foodplanner.pojo.Country;
import com.example.foodplanner.pojo.Meals;
import com.example.foodplanner.pojo.MealsList;
import com.example.foodplanner.utils.ImageLoader;
import com.example.foodplanner.utils.MealGetter;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryViewHolder>{
    Context context;
    ArrayList<Country> mealList;
    public CountryAdapter(Context context, ArrayList<Country> mealList) {
        this.context = context;
        this.mealList = mealList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.ingredient_layout,parent,false);
        CountryViewHolder viewHolder=new CountryViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.countryName.setText(mealList.get(position).getCountryName());
        ImageLoader.loadCountryImage(context,mealList.get(position).getCountryCode(),
                holder.countryThum);
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MealGetter.getMealByCountry(mealList.get(position).getCountryName(), view, view.getContext());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }
}
