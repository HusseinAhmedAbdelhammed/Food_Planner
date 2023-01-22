package com.example.foodplanner.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.foodplanner.R;

public class SearchFragment extends Fragment {
    EditText search;
    String request;
    private static final String TAG = "SearchFragment";


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
        switch (request){
            case "Ingredient":
                //code
                Log.i(TAG, "onViewCreated: "  +request);
                break;
            case "Area":
                //code
                break;
            case "Category":
                //code
                break;
            case "Name":
                //code
                break;
        }
    }

    private void init(View view) {
        search = view.findViewById(R.id.searchBar1);
        request = SearchFragmentArgs.fromBundle(getArguments()).getRequest();
    }
}