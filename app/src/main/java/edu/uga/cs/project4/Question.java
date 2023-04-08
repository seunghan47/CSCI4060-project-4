package edu.uga.cs.project4;
import java.util.concurrent.ThreadLocalRandom;

/**
 * POJO for question
 */
public class Question {

    public String[] Continents = {
            "North America", "South America",
            "Antarctica", "Australia", "Asia", "Europe", "Africa"};

    String[] answersGroup = new String[3];
    public String answer = "";
    public Country country = null;

    //Facilitates random continents in the questions
    public Question(Country country){
        this.country = country;

        String[] continentAnswers = new String[3];
        continentAnswers[0] = country.getContinent();
        int count = 1;

        while(count < 3){
            int continentVal = ThreadLocalRandom.current().nextInt(Continents.length);
            boolean a = false;
            for (int i = 0; i < continentAnswers.length; i++){
                if (continentAnswers[i] != null && continentAnswers[i].equals(Continents[continentVal])){
                    a = true;
                }
                if (a != true){
                    continentAnswers[count++] = Continents[continentVal];
                }
            }

            int random = ThreadLocalRandom.current().nextInt(answersGroup.length);

            answersGroup[random] = continentAnswers[0];
            answer = continentAnswers[0];

            if (random == 0){
                answersGroup[1] = continentAnswers[1];
                answersGroup[2] = continentAnswers[2];
            }
            if (random == 1){
                answersGroup[0] = continentAnswers[1];
                answersGroup[2] = continentAnswers[2];
            }

            if (random == 2){
                answersGroup[0] = continentAnswers[1];
                answersGroup[1] = continentAnswers[2];
            }
        }
    }

}
