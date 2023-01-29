package com.example.foodplanner.view.fragment;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.foodplanner.R;
import com.example.foodplanner.presenters.classes.ProfilePresenter;
import com.example.foodplanner.utils.Consts;
import com.example.foodplanner.utils.DataSaver;
import com.example.foodplanner.utils.InternetConnectionChangeListener;
import com.example.foodplanner.utils.NavigatorClass;

public class ProfileFragment extends Fragment {
Button backup;
ProfilePresenter presenter;
InternetConnectionChangeListener internetConnectionChangeListener;
Button logout;
LinearLayout profileGuest;
TextView login;


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

        if(DataSaver.getGuest().equals(Consts.GUEST)){
            backup.setVisibility(View.GONE);
            logout.setVisibility(View.GONE);
            profileGuest.setVisibility(View.VISIBLE);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NavigatorClass.navigateBetweenActivities(getContext(), NavigatorClass.MAIN);
                }
            });
        }else {
            backup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    presenter.saveFav();

                }
            });
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    presenter.clearData();
                    NavigatorClass.navigateBetweenActivities(getContext(), NavigatorClass.MAIN);
                }
            });
        }
    }
    public void init(View view){
        backup=view.findViewById(R.id.backup);
        presenter=new ProfilePresenter(getContext());
        logout=view.findViewById(R.id.logout);
        internetConnectionChangeListener = new InternetConnectionChangeListener();
        profileGuest = (LinearLayout) view.findViewById(R.id.profileGuestLayout);
        login = view.findViewById(R.id.profileLoginPlan);
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