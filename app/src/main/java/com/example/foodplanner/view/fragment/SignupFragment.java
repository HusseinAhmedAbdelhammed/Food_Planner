package com.example.foodplanner.view.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.foodplanner.R;
import com.example.foodplanner.presenters.classes.SignUpFragmentPresenter;
import com.example.foodplanner.presenters.interfaces.SignUpFragmentInterface;
import com.example.foodplanner.utils.NavigatorClass;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class SignupFragment extends Fragment implements SignUpFragmentInterface {
    Button signUp;
    TextView logIn;
    EditText emailET, passwordET;
    SignUpFragmentPresenter signUpFragmentPresenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        declareComponents(view);
        signUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                signUpFragmentPresenter.signUp(emailET, passwordET);

            }
        });
        logIn.setOnClickListener(new View.OnClickListener() {
         @Override
             public void onClick(View view) {
                 NavigatorClass.navigateBetweenFragments(view ,R.id.loginFragment);
             }

        });
    }

    void declareComponents(@NonNull View view){
        signUp = view.findViewById(R.id.signupbtn);
        logIn = view.findViewById(R.id.loginRedirect);
        emailET = view.findViewById(R.id.signUpUserName);
        passwordET = view.findViewById(R.id.signUpPassword);
        signUpFragmentPresenter = new SignUpFragmentPresenter(this::signUp);

    }

    @Override
    public void signUp(@NonNull Task<AuthResult> task) {
        if(task.isSuccessful()){
            Toast.makeText(getContext(), "signUp Successfully", Toast.LENGTH_SHORT).show();
            NavigatorClass.navigateBetweenFragments(getView(), R.id.loginFragment);
        }else{
            Toast.makeText(getContext(), "faild" +
                    task.getException().getMessage() , Toast.LENGTH_SHORT).show();
        }
    }
}