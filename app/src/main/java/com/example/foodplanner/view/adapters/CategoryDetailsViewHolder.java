package com.example.foodplanner.view.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.R;

public class CategoryDetailsViewHolder extends RecyclerView.ViewHolder {
    public TextView favName;
    public ImageView favImg;
    public ConstraintLayout constraintLayout;
    public View layout;
    public CategoryDetailsViewHolder(@NonNull View itemView) {
        super(itemView);
        layout=itemView;
        favName=itemView.findViewById(R.id.favName);
        favImg=itemView.findViewById(R.id.favThum);
        constraintLayout=itemView.findViewById(R.id.constLayout);
    }
}
