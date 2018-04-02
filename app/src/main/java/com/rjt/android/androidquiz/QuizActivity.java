package com.rjt.android.androidquiz;

import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity
        implements OnQuestionFragmentInteractionListener,
        OnChoiceFragmentInteractionListener,
        NextFragment.OnNextFragmentInteractionListener {
    public static String getQFragmentKey() {
        return QFragmentKey;
    }

    public static String getQChoiceKey() {
        return QChoiceKey;
    }

    public static String getQNextKey() {
        return QNextKey;
    }

    private static final String QFragmentKey = "QUESTION_FRAGMENT_KEY";
    private static final String QChoiceKey = "CHOICE_FRAGMENT_KEY";
    private static final String QNextKey = "NEXT_FRAGMENT_KEY";
    private int mCurrentQuestion;
    private static ArrayList<Question> mQuestionBank;
    private QuestionFragment mQuestionFragment;
    private ChoiceFragment mChoiceFragment;
    private NextFragment mNextFragment;

    public void initeSetup() {

        mQuestionBank = QuestionBank.getSingletonBank().getQuestionBank();
        mCurrentQuestion = 0;
        mQuestionFragment = new QuestionFragment();
        mChoiceFragment = new ChoiceFragment();
        mNextFragment = new NextFragment();

        Question ques = mQuestionBank.get(mCurrentQuestion);
        Bundle questionBunlde = new Bundle();
        Bundle choiceBundle = new Bundle();
        questionBunlde.putString("InitialQuestion", ques.getQuestionText());
        mQuestionFragment.setArguments(questionBunlde);

        String c1 = mQuestionBank.get(mCurrentQuestion).choices.get(0).toString();
        String c2 = mQuestionBank.get(mCurrentQuestion).choices.get(1).toString();
        String c3 = mQuestionBank.get(mCurrentQuestion).choices.get(2).toString();
        String c4 = mQuestionBank.get(mCurrentQuestion).choices.get(3).toString();
        choiceBundle.putStringArray("InitialChoices", new String[]{c1, c2, c3, c4});
        mChoiceFragment.setArguments(choiceBundle);
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentQuestion, mQuestionFragment, QFragmentKey).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentChoice, mChoiceFragment, QChoiceKey).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentNext, mNextFragment, QNextKey).commit();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        initeSetup();
    }

    // update question fragment text view
    @Override
    public void onQuestionFragmentInteraction(String questionTex) {
        QuestionFragment qfg = ((QuestionFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentQuestion));
        qfg.updateQuestion(questionTex);
    }

    @Override
    public void onChoiceFragmentInteraction(String choiceA, String choiceB, String choiceC, String choiceD) {
        ((ChoiceFragment) getSupportFragmentManager().findFragmentByTag(QChoiceKey)).setText(choiceA, choiceB, choiceC, choiceD);
    }

    @Override
    public void onNextFragmentInteraction(Uri uri) {

    }
}
