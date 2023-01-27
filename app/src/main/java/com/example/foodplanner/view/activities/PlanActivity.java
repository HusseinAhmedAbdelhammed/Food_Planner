package com.example.foodplanner.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.foodplanner.R;
import com.example.foodplanner.pojo.PlanModel;
import com.example.foodplanner.presenters.classes.PlanActivityPresenter;

public class PlanActivity extends AppCompatActivity {
RadioGroup days,type;
Button addPlan;
String day="";
String mealType="";
String mealName="";
long planId=0;
String mealThum="";
PlanActivityPresenter presenter;
PlanModel planModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        init();
        Intent intent2=getIntent();
        mealName=intent2.getStringExtra("mealName");
        mealThum=intent2.getStringExtra("mealThum");
        days.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton=findViewById(i);
                day=radioButton.getText().toString();
                planModel.setDay(day);
            }
        });
        type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton=findViewById(i);
                mealType=radioButton.getText().toString();
                planModel.setType(mealType);
            }
        });
        planId=System.currentTimeMillis();

        planModel.setPlanID(planId);
        planModel.setMealName(mealName);

        planModel.setMealThum(mealThum);

        addPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.insertPlan(planModel);
            }
        });

    }
    public void init(){
        days=findViewById(R.id.days);
        type=findViewById(R.id.type);
        addPlan=findViewById(R.id.planButton);
        presenter=new PlanActivityPresenter(this);
        planModel=new PlanModel();
    }
}