package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.firebase.databinding.ActivityUserProfileBinding;

public class UserProfile extends AppCompatActivity {

    ActivityUserProfileBinding userProfileBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userProfileBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_profile);

        showAllUserData();

    }

    private void showAllUserData() {
        Intent intent = getIntent();
        String  user_name = intent.getStringExtra("name");
        String  user_username = intent.getStringExtra("username");
        String  user_phone = intent.getStringExtra("phone");
        String  user_email = intent.getStringExtra("email");

        userProfileBinding.Fullname.setText(user_name);
        userProfileBinding.email.setText(user_email);
        userProfileBinding.phoneNo.setText(user_phone);
        userProfileBinding.userName.setText(user_username);
    }
}