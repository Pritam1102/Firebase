package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.firebase.databinding.ActivityMainBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.regButton.setOnClickListener(v -> {

            rootNode = FirebaseDatabase.getInstance();
            reference = rootNode.getReference("userDetails");

            String name = binding.Name.getEditText().getText().toString();
            String userName = binding.userName.getEditText().getText().toString();
            String email = binding.email.getEditText().getText().toString();
            String phone = binding.phone.getEditText().getText().toString();
            String password = binding.password.getEditText().getText().toString();

            UserHelperClass helperClass = new UserHelperClass(name,userName,email,phone,password);

            reference.setValue(helperClass);

            Intent intent = new Intent(getApplicationContext(), SignIn.class);
            startActivity(intent);

        });

        binding.signin.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SignIn.class);
            startActivity(intent);
            finish();
        });
    }
}