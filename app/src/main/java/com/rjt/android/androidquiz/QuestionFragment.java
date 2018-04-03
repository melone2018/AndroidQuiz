package com.rjt.android.androidquiz;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class QuestionFragment extends Fragment {
    View mView;
    private TextView mQuestionView;
    //private OnQuestionFragmentInteractionListener mListener;
    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_question, container, false);

        mQuestionView = mView.findViewById(R.id.questionTv);

        Bundle qBundle = getArguments();

        mQuestionView.setText(qBundle.getString("InitialQuestion"));


        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mQuestionView = view.findViewById(R.id.TextViewquestion);
//        Bundle qBundle = getArguments();
//        mQuestionView.setText(qBundle.getString("InitialQuestion"));mQuestionView = view.findViewById(R.id.TextViewquestion);
//        Bundle qBundle = getArguments();
//        mQuestionView.setText(qBundle.getString("InitialQuestion"));
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnQuestionFragmentInteractionListener) {
//            mListener = (OnQuestionFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnQuestionFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
       // mListener = null;
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
//    public interface OnQuestionFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onQuestionFragmentInteraction(String questionText);
//    }

    public void updateQuestion(String question) {
        mQuestionView.setText(question);
    }
}
