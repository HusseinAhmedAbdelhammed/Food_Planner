package com.example.foodplanner.view.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.R;

public class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView countryName;
        ImageView countryThum;
        ConstraintLayout constraintLayout;
        View layout;
        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            layout=itemView;
            countryName=itemView.findViewById(R.id.mealName);
            countryThum=itemView.findViewById(R.id.mealThum);
            constraintLayout=itemView.findViewById(R.id.constLay);
        }
}
