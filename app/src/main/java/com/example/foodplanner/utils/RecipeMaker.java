package com.example.foodplanner.utils;

import java.util.ArrayList;

public class RecipeMaker {
    //when you add an ing
    public static String makeRecipe(ArrayList<String> list){
        StringBuilder recipe= new StringBuilder();
        for(int i=0;i< list.size();i++){
            if(i!=list.size()-1){
                recipe.append(list.get(i)).append(Consts.DELIMITER);
            }else{
                recipe.append(list.get(i));
            }
        }
        return recipe.toString();
    }
}

