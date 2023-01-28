package com.example.foodplanner.view.adapters;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.R;

public class HomeViewHolder extends RecyclerView.ViewHolder {
    TextView mealName;
    ImageView mealThum;
    ConstraintLayout constraintLayout;
    View layout;
    public HomeViewHolder(@NonNull View itemView) {
        super(itemView);
        layout=itemView;
        mealName=itemView.findViewById(R.id.mealName);
        mealThum=itemView.findViewById(R.id.mealThum);
        constraintLayout=itemView.findViewById(R.id.constLay);
    }
}
