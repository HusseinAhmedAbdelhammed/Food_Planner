package com.example.foodplanner.utils;

public class RecipeMaker {
    //when you add an ing
    public static String makeRecipe(String ... ingr){
        String recipe="";
        for(int i=0;i< ingr.length;i++){
            if(!ingr[i].isEmpty()||ingr[i]!=null){
                if(i!=ingr.length-1){
                    recipe=recipe+ingr[i]+Consts.DELIMITER;
                }else{
                    recipe=recipe+ingr[i];
                }

            }
        }
        return recipe;

    }
}
