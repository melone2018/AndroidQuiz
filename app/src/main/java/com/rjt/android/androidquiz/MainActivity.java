package com.rjt.android.androidquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginHandler(View view) {
     //   Button tbn = findViewById(R.id.Buttonlogin);
        Intent intent = new Intent(MainActivity.this, QuizActivity.class);
        startActivity(intent);
    }
}
