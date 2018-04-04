package com.rjt.android.androidquiz;

import android.content.Intent;
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
{
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
    private QuestionFragment mQuestionFragment;
    private ChoiceFragment mChoiceFragment;
    private NextFragment mNextFragment;

    public void initeSetup() {
        mQuestionFragment = new QuestionFragment();
        mChoiceFragment = new ChoiceFragment();
        mNextFragment = new NextFragment();

        Question ques = QuestionBank.getSingletonBank().getCurrentQuestion();
        Bundle questionBunlde = new Bundle();
        Bundle choiceBundle = new Bundle();
        questionBunlde.putString("InitialQuestion", ques.getQuestionText());
        mQuestionFragment.setArguments(questionBunlde);

        String c1 = QuestionBank.getCurrentQuestion().choices.get(0).toString();
        String c2 = QuestionBank.getCurrentQuestion().choices.get(1).toString();
        String c3 = QuestionBank.getCurrentQuestion().choices.get(2).toString();
        String c4 = QuestionBank.getCurrentQuestion().choices.get(3).toString();
        choiceBundle.putStringArray("InitialChoices", new String[]{c1, c2, c3, c4});
        mChoiceFragment.setArguments(choiceBundle);
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentQuestion, mQuestionFragment, QFragmentKey).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentChoice, mChoiceFragment, QChoiceKey).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentNext, mNextFragment, QNextKey).commit();
        getSupportFragmentManager().executePendingTransactions();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        initeSetup();
        NextFragment myNextFragment = (NextFragment) getSupportFragmentManager().findFragmentByTag(QNextKey);
        myNextFragment.setOnNextListener(new OnNextClickListener()
        {
            @Override
            public void onNextClick(boolean isClick) {
                if(QuestionBank.getQuestionNum()==QuestionBank.getQuestionIndex()) {
                    ChoiceFragment mCF = (ChoiceFragment)getSupportFragmentManager().findFragmentByTag(QChoiceKey);
                    String answer = mCF.giveAnswer(mCF.findOutCheckedId());
                    QuestionBank.fillUserAnswer(answer);
                    Intent intent = new Intent(getApplicationContext(), ScoreActivity.class);
                    startActivity(intent);
                }else {
                    Log.i("QuestionBank", Integer.toString(QuestionBank.getQuestionBank().size()));
                    QuestionFragment mQF = (QuestionFragment) getSupportFragmentManager().findFragmentByTag(QFragmentKey);
                    ChoiceFragment mCF = (ChoiceFragment) getSupportFragmentManager().findFragmentByTag(QChoiceKey);
                    String answer = mCF.giveAnswer(mCF.findOutCheckedId());
                    QuestionBank.fillUserAnswer(answer);
                    QuestionBank.incrementIndex();
                    if(QuestionBank.getQuestionNum()==QuestionBank.getQuestionIndex()) {
                        Intent intent = new Intent(getApplicationContext(), ScoreActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        mQF.updateQuestion(QuestionBank.getCurrentQuestion().getQuestionText());
                        Question q = QuestionBank.getCurrentQuestion();
                        mCF.setText(q.choices.get(0).toString(), q.choices.get(1).toString(), q.choices.get(2).toString(), q.choices.get(3).toString());
                    }
                }
            }

//            @Override
//            public void onNextClickRadioButton(boolean isClicked) {
//
//            }
        });
    }

}
