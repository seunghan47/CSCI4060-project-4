package edu.uga.cs.project4;

public class Quiz {
    private Question [] questions;
    private String date;
    private int currScore;
    private int numQuestionsAnswered;

    public Quiz() {
        this.questions = new Question[6];
        this.date = null;
        this.currScore = -1;
        this.numQuestionsAnswered = -1;
    }

    public Quiz(Question [] questions, String date, int currScore, int numQuestionsAnswered) {
        this.questions = questions;
        this.date = date;
        this.currScore = currScore;
        this.numQuestionsAnswered = numQuestionsAnswered;
    }

    public Question [] getQuestions() {
        return questions;
    }

    public void setQuestions(Question [] questions) {
        this.questions = questions;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCurrScore() {
        return currScore;
    }

    public void setCurrScore(int currScore) {
        this.currScore = currScore;
    }

    public int getNumQuestionsAnswered() {
        return numQuestionsAnswered;
    }

    public void setNumQuestionsAnswered(int numQuestionsAnswered) {
        this.numQuestionsAnswered = numQuestionsAnswered;
    }
}
