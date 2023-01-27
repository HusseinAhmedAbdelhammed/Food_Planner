package com.example.foodplanner.view.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodplanner.R;
import com.example.foodplanner.pojo.Meals;
import com.example.foodplanner.presenters.classes.CategoryDetailsPresenter;
import com.example.foodplanner.view.adapters.CategoryDetailsAdapter;
import java.util.ArrayList;


public class
CatFragment extends Fragment{
RecyclerView rec;
CategoryDetailsAdapter adapter;
ArrayList<Meals> meals;

    private static final String TAG = "CatFragment";

    public CatFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        Log.i("SONIC", "onCreate: ");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    public void init(View view){
        rec = view.findViewById(R.id.catDetailsRecycler);
        rec.setLayoutManager(new GridLayoutManager(getContext(), 2));
        meals = CategoryDetailsPresenter.list;
        adapter = new CategoryDetailsAdapter(getContext(), meals);
        rec.setAdapter(adapter);
    }

}