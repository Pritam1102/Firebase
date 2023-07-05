package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.firebase.databinding.ActivityOperationsListBinding;


public class OperationsList extends AppCompatActivity {

    ActivityOperationsListBinding opBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        opBinding = DataBindingUtil.setContentView(this, R.layout.activity_operations_list);

        opBinding.vector.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), VectorOperations.class);
            startActivity(intent);
        });

    }
}