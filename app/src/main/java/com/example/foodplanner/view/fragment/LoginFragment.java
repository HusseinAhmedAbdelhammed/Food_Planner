package com.example.foodplanner.view.fragment;

import android.content.Intent;
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
import com.example.foodplanner.database.SharedPrefrencesClass;
import com.example.foodplanner.network.firebase.FireBase;
import com.example.foodplanner.presenters.classes.LogInFragmentPresenter;
import com.example.foodplanner.presenters.interfaces.LogInFragmentInterface;
import com.example.foodplanner.utils.NavigatorClass;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginFragment extends Fragment implements LogInFragmentInterface {
    Button signInbtn;
    FloatingActionButton logingoogle;
    EditText loginEmail, loginPassword;
    TextView signUp;
    LogInFragmentPresenter logInFragmentPresenter;
    FireBase fireBase;

    private static final String TAG = "LoginFragment";
    private FirebaseAuth auth;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        declareComponents(view);

        signInbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logInFragmentPresenter.logIn(loginEmail, loginPassword);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavigatorClass.navigateBetweenFragments(view, R.id.signupFragment);
            }
        });
        logingoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(fireBase.getClient().getSignInIntent(), 100);
                Toast.makeText(getContext(), "hello", Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public void logInSuccess(AuthResult authResult) {
        SharedPrefrencesClass.setIsLogedIn(true);
        Toast.makeText(getContext(), "login Successfully",
                Toast.LENGTH_SHORT).show();

        NavigatorClass.navigateBetweenActivities(getActivity(),NavigatorClass.HOME);

    }

    @Override
    public void logInFailure(@NonNull Exception e) {
        Toast.makeText(getContext(), "incorrect email or password",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccessWithGoogle(){
        SharedPrefrencesClass.setIsLogedIn(true);
        NavigatorClass.navigateBetweenActivities(getActivity(),NavigatorClass.HOME);
    }

    @Override
    public void loginFaildWithGoogle() {
        Toast.makeText(getContext(), "sorry an error happen please try again",
                Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        logInFragmentPresenter.loginWithGoogle(requestCode,data);
    }


    void declareComponents(@NonNull View view) {
        signInbtn = view.findViewById(R.id.logInbtn);
        loginEmail = view.findViewById(R.id.logInserName);
        loginPassword = view.findViewById(R.id.logInPassword);
        signUp = view.findViewById(R.id.signUpRedirect);
        logingoogle = view.findViewById(R.id.logInGooglebtn);
        logInFragmentPresenter = new LogInFragmentPresenter(this);
        auth = FirebaseAuth.getInstance();
        fireBase = new FireBase(getContext());
    }

    }
