package com.example.foodplanner.view.fragment;

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
import com.example.foodplanner.pojo.MealsList;
import com.example.foodplanner.presenters.classes.SearchFragmentPresenter;
import com.example.foodplanner.presenters.interfaces.SearchFragmentInterface;
import com.example.foodplanner.view.adapters.SearchAdapter;

public class SearchFragment extends Fragment implements SearchFragmentInterface {
    EditText search;
    String request;
    RecyclerView items;
    private static final String TAG = "SearchFragment";
    SearchFragmentPresenter presenter;
    SearchAdapter adapter;

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
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.getSearchResults(request,charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
//        switch (request){
//            case "Ingredient":
//                //code
//                Log.i(TAG, "onViewCreated: "  +request);
//                break;
//            case "Area":
//                //code
//                break;
//            case "Category":
//                //code
//                break;
//            case "Name":
//                //code
//                break;
//        }
    }

    private void init(View view) {
        search = view.findViewById(R.id.searchBar1);
        request = SearchFragmentArgs.fromBundle(getArguments()).getRequest();
        items=view.findViewById(R.id.items);
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.VERTICAL);
        items.setLayoutManager(manager);
        presenter=new SearchFragmentPresenter(this);
    }

    @Override
    public void showResult(MealsList mealsList) {
        adapter=new SearchAdapter(getContext(),mealsList.getMeals());
        items.setAdapter(adapter);
    }
}