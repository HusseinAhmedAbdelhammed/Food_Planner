package com.example.foodplanner.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.foodplanner.R;
import com.example.foodplanner.utils.NavigatorClass;

public class Splach1Fragment extends Fragment {
    Button next;
    TextView skip;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_splach1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        next = view.findViewById(R.id.spalsh1Nextbtn);
        skip = view.findViewById(R.id.spalsh1SkipTV);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavigatorClass.navigateBetweenFragments(view, R.id.action_splach1Fragment_to_signupFragment);
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavigatorClass.navigateBetweenFragments(view, R.id.action_splach1Fragment_to_signupFragment);

            }
        });
    }
}