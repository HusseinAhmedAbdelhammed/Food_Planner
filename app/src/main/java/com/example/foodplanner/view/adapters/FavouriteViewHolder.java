package com.example.foodplanner.view.adapters;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.foodplanner.R;

public class FavouriteViewHolder extends RecyclerView.ViewHolder {
    public TextView favName;
    public ImageView favImg;
    public FrameLayout frameLayout;
    Button remove;
    public View layout;
    public FavouriteViewHolder(@NonNull View itemView) {
        super(itemView);
        layout=itemView;
        favName=itemView.findViewById(R.id.favName);
        favImg=itemView.findViewById(R.id.favThum);
        remove = itemView.findViewById(R.id.removeFromFav);
        frameLayout=itemView.findViewById(R.id.constLayout);
    }
}
