package com.rjt.android.androidquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ScoreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        ArrayList<String> answers = QuestionBank.userAnswers;

        ArrayList<String> arrayRes = new ArrayList<>();
        boolean[] result = QuestionBank.checkAnswers();
        for(int i = 0; i < result.length; i++){
            answers.add("Problem " + Integer.toString(i+1) + ": " + (result[i]==true ? "Correct" : "Incorrect"));
        }
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, R.layout.layout_row_item, R.id.textView, answers);
        ListView lv = findViewById(R.id.listView);
        lv.setAdapter(itemsAdapter);

    }
}
