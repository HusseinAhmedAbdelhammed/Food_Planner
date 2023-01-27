package com.example.foodplanner.view.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.R;

public class PlanDisplayViewHolder extends RecyclerView.ViewHolder {
    TextView planMealName,planMealType;
    ImageView planThum;
    ConstraintLayout planConst;
    View layout;
    public PlanDisplayViewHolder(@NonNull View itemView) {
        super(itemView);
        layout=itemView;
        planMealName=itemView.findViewById(R.id.planMealName);
        planMealType=itemView.findViewById(R.id.planMealType);
        planThum=itemView.findViewById(R.id.planThum);
        planConst=itemView.findViewById(R.id.planConst);
    }
}
