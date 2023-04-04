package edu.uga.cs.project4;

public class Question {
    private String country;
    private String correctContinent;
    private String wrongContinent1;
    private String wrongContinent2;

    public Question () {
        this.country = null;
        this.correctContinent = null;
        this.wrongContinent1 = null;
        this.wrongContinent2 = null;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCorrectContinent() {
        return correctContinent;
    }

    public void setCorrectContinent(String correctContinent) {
        this.correctContinent = correctContinent;
    }

    public String getWrongContinent1() {
        return wrongContinent1;
    }

    public void setWrongContinent1(String wrongContinent1) {
        this.wrongContinent1 = wrongContinent1;
    }

    public String getWrongContinent2() {
        return wrongContinent2;
    }

    public void setWrongContinent2(String wrongContinent2) {
        this.wrongContinent2 = wrongContinent2;
    }

}
