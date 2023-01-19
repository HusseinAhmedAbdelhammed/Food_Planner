package com.example.foodplanner.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodplanner.R;
import com.example.foodplanner.pojo.CategoriesList;
import com.example.foodplanner.pojo.Meals;
import com.example.foodplanner.pojo.MealsList;
import com.example.foodplanner.presenters.classes.HomePresenter;
import com.example.foodplanner.presenters.classes.TestFragmentPresenter;
import com.example.foodplanner.presenters.interfaces.HomeInterface;
import com.example.foodplanner.view.adapters.HomeAdapter;
import com.example.foodplanner.view.adapters.TestFragmentAdapter;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements HomeInterface {
RecyclerView recHome;
HomePresenter homePresenter;
HomeAdapter adapter;
ArrayList<Meals>meals;
TestFragmentAdapter testAdapter;
TestFragmentPresenter testPresenter;
RecyclerView catRec;

    public HomeFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        homePresenter.getRandomMeal();
        testPresenter.getCateg();
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        LinearLayoutManager manager1=new LinearLayoutManager(getContext());
        manager1.setOrientation(RecyclerView.HORIZONTAL);
        manager.setOrientation(RecyclerView.VERTICAL);
        recHome.setLayoutManager(manager);
        catRec.setLayoutManager(manager1);
    }
    public void init(View view){
        recHome=view.findViewById(R.id.recHome);
        homePresenter=new HomePresenter(this);
        meals=new ArrayList<>();
        testPresenter=new TestFragmentPresenter(this);
        catRec=view.findViewById(R.id.catRec);
    }

    @Override
    public void showRandomMeals(List<MealsList> mealsArrayList) {
        for (int i = 0; i < mealsArrayList.size(); i++) {
            meals.add(mealsArrayList.get(i).getMeals().get(0));
        }
        Log.i("TAG", "showRandomMeals: "+meals.size());
        adapter=new HomeAdapter(getContext(),meals);
        recHome.setAdapter(adapter);

    }

    @Override
    public void showCateg(CategoriesList categoriesList) {
        testAdapter=new TestFragmentAdapter(getContext(),categoriesList.getCategories());
        catRec.setAdapter(testAdapter);
    }
}