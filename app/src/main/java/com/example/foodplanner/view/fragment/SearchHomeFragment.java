package com.example.foodplanner.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.foodplanner.R;
import com.example.foodplanner.utils.NavigatorClass;


public class SearchHomeFragment extends Fragment {
    EditText search;
    Button ingredient, name, category, area;
    SearchHomeFragmentDirections.ActionSearchHomeFragmentToSearchFragment action;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        ingredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action.setRequest(ingredient.getText().toString());
                Navigation.findNavController(view).navigate(action);

            }
        });
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action.setRequest(name.getText().toString());
                Navigation.findNavController(view).navigate(action);
            }
        });
        area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action.setRequest(area.getText().toString());
                Navigation.findNavController(view).navigate(action);
            }
        });
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action.setRequest(category.getText().toString());
                Navigation.findNavController(view).navigate(action);
            }
        });

    }
    void init(View view){
        search = view.findViewById(R.id.searchBar);
        ingredient = view.findViewById(R.id.searchIngredient);
        name = view.findViewById(R.id.searchName);
        area = view.findViewById(R.id.searchArea);
        category = view.findViewById(R.id.searchCategory);
        action = SearchHomeFragmentDirections.actionSearchHomeFragmentToSearchFragment("");

    }
}