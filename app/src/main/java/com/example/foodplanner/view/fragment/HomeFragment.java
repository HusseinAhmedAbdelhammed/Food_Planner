package com.example.foodplanner.view.fragment;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.pojo.CategoriesList;
import com.example.foodplanner.pojo.Country;
import com.example.foodplanner.pojo.Meals;
import com.example.foodplanner.pojo.MealsList;
import com.example.foodplanner.presenters.classes.HomePresenter;
import com.example.foodplanner.presenters.classes.TestFragmentPresenter;
import com.example.foodplanner.presenters.interfaces.HomeInterface;
import com.example.foodplanner.utils.DataSaver;
import com.example.foodplanner.utils.InternetConnectionChangeListener;
import com.example.foodplanner.view.adapters.CategoryDetailsAdapter;
import com.example.foodplanner.view.adapters.CountryAdapter;
import com.example.foodplanner.view.adapters.HomeAdapter;
import com.example.foodplanner.view.adapters.CategoryFragmentAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomeFragment extends Fragment implements HomeInterface {
RecyclerView recHome, catHome, countryRecycler;
HomePresenter homePresenter;
HomeAdapter adapter;
ArrayList<Meals>meals;
CategoryFragmentAdapter catAdapter;
TestFragmentPresenter testFragmentPresenter;
CountryAdapter countryAdapter;
InternetConnectionChangeListener internetConnectionChangeListener;
    private static final String TAG = "HomeFragment";


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
        homePresenter.getCounties();
        testFragmentPresenter.getCateg();
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        LinearLayoutManager manager1=new LinearLayoutManager(getContext());
        manager1.setOrientation(RecyclerView.HORIZONTAL);
        recHome.setLayoutManager(manager);
        catHome.setLayoutManager(manager1);
        LinearLayoutManager manager2=new LinearLayoutManager(getContext());
        manager2.setOrientation(RecyclerView.HORIZONTAL);
        countryRecycler.setLayoutManager(manager2);

    }
    public void init(View view){
        recHome=view.findViewById(R.id.recHome);
        catHome = view.findViewById(R.id.catRec);
        testFragmentPresenter =new TestFragmentPresenter(this);
        homePresenter=new HomePresenter(this);
        meals=new ArrayList<>();
        testFragmentPresenter=new TestFragmentPresenter(this);
        countryRecycler = view.findViewById(R.id.countryRecycler);
        internetConnectionChangeListener = new InternetConnectionChangeListener();
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

    public void showCats(CategoriesList categoriesList) {
        catAdapter = new CategoryFragmentAdapter(getContext(), categoriesList.getCategories());
        catHome.setAdapter(catAdapter);
    }

    @Override
    public void getCountries(MealsList mealsList) {
        homePresenter.getCountriesWithFlags(mealsList);
    }


    @Override
    public void showCountries(ArrayList<Country> countries) {
        Log.i(TAG, "getCountries: " + countries.size());
        countryAdapter = new CountryAdapter(getContext(), countries);
        countryRecycler.setAdapter(countryAdapter);
    }

    @Override
    public void onStart() {
        DataSaver.setView(getView());
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        requireActivity().registerReceiver(internetConnectionChangeListener, intentFilter);
        super.onStart();
    }

    @Override
    public void onStop() {
        requireActivity().unregisterReceiver(internetConnectionChangeListener);
        super.onStop();
    }

}