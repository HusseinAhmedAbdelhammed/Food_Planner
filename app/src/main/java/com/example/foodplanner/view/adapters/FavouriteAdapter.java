package com.example.foodplanner.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.R;
import com.example.foodplanner.pojo.MealsTable;
import com.example.foodplanner.utils.ImageLoader;

import java.util.List;

public class FavouriteAdapter  extends RecyclerView.Adapter<FavouriteViewHolder>{
    Context context;
    List<MealsTable> mealList;

    public FavouriteAdapter(Context context, List<MealsTable> mealList) {
        this.context = context;
        this.mealList = mealList;
    }

    @NonNull
    @Override
    public FavouriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.cat_layout,parent,false);
        FavouriteViewHolder viewHolder=new FavouriteViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteViewHolder holder, int position) {
        holder.ingredientName.setText(mealList.get(position).getMealName());
        ImageLoader.loadImage(context,mealList.get(position).getThum(),holder.ingredientThum);
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }
}
