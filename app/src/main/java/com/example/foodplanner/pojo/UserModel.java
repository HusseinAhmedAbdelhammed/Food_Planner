package com.example.foodplanner.pojo;

import java.util.ArrayList;

public class UserModel {
    private String name;
    private String email;
    private String password;
    private ArrayList<Integer> favMeals;

    public ArrayList<Integer> getFavMeals() {
        return favMeals;
    }

    public void setFavMeals(ArrayList<Integer> favMeals) {
        this.favMeals = favMeals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
