package com.example.foodplanner.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.foodplanner.R;

public class SearchHomeFragment extends Fragment {
    EditText search;
    Button ingredient, name, category, area;




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
        
    }
    void init(View view){
        search = view.findViewById(R.id.searchBar);
        ingredient = view.findViewById(R.id.searchIngredient);
        name = view.findViewById(R.id.searchName);
        area = view.findViewById(R.id.searchArea);
        category = view.findViewById(R.id.searchCategory);

    }
}