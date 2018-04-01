package com.rjt.android.androidquiz;

import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity
        implements QuestionFragment.OnQuestionFragmentInteractionListener,
        ChoiceFragment.OnChoiceFragmentInteractionListener,
        NextFragment.OnNextFragmentInteractionListener {
    private int mCurrentQuestion;
    private ArrayList<Question> mQuestionBank;
    private String[] mQuestionAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Resources resource = getResources();
        String[] questions = resource.getStringArray(R.array.android_questions);
        String[] answers = resource.getStringArray(R.array.android_answers);
        mQuestionBank = new ArrayList<>();
        for (int i = 0; i < questions.length; i++) {
            mQuestionBank.add(new Question(questions[i], answers[i]));
        }


    }

    @Override
    public void onQuestionFragmentInteraction(Uri uri) {

    }

    @Override
    public void onChoiceFragmentInteraction(Uri uri) {

    }

    @Override
    public void onNextFragmentInteraction(Uri uri) {

    }
}
