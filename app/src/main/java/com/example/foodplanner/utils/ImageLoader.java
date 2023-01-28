package com.example.foodplanner.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class ImageLoader {
//    public static void loadImage(Context con, String url, ImageView imgView){
//
//        try {
//            imgView.setImageBitmap(Picasso.with(con).load(url).get());
//        } catch (IOException e) {
//            Log.i("SonicImageLoader", "readImgFromRoom: "+e.getMessage());
//        }

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

    public static void loadCountryImage(Context con,String countryName,ImageView imgView){
            String url="https://countryflagsapi.com/png/"+countryName;
            Picasso.with(con).load(url).into(imgView);
    }
    public static String saveImageToRoom(ImageView imgView,Context con,String pName){
        String result="";
        File directory=con.getDir(Consts.DIRECTORY,Context.MODE_PRIVATE);
        File imagFIle=new File(directory,pName+".jpg");
        FileOutputStream outputStream=null;
        Bitmap image;
        try {
            image =((BitmapDrawable)imgView.getDrawable()).getBitmap();
            outputStream=new FileOutputStream(imagFIle);
            image.compress(Bitmap.CompressFormat.PNG,100,outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            Log.i("SonicImageLoader", "readImgFromRoom: "+e.getMessage());
        } catch (IOException e) {
            Log.i("SonicImageLoader", "readImgFromRoom: "+e.getMessage());
        }
        result=directory.getAbsolutePath()+Consts.DELIMITER_IMAGE_PATH+pName+".jpg";
        return result;
    }
    public static void readImgFromRoom(String url,ImageView imageView){
        FileInputStream fis=null;
        String[] pathAndName=url.split(Consts.DELIMITER_IMAGE_PATH);
        File file=new File(pathAndName[0],pathAndName[1]);
        try {
            fis=new FileInputStream(file);
            Bitmap image= BitmapFactory.decodeStream(fis);
            imageView.setImageBitmap(image);
            fis.close();
        } catch (FileNotFoundException e) {
            Log.i("SonicImageLoader", "readImgFromRoom: "+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
