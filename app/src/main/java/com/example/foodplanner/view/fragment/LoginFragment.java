package com.example.foodplanner.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.example.foodplanner.presenters.classes.LogInFragmentPresenter;
import com.example.foodplanner.presenters.interfaces.LogInFragmentInterface;
import com.example.foodplanner.utils.NavigatorClass;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginFragment extends Fragment implements LogInFragmentInterface {
    Button signInbtn;
    FloatingActionButton logingoogle;
    EditText loginEmail, loginPassword;
    TextView signUp;
    LogInFragmentPresenter logInFragmentPresenter;
    GoogleSignInClient client;
    GoogleSignInOptions options;
    private static final String TAG = "LoginFragment";
    private FirebaseAuth auth;

    String token = "217373600742-2ma9luo2jq275fm230jiarutlo81ln45.apps.googleusercontent.com";


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
        options = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(token)
                .requestEmail()
                .build();
        client = GoogleSignIn.getClient(getContext(), options);
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
                signIn();
                Toast.makeText(getContext(), "hello", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void signIn() {

        Intent intent = client.getSignInIntent();
        startActivityForResult(intent, 100);
    }

    void declareComponents(@NonNull View view) {
        signInbtn = view.findViewById(R.id.logInbtn);
        loginEmail = view.findViewById(R.id.logInserName);
        loginPassword = view.findViewById(R.id.logInPassword);
        signUp = view.findViewById(R.id.signUpRedirect);
        logingoogle = view.findViewById(R.id.logInGooglebtn);
        logInFragmentPresenter = new LogInFragmentPresenter(this);
        auth = FirebaseAuth.getInstance();


    }

    @Override
    public void logInSuccess(AuthResult authResult) {
        Toast.makeText(getContext(), "login Successfully",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void logInFailure(@NonNull Exception e) {
        Toast.makeText(getContext(), "incorrect email or password",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            GoogleSignInAccount res = GoogleSignIn.getSignedInAccountFromIntent(data).getResult();
            if (res != null) {

                try {
                    task.getResult(ApiException.class);
                    authWithGoogle(res);
                    NavigatorClass.navigateBetweenFragments(getView(), R.id.splashFragment);

                } catch (ApiException e) {
                    e.printStackTrace();
                }

            } else {
                Log.d("auth", "on activity Failed ");
            }
        }
    }


    public void authWithGoogle(GoogleSignInAccount res) {
        AuthCredential authCredential = GoogleAuthProvider.getCredential(res.getIdToken(), null);

        try {
           auth.signInWithCredential(authCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    }
