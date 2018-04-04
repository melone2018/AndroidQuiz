package com.rjt.android.androidquiz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 */
public class ChoiceFragment extends Fragment {
    View mView;

    public static String getRadioButtonKey() {
        return RADIO_BUTTON_KEY;
    }

    private static String RADIO_BUTTON_KEY = "BUTTON_CLICKED";
    private int mCurrentIndex;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton;
//    private OnChoiceFragmentInteractionListener mListener;

    public ChoiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_choice, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRadioGroup = mView.findViewById(R.id.RadioGroupChoice);
        mCurrentIndex = 0;
        //set up choice data
        String[] initialChoices = getArguments().getStringArray("InitialChoices");
        setText(initialChoices[0], initialChoices[1], initialChoices[2], initialChoices[3]);
        NextFragment myNextFragment = (NextFragment) getFragmentManager().findFragmentByTag(QuizActivity.getQNextKey());
        myNextFragment.setOnNextListener(new OnNextClickListener() {
            @Override
            public void onNextClick(boolean isClick) {

            }

            @Override
            public void onNextClickRadioButton(boolean isClicked)
            {
                mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
                {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkId) {
                        RadioButton radioButton = group.findViewById(checkId);
                        String chosenAnswer = radioButton.getText().toString();
                        QuestionBank.fillUserAnswer(chosenAnswer);
                    }
                });

            }
        });

    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

    public void setText(String question1, String question2, String question3, String question4) {
        //mRadioGroup.clearCheck();
        ((RadioButton) mRadioGroup.getChildAt(0)).setText(question1);
        ((RadioButton) mRadioGroup.getChildAt(1)).setText(question2);
        ((RadioButton) mRadioGroup.getChildAt(2)).setText(question3);
        ((RadioButton) mRadioGroup.getChildAt(3)).setText(question4);
        mRadioGroup.clearCheck();

    }
}
