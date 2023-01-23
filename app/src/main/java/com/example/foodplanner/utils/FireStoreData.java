package com.example.foodplanner.utils;

public class FireStoreData {
    private static String mail;

    public static String getMail() {
        return mail;
    }

    public static void setMail(String mail) {
        FireStoreData.mail = mail;
    }
}
