package com.example.foodplanner.view.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.R;
import com.example.foodplanner.pojo.Meals;
import com.example.foodplanner.pojo.MealsList;
import com.example.foodplanner.presenters.classes.SearchFragmentPresenter;
import com.example.foodplanner.presenters.interfaces.SearchFragmentInterface;
import com.example.foodplanner.utils.ImageLoader;
import com.example.foodplanner.utils.MealGetter;
import com.example.foodplanner.utils.MealSender;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder>{
    private final Context con;
    private ArrayList<Meals> meals;
    SearchFragmentPresenter presenter;


    public SearchAdapter(Context con,ArrayList<Meals> meals) {
        this.con = con;
        this.meals=meals;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.search_layout,parent,false);
        SearchViewHolder viewHolder=new SearchViewHolder(view);
        presenter=new SearchFragmentPresenter(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.searMeal.setText(meals.get(position).getStrMeal());
        ImageLoader.loadImage(con,meals.get(position).getStrMealThumb(),holder.searImg);
        holder.searConst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(con, "name " + meals.get(position).getStrMeal(), Toast.LENGTH_SHORT).show();
                Toast.makeText(con, "cat " +meals.get(position).getStrCategory(),Toast.LENGTH_SHORT).show();
                MealGetter.getMeal(meals.get(position).getStrMeal(), view, con);
            //                MealSender.sendMeal(view, con, MealGetter.getMeal(meals.get(position).getStrMeal()));
            }
        });
    }

    @Override
    public int getItemCount() {
       if(meals==null){
           return 0;
       }
       else return meals.size();
    }


}
