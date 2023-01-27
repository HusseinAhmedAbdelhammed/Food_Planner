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
import com.example.foodplanner.pojo.Category;
import com.example.foodplanner.pojo.MealsTable;
import com.example.foodplanner.utils.ImageLoader;
import com.example.foodplanner.utils.MealGetter;
import com.example.foodplanner.utils.NavigatorClass;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragmentAdapter extends RecyclerView.Adapter<CategoryFragmentViewHolder> {
    private final Context con;
    private ArrayList<Category> categories;
    List<MealsTable> mealList;
    boolean check = true;
    private static final String TAG = "CategoryFragmentAdapter";

    public CategoryFragmentAdapter(Context con, ArrayList<Category> categories) {
        this.con = con;
        this.categories = categories;
        check = true;
        Log.i(TAG, "CategoryFragmentAdapter: cat");
    }
    public CategoryFragmentAdapter(Context con, List<MealsTable> mealList) {
        this.mealList = mealList;
        this.con = con;
        check = false;
        Log.i(TAG, "CategoryFragmentAdapter:  fav");
    }

    @NonNull
    @Override
    public CategoryFragmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder: ");
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.cat_layout,parent,false);
        CategoryFragmentViewHolder viewHolder=new CategoryFragmentViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryFragmentViewHolder holder, @SuppressLint("RecyclerView") int position) {
            Log.i(TAG, "onBindViewHolder: cat");
            holder.catName.setText(categories.get(position).getStrCategory());
            ImageLoader.loadImage(con,categories.get(position).getStrCategoryThumb(),holder.catImg);
            holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MealGetter.getMealByCategory(categories.get(position).getStrCategory(),
                            view, view.getContext());
//                    NavigatorClass.navigateBetweenFragments(view, R.id.action_homeFragment_to_catFragment2);

                }
            });

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
