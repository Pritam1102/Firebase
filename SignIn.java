package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;

import com.example.firebase.databinding.ActivitySignInBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {

    ActivitySignInBinding signInBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signInBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in);

        signInBinding.RegButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            Pair[] pairs = new Pair[3];

            pairs[0] = new Pair<View, String>(signInBinding.image,"Logo Image");
            pairs[1] = new Pair<View, String>(signInBinding.email,"Logo Image");
            pairs[2] = new Pair<View, String>(signInBinding.view,"Logo Image");
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignIn.this,pairs);
            startActivity(intent, options.toBundle());

        });
        signInBinding.SignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OperationsList.class);
                startActivity(intent);
            }
        });

    }

    private Boolean validateEmail() {
        String em = signInBinding.email.getEditText().getText().toString().trim();
        String noWhiteSpace = "\\A\\W{4,20}\\z";


        if (em.isEmpty()) {
            signInBinding.email.setError("Field can not be empty");
            return false;
        } else {
            signInBinding.email.setError(null);
            signInBinding.email.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword() {
        String pas = signInBinding.password.getEditText().getText().toString().trim();
        if (pas.isEmpty()) {
            signInBinding.password.setError("Field can not be empty");
            return false;
        } else {
            signInBinding.password.setError(null);
            signInBinding.password.setErrorEnabled(false);
            return true;
        }

    }

    public void loginUser(View view) {
        if (!validateEmail() | !validatePassword()) {
            return;
        } else {
            isUser();
        }
    }

    private void isUser() {
        String userEnteredEmail = signInBinding.email.getEditText().getText().toString().trim();
        String userEnteredPass = signInBinding.password.getEditText().getText().toString().trim();


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("UserDetails");

        Query checkUser = reference.orderByChild("email").equalTo(userEnteredEmail);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {

                    signInBinding.email.setError(null);
                    signInBinding.email.setErrorEnabled(false);

                    String passwordFromDB = snapshot.child(userEnteredEmail).child("password").getValue(String.class);
                    if (passwordFromDB.equals(userEnteredPass)) {

                        signInBinding.email.setError(null);
                        signInBinding.email.setErrorEnabled(false);

                        String nameFromDB = snapshot.child(userEnteredEmail).child("name").getValue(String.class);
                        String emailFromDB = snapshot.child(userEnteredEmail).child("email").getValue(String.class);
                        String phoneFromDB = snapshot.child(userEnteredEmail).child("phone").getValue(String.class);
                        String usernameFromDB = snapshot.child(userEnteredEmail).child("username").getValue(String.class);

//                        signInBinding.SignButton.setOnClickListener(v -> {
//                            Intent intent = new Intent(getApplicationContext(), UserProfile.class);
//                            intent.putExtra("name", nameFromDB);
//                            intent.putExtra("email", emailFromDB);
//                            intent.putExtra("phone", phoneFromDB);
//                            intent.putExtra("username", usernameFromDB);
//
//                            startActivity(intent);
//                            Log.d("Sign In","Sign in button pressed");
//                        });

                    } else {
                        signInBinding.password.setError("Wrong Password");
                        signInBinding.password.requestFocus();
                    }
                } else {
                    signInBinding.email.setError("No such user exist");
                    signInBinding.email.requestFocus();


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    @Override
    public void onBackPressed() {
        Log.d("Back press", "On backpress method called");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
        finish();
    }
}