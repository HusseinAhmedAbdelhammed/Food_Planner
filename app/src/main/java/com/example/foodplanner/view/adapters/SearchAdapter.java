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

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {
    private final Context con;
    private ArrayList<Meals> meals;

    public SearchAdapter(Context con,ArrayList<Meals> meals) {
        this.con = con;
        this.meals=meals;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.search_layout,parent,false);
        SearchViewHolder viewHolder=new SearchViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.searMeal.setText(meals.get(position).getStrMeal());
        ImageLoader.loadImage(con,meals.get(position).getStrMealThumb(),holder.searImg);
    }

    @Override
    public int getItemCount() {
       if(meals==null){
           return 0;
       }
       else return meals.size();
    }
}
