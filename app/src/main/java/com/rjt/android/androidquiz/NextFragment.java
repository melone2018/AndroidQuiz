package com.rjt.android.androidquiz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class NextFragment extends Fragment {
    private Button nextBtn;
  //  private OnNextFragmentInteractionListener mListener;
    private static String NEXT_PRESSED_KEY = "NEXT_PRESSED";
    public NextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_next, container, false);
        nextBtn = v.findViewById(R.id.questionNxt);
        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                QuestionBank.incrementIndex();
                Bundle choiceBundle = getArguments();
                if(choiceBundle!=null){
                    String userAnswer = choiceBundle.getString(ChoiceFragment.getRadioButtonKey());

                    QuestionBank.fillUserAnswer(userAnswer);
                }
                if(QuestionBank.getQuestionNum()==QuestionBank.getQuestionIndex()){
                    Intent intent = new Intent(getActivity(), ScoreActivity.class);
                    startActivity(intent);
                }
//                Bundle questionUpdateBundle = new Bundle();
//                questionUpdateBundle.putString(NEXT_PRESSED_KEY, true);
//                FragmentTransaction fgt = getActivity().getSupportFragmentManager().beginTransaction();
//                QuestionFragment questionFragment = new QuestionFragment();
//                questionFragment.setArguments();

            }

        });
        return v;
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnNextFragmentInteractionListener) {
//            mListener = (OnNextFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
       // mListener = null;
    }

}
