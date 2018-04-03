package com.rjt.android.androidquiz;

import java.util.ArrayList;

public class QuestionBank {
    private static ArrayList<Question> androidQues;
    private static QuestionBank singletonBank;
    private static ArrayList<String> userAnswers;

    public static int getQuestionIndex() {
        return questionIndex;
    }
    private static int questionIndex;
    private QuestionBank(){}
    public static ArrayList<Question> getQuestionBank(){
        return androidQues;
    }
    public static void incrementIndex() {questionIndex++;}
    public static int getQuestionNum() {return androidQues.size(); }
    public static QuestionBank getSingletonBank(){
        if(null == singletonBank) {
            androidQues = new ArrayList<Question>();
            singletonBank = new QuestionBank();
            userAnswers = new ArrayList<>();
            questionIndex = 0;
            try {
                String[] questions = SplashActivity.mResources.getStringArray(SplashActivity.android_questions);
                String[] answers = SplashActivity.mResources.getStringArray(SplashActivity.android_answers);
                String[] choices = SplashActivity.mResources.getStringArray(SplashActivity.android_choices);
                for(int i = 0; i < questions.length; i++){
                    int index = 4*i;
                    Question q = new Question(questions[i], answers[i], choices[index], choices[index+1], choices[index+2], choices[index+3]);
                    androidQues.add(q);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return singletonBank;
    }

    public static void fillUserAnswer(String answer){
        userAnswers.add(answer);
    }

    public static Question getCurrentQuestion(){
        return androidQues.get(questionIndex);
    }
    public static boolean[] checkAnswers(){
        boolean[] result = new boolean[androidQues.size()];
        for(int i = 0; i < androidQues.size(); i++){
            result[i] = (userAnswers.get(i).equals(androidQues.get(i).getAnswer()));
        }
        return result;
    }
}
