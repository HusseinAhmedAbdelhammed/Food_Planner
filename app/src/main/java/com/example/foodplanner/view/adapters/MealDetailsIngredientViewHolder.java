package com.example.foodplanner.view.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.R;

public class MealDetailsIngredientViewHolder extends RecyclerView.ViewHolder {
    TextView ingredientName;
    ImageView ingredientThum;
    ConstraintLayout constraintLayout;
    View layout;
    public MealDetailsIngredientViewHolder(@NonNull View itemView) {
        super(itemView);
        layout=itemView;
        ingredientName=itemView.findViewById(R.id.ingredientName);
        ingredientThum=itemView.findViewById(R.id.ingredientThum);
        constraintLayout=itemView.findViewById(R.id.constLayoutIngredient);
    }
}
