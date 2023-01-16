package com.example.foodplanner.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.R;
import com.example.foodplanner.pojo.Category;
import com.example.foodplanner.utils.ImageLoader;

import java.util.ArrayList;

public class TestFragmentAdapter extends RecyclerView.Adapter<TestFragmentViewHolder> {
    private final Context con;
    private ArrayList<Category> categories;

    public TestFragmentAdapter(Context con, ArrayList<Category> categories) {
        this.con = con;
        this.categories = categories;
    }

    @NonNull
    @Override
    public TestFragmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.cat_layout,parent,false);
        TestFragmentViewHolder viewHolder=new TestFragmentViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestFragmentViewHolder holder, int position) {
        holder.catName.setText(categories.get(position).getStrCategory());
        ImageLoader.loadImage(con,categories.get(position).getStrCategoryThumb(),holder.catImg);

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
