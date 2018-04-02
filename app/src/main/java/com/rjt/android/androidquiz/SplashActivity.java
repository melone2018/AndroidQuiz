package com.rjt.android.androidquiz;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    static Resources mResources;
    static int android_questions;
    static int android_answers;
    static int android_choices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mResources = getResources();
        android_questions = R.array.android_questions;
        android_answers = R.array.android_answers;
        android_choices = R.array.android_choices;
        setContentView(R.layout.activity_splash);
        Intent i = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(i);
//
//                // close this activity
        finish();
//        new Handler().postDelayed(new Runnable() {
//
//
//            @Override
//            public void run() {
//                // This method will be executed once the timer is over
//                // Start your app main activity
//                Intent i = new Intent(SplashActivity.this, MainActivity.class);
//                startActivity(i);
//
//                // close this activity
//                finish();
//            }
//        }, SPLASH_TIME_OUT);
    }

}
