package com.rjt.android.androidquiz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
    private int mCurrentIndex;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton;
    private OnChoiceFragmentInteractionListener mListener;

    public ChoiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_choice, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCurrentIndex = 0;
        mRadioGroup.addView(view.findViewById(R.id.RadioButtonChoiceA));
        mRadioGroup.addView(view.findViewById(R.id.RadioButtonChoiceB));
        mRadioGroup.addView(view.findViewById(R.id.RadioButtonChoiceC));
        mRadioGroup.addView(view.findViewById(R.id.RadioButtonChoiceD));

        //set up choice data
        String[] initialChoices = getArguments().getStringArray("InitialChoices");
        setText(initialChoices[0], initialChoices[1], initialChoices[2], initialChoices[3]);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.RadioButtonChoiceA:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.RadioButtonChoiceB:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.RadioButtonChoiceC:
                if(checked)
                    break;
            case R.id.RadioButtonChoiceD:
                if(checked)
                    break;
            default:
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnChoiceFragmentInteractionListener) {
            mListener = (OnChoiceFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnChoiceFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onChoiceFragmentInteraction(String choiceA, String choiceB, String choiceC, String choiceD);
//    }

    public void setText(String question1, String question2, String question3, String question4){
        ((RadioButton)mRadioGroup.getChildAt(0)).setText(question1);
        ((RadioButton)mRadioGroup.getChildAt(1)).setText(question2);
        ((RadioButton)mRadioGroup.getChildAt(2)).setText(question3);
        ((RadioButton)mRadioGroup.getChildAt(3)).setText(question4);
    }
}
