package com.rjt.android.androidquiz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NextFragment.OnNextFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class NextFragment extends Fragment {
    private Button nextBtn;
    private boolean nextPressed;
    private OnNextFragmentInteractionListener mListener;

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

                QuizActivity quizActivity = (QuizActivity)getActivity();
                ChoiceFragment cfg = (ChoiceFragment)(getFragmentManager().findFragmentByTag(quizActivity.getQChoiceKey()));
                String answer = cfg.get
                if(QuestionBank.getQuestionNum()==QuestionBank.getQuestionIndex()){
                    Intent intent = new Intent(getActivity(), ScoreActivity.class);
                    startActivity(intent);
                }
            }

        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNextFragmentInteractionListener) {
            mListener = (OnNextFragmentInteractionListener) context;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnNextFragmentInteractionListener {
        // TODO: Update argument type and name
        void onNextFragmentInteraction(Uri uri);
    }
}
