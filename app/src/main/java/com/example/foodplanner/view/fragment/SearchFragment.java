package com.example.foodplanner.view.fragment;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.foodplanner.R;
import com.example.foodplanner.pojo.Meals;
import com.example.foodplanner.pojo.MealsList;
import com.example.foodplanner.presenters.classes.SearchFragmentPresenter;
import com.example.foodplanner.presenters.interfaces.SearchFragmentInterface;
import com.example.foodplanner.utils.DataSaver;
import com.example.foodplanner.utils.InternetConnectionChangeListener;
import com.example.foodplanner.view.adapters.SearchAdapter;

import java.util.ArrayList;

public class SearchFragment extends Fragment implements SearchFragmentInterface {
    EditText search;
    String request;
    RecyclerView items;
    private static final String TAG = "SearchFragment";
    SearchFragmentPresenter presenter;
    SearchAdapter adapter;
    InternetConnectionChangeListener internetConnectionChangeListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
//        presenter.getSearchResults(request,"dessert");
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.getSearchResults(request, charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    private void init(View view) {
        search = view.findViewById(R.id.searchBar1);
        request = SearchFragmentArgs.fromBundle(getArguments()).getRequest();
        items=view.findViewById(R.id.items);
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.VERTICAL);
        items.setLayoutManager(manager);
        presenter=new SearchFragmentPresenter(this);
        internetConnectionChangeListener = new InternetConnectionChangeListener();
    }

    @Override
    public void showResult(MealsList mealsList) {
//        Log.i(TAG, "showResult: name" + ((mealsList.getMeals()).get(0)).getStrMeal());
//        Log.i(TAG, "showResult: cat" + ((mealsList.getMeals()).get(0)).getStrCategory() );
        adapter=new SearchAdapter(getContext(),mealsList.getMeals());
        items.setAdapter(adapter);
        Log.i(TAG, "showResult: size" + mealsList.getMeals());
        if (mealsList != null) {
            if (mealsList.getMeals() != null) {
                Log.i(TAG, "test: instruction " + mealsList.getMeals().get(0).getStrInstructions());
                Log.i(TAG, "test: name" + mealsList.getMeals().get(0).getStrMeal());
                Log.i(TAG, "test: cat" + mealsList.getMeals().get(0).getStrCategory());
            }
        }
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