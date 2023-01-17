package com.example.foodplanner.view.fragment;

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

import com.example.foodplanner.R;
import com.example.foodplanner.pojo.CategoriesList;
import com.example.foodplanner.presenters.classes.TestFragmentPresenter;
import com.example.foodplanner.presenters.interfaces.TestFragmentInterface;
import com.example.foodplanner.view.adapters.TestFragmentAdapter;


public class CatFragment extends Fragment implements TestFragmentInterface {
RecyclerView rec;
TestFragmentPresenter presenter;
TestFragmentAdapter adapter;

    public CatFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
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
        Log.i("SONIC"," e.getMessage()");
        presenter.getCateg();
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.VERTICAL);
        rec.setLayoutManager(manager);
    }

    @Override
    public void showCategories(CategoriesList categoriesList) {
        adapter=new TestFragmentAdapter(getContext(),categoriesList.getCategories());
        rec.setAdapter(adapter);
    }
    public void init(View view){
        rec=view.findViewById(R.id.recHome);
        presenter=new TestFragmentPresenter(this);
    }
}