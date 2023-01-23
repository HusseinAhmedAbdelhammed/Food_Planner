package com.example.foodplanner.network.firebase;

import android.content.Context;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;

public class FireBase {
    private static FirebaseAuth firebaseAuth;
    private  static String token = "217373600742-2ma9luo2jq275fm230jiarutlo81ln45.apps.googleusercontent.com";
    GoogleSignInClient client;
    GoogleSignInOptions options;

    public FireBase(Context context){
        this.options =  new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(token)
                .requestEmail()
                .build();

        this.client = GoogleSignIn.getClient(context, options);

    }
    public static FirebaseAuth getFirebaseAuth(){
        if(firebaseAuth == null){
            firebaseAuth = FirebaseAuth.getInstance();
        }
        return firebaseAuth;
    }
    public static String getToken() {
        return token;
    }

    public GoogleSignInClient getClient() {
        return client;
    }

    public GoogleSignInOptions getOptions() {
        return options;
    }
}
