package com.rjt.android.androidquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ScoreActivity extends AppCompatActivity {
    private TextView scoreView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        scoreView = findViewById(R.id.TextViewScore);
        ArrayList<String> answers = QuestionBank.userAnswers;


        boolean[] result = QuestionBank.checkAnswers();
        String res = "";
        for(int i = 0; i < result.length; i++){
            res += Boolean.toString(result[i]) + " ";
        }
        scoreView.setText(res);
    }
}
