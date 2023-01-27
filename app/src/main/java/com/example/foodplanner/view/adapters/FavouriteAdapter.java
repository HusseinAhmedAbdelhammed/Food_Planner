package com.example.foodplanner.view.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.R;
import com.example.foodplanner.pojo.MealsTable;
import com.example.foodplanner.presenters.classes.FavouritePresenter;
import com.example.foodplanner.utils.ImageLoader;
import com.example.foodplanner.utils.MealGetter;
import com.example.foodplanner.utils.MealSender;

import java.util.List;

public class FavouriteAdapter  extends RecyclerView.Adapter<FavouriteViewHolder>{
    List<MealsTable> mealList;
    private Context con;
    private static final String TAG = "FavouriteAdapter";
    FavouritePresenter favouritePresenter;

    public FavouriteAdapter(Context con, List<MealsTable> mealList) {
        Log.i(TAG, "FavouriteAdapter: ");
        this.mealList = mealList;
        this.con = con;
    }

    @NonNull
    @Override
    public FavouriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder: ");
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.fav_layout,parent,false);
        FavouriteViewHolder viewHolder=new FavouriteViewHolder(view);
        favouritePresenter = new FavouritePresenter(con);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Log.i(TAG, "onBindViewHolder: ");
        holder.favName.setText(mealList.get(position).getMealName());
        ImageLoader.readImgFromRoom(mealList.get(position).getThum(),holder.favImg);
        holder.frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MealGetter.getMealByName(mealList.get(position).getMealName(), view, con);
            }
        });
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                favouritePresenter.deleteMeal(mealList.get(position));
                FavouritePresenter.list.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }
}
