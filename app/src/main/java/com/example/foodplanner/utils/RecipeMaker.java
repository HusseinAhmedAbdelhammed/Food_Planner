package com.example.foodplanner.utils;

public class RecipeMaker {
    //when you add an ing
    public static String makeRecipe(String ... ingr){
        StringBuilder recipe= new StringBuilder();
        for(int i=0;i< ingr.length;i++){
            if(!ingr[i].isEmpty()||ingr[i]!=null){
                if(i!=ingr.length-1){
                    recipe.append(ingr[i]).append(Consts.DELIMITER);
                }else{
                    recipe.append(ingr[i]);
                }
            }
        }
        return recipe.toString();

    }
}

