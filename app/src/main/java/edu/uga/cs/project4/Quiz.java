package edu.uga.cs.project4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Quiz {
    private Question [] questions;
    private String date;
    private int currScore;
    private int numQuestionsAnswered;

    List<Question> questionList = new ArrayList<>();


    public Quiz() {
        this.questions = new Question[6];
        this.date = null;
        this.currScore = -1;
        this.numQuestionsAnswered = -1;
    }

    public Quiz(CountriesData countriesData){
        int count = 0;
        String[] countries = new String[6];
        while(count < 6){
            int countryVal = ThreadLocalRandom.current().nextInt(countriesData.countries.size());
            boolean a = false;
            for (int i = 0; i < countries.length; i++){
                if (countries[i] != null && countries[i].equals(countriesData.countries.get(countryVal))){
                    a = true;
                }
            }

            if (a == false){
                countries[count++] = countriesData.countries.get(countryVal).toString();
                Question question = new Question(countriesData.countries.get(countryVal));
                questionList.add(question);
            }
        }
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
