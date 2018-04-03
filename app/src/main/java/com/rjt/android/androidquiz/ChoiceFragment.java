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
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            Bundle radioBtnBundle = new Bundle();

            @Override
            public void onCheckedChanged(RadioGroup group, int checkId) {
                //switch (checkId) {
                RadioButton radioButton = (RadioButton) mView.findViewById(checkId);
                radioBtnBundle.putString(RADIO_BUTTON_KEY, radioButton.getText().toString());
                Log.d("ChoiceFragment", "Radio Button chosen");
//                    case R.id.RadioButtonChoiceA:
//                        Log.d("ChoiceFragment", "Radio Button A chosen");
//                        radioBtnBundle.putString(RADIO_BUTTON_KEY, ((RadioButton)findViewById(R.id.RadioButtonChoiceA)).getText().toString());
//
//                        // Pirates are the best
//                        break;
//                    case R.id.RadioButtonChoiceB:
//
//                        Log.d("ChoiceFragment", "Radio Button B chosen");
//                        radioBtnBundle.putString(RADIO_BUTTON_KEY, ((RadioButton) view).getText().toString());
//
//                        break;
//                    case R.id.RadioButtonChoiceC:
//
//                        Log.d("ChoiceFragment", "Radio Button C chosen");
//                        radioBtnBundle.putString(RADIO_BUTTON_KEY, ((RadioButton) view).getText().toString());
//                        break;
//                    case R.id.RadioButtonChoiceD:
//
//                        Log.d("ChoiceFragment", "Radio Button D chosen");
//                        radioBtnBundle.putString(RADIO_BUTTON_KEY, ((RadioButton) view).getText().toString());
//
//                        break;
//                    default:
//                        break;
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        Bundle radioBtnBundle = new Bundle();

        switch (view.getId()) {
            case R.id.RadioButtonChoiceA:
                if (checked) {
                    Log.d("ChoiceFragment", "Radio Button A chosen");
                    radioBtnBundle.putString(RADIO_BUTTON_KEY, ((RadioButton) view).getText().toString());
                }
                // Pirates are the best
                break;
            case R.id.RadioButtonChoiceB:
                if (checked) {
                    Log.d("ChoiceFragment", "Radio Button B chosen");
                    radioBtnBundle.putString(RADIO_BUTTON_KEY, ((RadioButton) view).getText().toString());
                }
                // Ninjas rule
                break;
            case R.id.RadioButtonChoiceC:
                if (checked) {
                    Log.d("ChoiceFragment", "Radio Button C chosen");
                    radioBtnBundle.putString(RADIO_BUTTON_KEY, ((RadioButton) view).getText().toString());
                }
                break;
            case R.id.RadioButtonChoiceD:
                if (checked) {
                    Log.d("ChoiceFragment", "Radio Button D chosen");
                    radioBtnBundle.putString(RADIO_BUTTON_KEY, ((RadioButton) view).getText().toString());
                }
                break;
            default:
                break;
        }
        if (checked) {
            this.setArguments(radioBtnBundle);
            getFragmentManager().beginTransaction().replace(R.id.fragmentChoice, this);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnChoiceFragmentInteractionListener) {
//            mListener = (OnChoiceFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
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

    public void setText(String question1, String question2, String question3, String question4) {
        ((RadioButton) mRadioGroup.getChildAt(0)).setText(question1);
        ((RadioButton) mRadioGroup.getChildAt(1)).setText(question2);
        ((RadioButton) mRadioGroup.getChildAt(2)).setText(question3);
        ((RadioButton) mRadioGroup.getChildAt(3)).setText(question4);
    }
}
