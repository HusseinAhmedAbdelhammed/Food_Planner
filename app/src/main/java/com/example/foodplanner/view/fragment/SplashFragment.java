package com.example.foodplanner.view.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.foodplanner.R;
import com.example.foodplanner.database.SharedPrefrencesClass;
import com.example.foodplanner.utils.NavigatorClass;

public class SplashFragment extends Fragment {
    Button getStarted;
    SharedPrefrencesClass sharedPref;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getStarted = view.findViewById(R.id.getStartedbtn);
        sharedPref = new SharedPrefrencesClass(getActivity());
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(SharedPrefrencesClass.isIsFirstTime()){
                    SharedPrefrencesClass.setIsFirstTime(false);
                    NavigatorClass.navigateBetweenFragments(view, R.id.action_splashFragment_to_splach1Fragment);
                } else if(SharedPrefrencesClass.isIsLogedIn()){
                    NavigatorClass.navigateBetweenActivities(getActivity(),NavigatorClass.HOME);
                }else {
                    NavigatorClass.navigateBetweenFragments(view, R.id.action_splashFragment_to_signupFragment);
                }
            }
//                NavigatorClass.navigateBetweenFragments(view, R.id.action_splashFragment_to_splach1Fragment);
//                NavigatorClass.navigateBetweenActivities(getActivity(),NavigatorClass.HOME);
                //NavigatorClass.navigateBetweenFragments(view, R.id.nav_host_fragment_home);

        });
    }
}