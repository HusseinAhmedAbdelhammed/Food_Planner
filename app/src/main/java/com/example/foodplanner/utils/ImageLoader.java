package com.example.foodplanner.utils;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Objects;

public class ImageLoader {
    public static void loadImage(Context con, String url, ImageView imgView){
        Picasso.with(con).load(url).into(imgView);

    }
    public static void loadIngImage(Context con,String ingName,ImageView imgView,String size){
        if(Objects.equals(size, Consts.SIZE_BIG)){
            String url="https://www.themealdb.com/images/ingredients/"+ingName+".png";
            Picasso.with(con).load(url).into(imgView);
        }else{
            String url="https://www.themealdb.com/images/ingredients/"+ingName+"-Small.png";
            Picasso.with(con).load(url).into(imgView);
        }


    }
}
