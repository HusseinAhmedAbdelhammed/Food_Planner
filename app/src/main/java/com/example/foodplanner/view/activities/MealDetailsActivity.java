package com.example.foodplanner.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodplanner.R;
import com.example.foodplanner.pojo.Meals;
import com.example.foodplanner.utils.ImageLoader;
import com.example.foodplanner.utils.MealSender;
import com.example.foodplanner.view.adapters.HomeAdapter;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class MealDetailsActivity extends AppCompatActivity {
    ImageView mealThum;
    TextView mealTitle, mealCategory, mealInstruction, mealArea;
    YouTubePlayerView mealVideo;
    Meals passedMeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_details);
        declare();
        Intent intent = getIntent();
        passedMeal = (Meals) intent.getExtras().getSerializable(MealSender.PASSED_MEAL);
        mealTitle.setText(passedMeal.getStrMeal());
        ImageLoader.loadImage(this,passedMeal.getStrMealThumb(),mealThum);
        mealCategory.setText(passedMeal.getStrCategory());
        mealInstruction.setText(passedMeal.getStrInstructions());


    }

    private void declare() {
        mealThum = findViewById(R.id.mealThumDetail);
        mealTitle = findViewById(R.id.mealTitleDetail);
        mealCategory = findViewById(R.id.mealCategoryDetails);
        mealInstruction = findViewById(R.id.mealInstructionDetails);
        mealArea = findViewById(R.id.mealAreaDetails);
        mealVideo = findViewById(R.id.mealVideoDiscription);
    }


}