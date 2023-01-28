package com.example.foodplanner.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.foodplanner.R;
import com.example.foodplanner.presenters.classes.ProfilePresenter;

public class ProfileFragment extends Fragment {
Button backup;
ProfilePresenter presenter;


    public ProfileFragment() {
        // Required empty public constructor
    }





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);

        backup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.saveFav();

            }
        });
    }
    public void init(View view){
        backup=view.findViewById(R.id.backup);
        presenter=new ProfilePresenter(getContext());
    }
}