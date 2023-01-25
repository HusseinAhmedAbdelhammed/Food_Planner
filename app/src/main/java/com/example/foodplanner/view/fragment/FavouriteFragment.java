package com.example.foodplanner.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodplanner.R;
import com.example.foodplanner.pojo.MealsTable;
import com.example.foodplanner.presenters.classes.FavouritePresenter;
import com.example.foodplanner.presenters.interfaces.FavouriteInterface;
import com.example.foodplanner.view.adapters.FavouriteAdapter;

import java.util.List;

public class FavouriteFragment extends Fragment implements FavouriteInterface {
    RecyclerView favRecycler;
    FavouriteAdapter adapter;
    FavouritePresenter favouritePresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

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

    }

    private void init(View view) {
        favRecycler = view.findViewById(R.id.favRecyclerView);
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.VERTICAL);
        favouritePresenter = new FavouritePresenter(getContext(), this);
//        adapter = new FavouriteAdapter(getContext(), );
    }


    @Override
    public void showAllFavMeals(List<MealsTable> mealList) {
        adapter = new FavouriteAdapter(getContext(),mealList);

    }
}