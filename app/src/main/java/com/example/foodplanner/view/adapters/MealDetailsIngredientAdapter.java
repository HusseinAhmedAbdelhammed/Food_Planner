package com.example.foodplanner.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.R;
import com.example.foodplanner.utils.Consts;
import com.example.foodplanner.utils.ImageLoader;

import java.util.ArrayList;

public class MealDetailsIngredientAdapter extends RecyclerView.Adapter<MealDetailsIngredientViewHolder>  {
    private final Context con;
    private ArrayList<String> ingredientNames;

    public MealDetailsIngredientAdapter(Context con, ArrayList<String> ingredientNames) {
        this.con = con;
        this.ingredientNames = ingredientNames;
    }

    @NonNull
    @Override
    public MealDetailsIngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.ingredient_layout,parent,false);
        MealDetailsIngredientViewHolder viewHolder=new MealDetailsIngredientViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MealDetailsIngredientViewHolder holder, int position) {
        holder.ingredientName.setText(ingredientNames.get(position));
        ImageLoader.loadIngImage(con, ingredientNames.get(position),holder.ingredientThum,
                Consts.SIZE_SMALL);
    }

    @Override
    public int getItemCount() {
        return ingredientNames.size();
    }
}
