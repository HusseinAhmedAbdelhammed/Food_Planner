package com.example.foodplanner.view.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.pojo.MealsTable;
import com.example.foodplanner.presenters.classes.FavouritePresenter;
import com.example.foodplanner.presenters.interfaces.FavouriteInterface;
import com.example.foodplanner.view.adapters.FavouriteAdapter;

import java.util.ArrayList;
import java.util.List;

public class FavouriteFragment extends Fragment implements FavouriteInterface {
    RecyclerView favRecycler;
    FavouritePresenter favouritePresenter;
    Context context;
    FavouriteAdapter adapter;
    List<MealsTable> mealList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        favouritePresenter.allFavMeals();
        adapter = new FavouriteAdapter(context,mealList);
        Toast.makeText(context, "count " + adapter.getItemCount(), Toast.LENGTH_SHORT).show();
        favRecycler.setAdapter(adapter);
    }



    private void init(View view) {
        favRecycler = view.findViewById(R.id.favRecyclerView);
//        LinearLayoutManager manager=new LinearLayoutManager(getContext());
//        manager.setOrientation(RecyclerView.VERTICAL);
//        favRecycler.setLayoutManager(manager);
        favRecycler.setLayoutManager(new GridLayoutManager(context, 2));

        favouritePresenter = new FavouritePresenter(getContext(), this);
    }


    @Override
    public void showAllFavMeals(List<MealsTable> mealList) {
        this.mealList.clear();
        this.mealList.addAll(mealList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }
}