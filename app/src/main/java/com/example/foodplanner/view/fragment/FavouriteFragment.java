package com.example.foodplanner.view.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.pojo.MealsTable;
import com.example.foodplanner.presenters.classes.FavouritePresenter;
import com.example.foodplanner.presenters.interfaces.FavouriteInterface;
import com.example.foodplanner.utils.Consts;
import com.example.foodplanner.utils.DataSaver;
import com.example.foodplanner.utils.NavigatorClass;
import com.example.foodplanner.view.activities.MainActivity;
import com.example.foodplanner.view.adapters.FavouriteAdapter;

import java.util.ArrayList;
import java.util.List;

public class FavouriteFragment extends Fragment implements FavouriteInterface {
    RecyclerView favRecycler;
    FavouritePresenter favouritePresenter;
    Context context;
    FavouriteAdapter adapter;
    List<MealsTable> mealList ;
    TextView guestText, guestLogin;
    private static final String TAG = "FavouriteFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourit, container, false);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        if(DataSaver.getGuest().equals(Consts.GUEST)){
            favRecycler.setVisibility(View.GONE);
            guestText.setVisibility(View.VISIBLE);
            guestLogin.setVisibility(View.VISIBLE);
            guestLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NavigatorClass.navigateBetweenActivities(getContext(), NavigatorClass.MAIN);

                }
            });
        }else{
            favouritePresenter.allFavMeals();
            mealList = FavouritePresenter.list;
            Log.i(TAG, "onViewCreated: " + mealList + FavouritePresenter.list);
            if(mealList!=null){
                Log.i(TAG, "onViewCreated: notNull");
                adapter = new FavouriteAdapter(context, mealList);
                adapter.notifyDataSetChanged();
                favRecycler.setAdapter(adapter);
            }
        }

    }



    private void init(View view) {
        favRecycler = view.findViewById(R.id.favRecyclerView);
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.VERTICAL);
        favRecycler.setLayoutManager(manager);
//        favRecycler.setLayoutManager(new GridLayoutManager(context, 2));

        favouritePresenter = new FavouritePresenter(getContext(), this);
        guestText = view.findViewById(R.id.guestTV);
        guestLogin = view.findViewById(R.id.guestLogin);
    }


    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void showAllFavMeals(List<MealsTable> mealList) {
        Log.i(TAG, "showAllFavMeals: " + mealList);
        if(mealList!=null){
            adapter = new FavouriteAdapter(context, mealList);
            adapter.notifyDataSetChanged();
            favRecycler.setAdapter(adapter);
        }

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }
}