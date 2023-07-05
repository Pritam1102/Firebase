package com.example.firebase;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.firebase.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    ActivitySplashBinding splashBinding;

    Animation topAnimation, bottomAnimation, middleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);


        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        middleAnimation = AnimationUtils.loadAnimation(this,R.anim.middle_animation);

        splashBinding.firstLine.setAnimation(topAnimation);
        splashBinding.secondLine.setAnimation(topAnimation);
        splashBinding.thirdLine.setAnimation(topAnimation);
        splashBinding.fourthLine.setAnimation(topAnimation);
        splashBinding.fifthLine.setAnimation(topAnimation);
        splashBinding.sixthLine.setAnimation(topAnimation);
        splashBinding.seventhLine.setAnimation(topAnimation);

        splashBinding.logo.setAnimation(middleAnimation);
        splashBinding.tagLine.setAnimation(bottomAnimation);

        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);

        new Handler().postDelayed(() -> {
            Intent intent =new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 3000);
    }
}