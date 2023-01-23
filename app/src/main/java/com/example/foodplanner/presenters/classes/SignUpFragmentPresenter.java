package com.example.foodplanner.presenters.classes;

import android.content.Intent;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.foodplanner.network.firebase.FireBase;
import com.example.foodplanner.presenters.interfaces.SignUpFragmentInterface;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.GoogleAuthProvider;

public class SignUpFragmentPresenter {
    SignUpFragmentInterface signUpFragmentInterface;
    String email ,password;


    public SignUpFragmentPresenter(SignUpFragmentInterface signUpFragmentInterface) {
        this.signUpFragmentInterface = signUpFragmentInterface;
    }
    public void signUp (EditText emailET, EditText passwordET){
        email = emailET.getText().toString();
        password = passwordET.getText().toString();
        if(email.isEmpty()){
            emailET.setError("please enter your user email");
        }else if (password.isEmpty()){
            passwordET.setError("please enter your password");
        }else{
            FireBase.getFirebaseAuth().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            signUpFragmentInterface.signUp(task);
                        }
                    });
        }
    }
    public void signUpWithGoogle(int requestCode ,@Nullable Intent data){
        if (requestCode == 100) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            GoogleSignInAccount res = GoogleSignIn.getSignedInAccountFromIntent(data).getResult();
            if (res != null) {
                try {
                    task.getResult(ApiException.class);
                    authWithGoogle(res);
                    signUpFragmentInterface.sighUpSuccessWithGoogle();
                } catch (ApiException e) {
                    e.printStackTrace();
                }
            } else {
                signUpFragmentInterface.signUpFaildWithGoogle();
                Log.d("auth", "on activity Failed ");
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
