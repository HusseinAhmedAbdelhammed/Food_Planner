package com.example.foodplanner.network.firebase;

import com.google.firebase.firestore.FirebaseFirestore;

public class FireStore {
    private static FireStore fireStoreInstance;
    private FirebaseFirestore db;
    private FireStore(){
        db = FirebaseFirestore.getInstance();
    }

    public FirebaseFirestore getDb() {
        return db;
    }

    public static FireStore getInstance(){
        if(fireStoreInstance==null){
            fireStoreInstance=new FireStore();
        }
        return fireStoreInstance;
    }
}
