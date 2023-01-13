package com.example.foodplanner.utils;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageLoader {
    public static void loadImage(Context con, String url, ImageView imgView){
        Picasso.with(con).load(url).into(imgView);

    }
    public static void loadIngImage(Context con,String ingName,ImageView imgView){
        String url="www.themealdb.com/images/ingredients/"+ingName+"-Small.png";
        Picasso.with(con).load(url).into(imgView);

    }
}
