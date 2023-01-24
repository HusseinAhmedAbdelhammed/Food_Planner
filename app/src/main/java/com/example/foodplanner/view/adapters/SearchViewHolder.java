package com.example.foodplanner.view.adapters;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.foodplanner.R;


public class SearchViewHolder extends RecyclerView.ViewHolder {
    TextView searMeal;
    ImageView searImg;
    ConstraintLayout searConst;
    View layout;
    public SearchViewHolder(@NonNull View itemView) {
        super(itemView);
        layout=itemView;
        searMeal=itemView.findViewById(R.id.searMeal);
        searImg=itemView.findViewById(R.id.searImg);
        searConst=itemView.findViewById(R.id.searConst);
    }
}
