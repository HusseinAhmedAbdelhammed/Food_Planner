package com.example.foodplanner.presenters.interfaces;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public interface SignUpFragmentInterface {
     void signUp (@NonNull Task<AuthResult> task);

     void sighUpSuccessWithGoogle();
     void signUpFaildWithGoogle();
}
