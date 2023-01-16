package com.example.foodplanner.view.adapters;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.R;

public class TestFragmentViewHolder extends RecyclerView.ViewHolder {
    public TextView catName;
    public ImageView catImg;
    public ConstraintLayout constraintLayout;
    public View layout;
    public TestFragmentViewHolder(@NonNull View itemView) {
        super(itemView);
        layout=itemView;
        catName=itemView.findViewById(R.id.catName);
        catImg=itemView.findViewById(R.id.catThum);
        constraintLayout=itemView.findViewById(R.id.constLayout);
    }
}
