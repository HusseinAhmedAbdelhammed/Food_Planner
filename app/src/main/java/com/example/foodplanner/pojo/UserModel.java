package com.example.foodplanner.pojo;

import java.util.ArrayList;

public class UserModel {

    private String email;
    private String userId;



    private ArrayList<Integer> favMeals;

    public ArrayList<Integer> getFavMeals() {
        return favMeals;
    }

    public void setFavMeals(ArrayList<Integer> favMeals) {
        this.favMeals = favMeals;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
