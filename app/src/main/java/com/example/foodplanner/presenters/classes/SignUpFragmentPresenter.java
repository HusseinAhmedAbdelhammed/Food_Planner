package com.example.foodplanner.presenters.classes;

import android.widget.EditText;

import androidx.annotation.NonNull;

import com.example.foodplanner.presenters.interfaces.SignUpFragmentInterface;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpFragmentPresenter {
    SignUpFragmentInterface signUpFragmentInterface;
    String email ,password;
    FirebaseAuth firebaseAuth;


    public SignUpFragmentPresenter(SignUpFragmentInterface signUpFragmentInterface) {
        this.signUpFragmentInterface = signUpFragmentInterface;
    }
    public void signUp (EditText emailET, EditText passwordET){
        firebaseAuth = FirebaseAuth.getInstance();

        email = emailET.getText().toString();
        password = passwordET.getText().toString();
        if(email.isEmpty()){
            emailET.setError("please enter your user email");
        }else if (password.isEmpty()){
            passwordET.setError("please enter your password");
        }else{
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            signUpFragmentInterface.signUp(task);
                        }
                    });
        }

    }
}
