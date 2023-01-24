package com.example.foodplanner.view.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodplanner.R;
import com.example.foodplanner.pojo.Meals;
import com.example.foodplanner.utils.ImageLoader;
import com.example.foodplanner.utils.MealSender;
import com.example.foodplanner.view.adapters.HomeAdapter;
import com.example.foodplanner.view.adapters.MealDetailsIngredientAdapter;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class MealDetailsActivity extends AppCompatActivity {
    ImageView mealThum;
    TextView mealTitle, mealCategory, mealInstruction, mealArea;
    YouTubePlayerView mealVideo;
    Meals passedMeal;
    RecyclerView ingredientRecycleView;
    ArrayList<String> ingredient;
    MealDetailsIngredientAdapter adapter;
    private static final String TAG = "MealDetailsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_details);
        declare();
        mealTitle.setText(passedMeal.getStrMeal());
        ImageLoader.loadImage(this,passedMeal.getStrMealThumb(),mealThum);
        mealCategory.setText(passedMeal.getStrCategory());
        mealInstruction.setText(passedMeal.getStrInstructions());
        mealArea.setText(passedMeal.getStrArea());
        mealVideo.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String[] videoId = passedMeal.getStrYoutube().split("=");
                youTubePlayer.loadVideo(videoId[1], 0);
            }
        });
        adapter=new MealDetailsIngredientAdapter(this,ingredient);
        ingredientRecycleView.setAdapter(adapter);

    }

    private void declare() {
        Intent intent = getIntent();
        passedMeal = (Meals) intent.getExtras().getSerializable(MealSender.PASSED_MEAL);
        ingredient = getAllIngredientList(passedMeal);
        mealThum = findViewById(R.id.mealThumDetail);
        mealTitle = findViewById(R.id.mealTitleDetail);
        mealCategory = findViewById(R.id.mealCategoryDetails);
        mealInstruction = findViewById(R.id.mealInstructionDetails);
        mealArea = findViewById(R.id.mealAreaDetails);
        mealVideo = findViewById(R.id.mealVideoDiscription);
        getLifecycle().addObserver(mealVideo);
        ingredientRecycleView = findViewById(R.id.ingredientRecyclerView);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.HORIZONTAL);
        ingredientRecycleView.setLayoutManager(manager);
    }

     ArrayList<String> getAllIngredientList(Meals meal){
         ArrayList<String> list = new ArrayList<>();
         if(!meal.getStrIngredient1().isEmpty())
             list.add(meal.getStrIngredient1());
         if(!meal.getStrIngredient2().isEmpty())
             list.add(meal.getStrIngredient2());
         if(!meal.getStrIngredient3().isEmpty())
             list.add(meal.getStrIngredient3());
         if(!meal.getStrIngredient4().isEmpty())
             list.add(meal.getStrIngredient4());
         if(!meal.getStrIngredient5().isEmpty())
             list.add(meal.getStrIngredient5());
         if(!meal.getStrIngredient6().isEmpty())
             list.add(meal.getStrIngredient6());
         if(!meal.getStrIngredient7().isEmpty())
             list.add(meal.getStrIngredient7());
         if(!meal.getStrIngredient8().isEmpty())
             list.add(meal.getStrIngredient8());
         if(!meal.getStrIngredient9().isEmpty())
             list.add(meal.getStrIngredient9());
         if(!meal.getStrIngredient10().isEmpty())
             list.add(meal.getStrIngredient10());
         if(!meal.getStrIngredient11().isEmpty())
             list.add(meal.getStrIngredient11());
         if(!meal.getStrIngredient12().isEmpty())
             list.add(meal.getStrIngredient12());
         if(!meal.getStrIngredient13().isEmpty())
             list.add(meal.getStrIngredient13());
         if(!meal.getStrIngredient14().isEmpty())
             list.add(meal.getStrIngredient14());
         if(!meal.getStrIngredient15().isEmpty())
             list.add(meal.getStrIngredient15());
         if(!meal.getStrIngredient16().isEmpty())
             list.add(meal.getStrIngredient16());
         if(!meal.getStrIngredient17().isEmpty())
             list.add(meal.getStrIngredient17());
         if(!meal.getStrIngredient18().isEmpty())
             list.add(meal.getStrIngredient18());
         if(!meal.getStrIngredient19().isEmpty())
             list.add(meal.getStrIngredient19());
         if(!meal.getStrIngredient20().isEmpty())
             list.add(meal.getStrIngredient20());
        return list;
    }


}