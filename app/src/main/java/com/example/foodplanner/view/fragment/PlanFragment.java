package com.example.foodplanner.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.pojo.PlanModel;
import com.example.foodplanner.presenters.classes.PlanDisplayPresenter;
import com.example.foodplanner.presenters.interfaces.PlanDisplayInterface;
import com.example.foodplanner.utils.Consts;
import com.example.foodplanner.utils.DataSaver;
import com.example.foodplanner.utils.NavigatorClass;
import com.example.foodplanner.view.adapters.PlanDisplayAdapter;

import java.util.ArrayList;
import java.util.List;


public class PlanFragment extends Fragment implements PlanDisplayInterface {
    RecyclerView satRec,sunRec,tusRec,thuRec,wedRec,friRec,monRec;
    PlanDisplayPresenter presenter;
    LinearLayout planGuest, planUser;
    TextView loginTV;
    ScrollView scrollView;

    public PlanFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        if(DataSaver.getGuest().equals(Consts.GUEST)){
            scrollView.setVisibility(View.GONE);
            planGuest.setVisibility(View.VISIBLE);
            loginTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), "hello", Toast.LENGTH_SHORT).show();
                    NavigatorClass.navigateBetweenActivities(getContext(), NavigatorClass.MAIN);

                }
            });
        }else{
            presenter.getDays();
        }
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        LinearLayoutManager manager2=new LinearLayoutManager(getContext());
        manager2.setOrientation(RecyclerView.HORIZONTAL);
        LinearLayoutManager manager3=new LinearLayoutManager(getContext());
        manager3.setOrientation(RecyclerView.HORIZONTAL);
        LinearLayoutManager manager4=new LinearLayoutManager(getContext());
        manager4.setOrientation(RecyclerView.HORIZONTAL);
        LinearLayoutManager manager5=new LinearLayoutManager(getContext());
        manager5.setOrientation(RecyclerView.HORIZONTAL);
        LinearLayoutManager manager6=new LinearLayoutManager(getContext());
        manager6.setOrientation(RecyclerView.HORIZONTAL);
        LinearLayoutManager manager7=new LinearLayoutManager(getContext());
        manager7.setOrientation(RecyclerView.HORIZONTAL);
        satRec.setLayoutManager(manager);
        sunRec.setLayoutManager(manager2);
        monRec.setLayoutManager(manager3);
        tusRec.setLayoutManager(manager4);
        wedRec.setLayoutManager(manager5);
        thuRec.setLayoutManager(manager6);
        friRec.setLayoutManager(manager7);

    }
    public void init(View view){
        satRec=view.findViewById(R.id.satRec);
        sunRec=view.findViewById(R.id.sunRec);
        tusRec=view.findViewById(R.id.tusRec);
        thuRec=view.findViewById(R.id.thuRec);
        wedRec=view.findViewById(R.id.wedRec);
        friRec=view.findViewById(R.id.friRec);
        monRec=view.findViewById(R.id.monRec);
        presenter=new PlanDisplayPresenter(this,getContext());
        planUser = (LinearLayout) view.findViewById(R.id.planeLayout);
        planGuest = (LinearLayout) view.findViewById(R.id.planeGuestLayout);
        loginTV = view.findViewById(R.id.guestLoginPlan);
        scrollView = view.findViewById(R.id.scrollable);
    }

    @Override
    public void showSat(List<PlanModel> satlist) {
        if(satlist!=null){
            PlanDisplayAdapter adapter=new PlanDisplayAdapter(getContext(),satlist);
            satRec.setAdapter(adapter);
        }
    }

    @Override
    public void showSun(List<PlanModel> sunlist) {
        if(sunlist!=null){
            PlanDisplayAdapter adapter2=new PlanDisplayAdapter(getContext(),sunlist);
            sunRec.setAdapter(adapter2);
        }
    }

    @Override
    public void showMon(List<PlanModel> monlist) {
        if(monlist!=null){
            PlanDisplayAdapter adapter3=new PlanDisplayAdapter(getContext(),monlist);
            monRec.setAdapter(adapter3);
        }
    }

    @Override
    public void showTue(List<PlanModel> tuelist) {
        if(tuelist!=null){
            PlanDisplayAdapter adapter4=new PlanDisplayAdapter(getContext(),tuelist);
            tusRec.setAdapter(adapter4);
        }
    }

    @Override
    public void showWed(List<PlanModel> wedlist) {
        if(wedlist!=null){

            PlanDisplayAdapter adapter5=new PlanDisplayAdapter(getContext(),wedlist);
            wedRec.setAdapter(adapter5);
        }
        Toast.makeText(getContext(),"no",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showThu(List<PlanModel> thulist) {
        if(thulist!=null){
            PlanDisplayAdapter adapter6=new PlanDisplayAdapter(getContext(),thulist);
            thuRec.setAdapter(adapter6);
        }
    }

    @Override
    public void showFri(List<PlanModel> frilist) {
        if(frilist!=null){
            PlanDisplayAdapter adapter7=new PlanDisplayAdapter(getContext(),frilist);
            friRec.setAdapter(adapter7);
            Toast.makeText(getContext(),"friday yes",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getContext(),"no",Toast.LENGTH_LONG).show();
        }
    }
}