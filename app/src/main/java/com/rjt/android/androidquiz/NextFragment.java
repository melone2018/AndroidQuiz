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
    private OnNextClickListener mOnNextClickListener;
    public NextFragment() {
        // Required empty public constructor
    }

    public void setOnNextListener(OnNextClickListener onNextClickListener){
        this.mOnNextClickListener = onNextClickListener;
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
                //QuestionBank.incrementIndex();
//                if(QuestionBank.getQuestionNum()==QuestionBank.getQuestionIndex()){
//                    Intent intent = new Intent(getActivity(), ScoreActivity.class);
//                    startActivity(intent);
//                }else {
                    mOnNextClickListener.onNextClick(true);
                    //mOnNextClickListener.onNextClickRadioButton(true);
               // }
            }

        });
        return v;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
