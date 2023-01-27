package com.example.foodplanner.view.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.foodplanner.R;
import com.example.foodplanner.network.firebase.FireBase;
import com.example.foodplanner.presenters.classes.SignUpFragmentPresenter;
import com.example.foodplanner.presenters.interfaces.SignUpFragmentInterface;
import com.example.foodplanner.utils.Consts;
import com.example.foodplanner.utils.DataSaver;
import com.example.foodplanner.utils.NavigatorClass;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;

public class SignupFragment extends Fragment implements SignUpFragmentInterface {
    Button signUp,logInRedirct;
    EditText emailET, passwordET;
    FloatingActionButton signupgoogle, guest;
    FireBase fireBase;

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
        logInRedirct.setOnClickListener(new View.OnClickListener() {
         @Override
             public void onClick(View view) {
                 NavigatorClass.navigateBetweenFragments(view ,R.id.loginFragment);
             }
        });
        signupgoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(fireBase.getClient().getSignInIntent(), 100);

            }
        });
        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataSaver.setGuest(Consts.GUEST);
                NavigatorClass.navigateBetweenActivities(getActivity(),NavigatorClass.HOME);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        signUpFragmentPresenter.signUpWithGoogle(requestCode,data);
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

    @Override
    public void sighUpSuccessWithGoogle() {
        NavigatorClass.navigateBetweenActivities(getActivity(),NavigatorClass.HOME);
    }

    @Override
    public void signUpFaildWithGoogle() {
        Toast.makeText(getContext(), "sorry an error happen please try again",
                Toast.LENGTH_SHORT).show();
    }

    void declareComponents(@NonNull View view){
        signUp = view.findViewById(R.id.signupbtn);
        logInRedirct = view.findViewById(R.id.loginRedirect);
        emailET = view.findViewById(R.id.signUpUserName);
        passwordET = view.findViewById(R.id.signUpPassword);
        signupgoogle = view.findViewById(R.id.googleSignUP);
        guest = view.findViewById(R.id.guest);
        signUpFragmentPresenter = new SignUpFragmentPresenter(this);
        fireBase = new FireBase(getContext());

    }
}