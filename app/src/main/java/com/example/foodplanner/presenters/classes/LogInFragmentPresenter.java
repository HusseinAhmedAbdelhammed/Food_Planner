package com.example.foodplanner.presenters.classes;

import android.content.Intent;
import android.util.Log;
import android.util.Patterns;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.foodplanner.network.firebase.FireBase;
import com.example.foodplanner.presenters.interfaces.LogInFragmentInterface;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

public class LogInFragmentPresenter {
    LogInFragmentInterface logInFragmentInterface;
    FirebaseAuth firebaseAuth;
    String email, password;

    public LogInFragmentPresenter(LogInFragmentInterface logInFragmentInterface) {
        this.logInFragmentInterface = logInFragmentInterface;
    }

    public void logIn(EditText loginEmail, EditText loginPassword){
        firebaseAuth = FirebaseAuth.getInstance();
        email = loginEmail.getText().toString();
        password = loginPassword.getText().toString();
        if(!email.isEmpty()&& Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            if(!password.isEmpty()){
                FireBase.getFirebaseAuth().signInWithEmailAndPassword(email, password)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                logInFragmentInterface.logInSuccess(authResult);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                logInFragmentInterface.logInFailure(e);
                            }
                        });
            } else {
                loginPassword.setError("Please enter your password");
            }

        } else if (email.isEmpty()){
            loginEmail.setError("please enter your email");
        }else{
            loginEmail.setError("please enter a valid email");
        }
    }

    public void loginWithGoogle(int requestCode ,@Nullable Intent data){
        if (requestCode == 100) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            GoogleSignInAccount res = GoogleSignIn.getSignedInAccountFromIntent(data).getResult();
            if (res != null) {
                try {
                    task.getResult(ApiException.class);
                    authWithGoogle(res);
                    logInFragmentInterface.loginSuccessWithGoogle();
                } catch (ApiException e) {
                    e.printStackTrace();
                }
            } else {
                Log.d("auth", "on activity Failed ");
                logInFragmentInterface.loginFaildWithGoogle();
            }
        }

    }

    public void authWithGoogle(GoogleSignInAccount res) {
        AuthCredential authCredential = GoogleAuthProvider.getCredential(res.getIdToken(), null);

        try {
            FireBase.getFirebaseAuth().signInWithCredential(authCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
