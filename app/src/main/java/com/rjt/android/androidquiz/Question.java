package com.rjt.android.androidquiz;

import java.util.ArrayList;

public class Question {
    private String questionText;
    private String answer;
    ArrayList<StringBuilder> choices;
    public Question(String questionText, String answer, String choiceA, String choiceB, String choiceC, String choiceD) {
        this.questionText = questionText;
        this.answer = answer;
        choices = new ArrayList<>();
        choices.add(new StringBuilder(choiceA));
        choices.add(new StringBuilder(choiceB));
        choices.add(new StringBuilder(choiceC));
        choices.add(new StringBuilder(choiceD));
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public boolean checkAnswer(String givenAnswer){
        return givenAnswer.equals(answer);
    }
}
