package com.example.foodplanner.presenters.interfaces;

import androidx.annotation.NonNull;

import com.google.firebase.auth.AuthResult;

public interface LogInFragmentInterface {
    void logInSuccess (AuthResult authResult);
    void logInFailure (@NonNull Exception e);
    void loginSuccessWithGoogle();
    void loginFaildWithGoogle();
}
