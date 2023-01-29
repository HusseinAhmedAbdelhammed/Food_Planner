package com.example.foodplanner.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.R;
import com.example.foodplanner.pojo.PlanModel;
import com.example.foodplanner.utils.ImageLoader;
import com.example.foodplanner.utils.MealGetter;

import java.util.List;

public class PlanDisplayAdapter extends RecyclerView.Adapter<PlanDisplayViewHolder> {
    private final Context context;
    private List<PlanModel>planList;
    public PlanDisplayAdapter(Context context,List<PlanModel>planList) {
        this.context = context;
        this.planList=planList;
    }

    @NonNull
    @Override
    public PlanDisplayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.plan_layout,parent,false);
        PlanDisplayViewHolder viewHolder=new PlanDisplayViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull PlanDisplayViewHolder holder, int position) {
        holder.planMealName.setText(planList.get(position).getMealName());
        holder.planMealType.setText(planList.get(position).getType());
        ImageLoader.readImgFromRoom(planList.get(position).getMealThum(),holder.planThum);
        holder.planConst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MealGetter.getMealByName(planList.get(position).getMealName(), view, context);
            }
        });
    }

    @Override
    public int getItemCount() {
        return planList.size();
    }
}
