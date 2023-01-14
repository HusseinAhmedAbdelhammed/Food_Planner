package com.example.foodplanner.network;

import com.google.firebase.firestore.FirebaseFirestore;

public class fireBase {
    private static FirebaseFirestore db;
    private fireBase(){}
    public static FirebaseFirestore getDb(){
        if(db==null){
            db=FirebaseFirestore.getInstance();
        }
        return db;
    }
    

}
