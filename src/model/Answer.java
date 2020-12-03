package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Simon Sperr
 * @version 2020.1.1, 02.12.2020
 **/
public class Answer{
    private ArrayList<String> posAnswers = new ArrayList<String>();
    private ArrayList<String> negAnswers = new ArrayList<String>();

    public Answer()
    {
        posAnswers.add("Auf jeden Fall!");
        posAnswers.add("Ja!");
        posAnswers.add("Aber sicher doch!");
        posAnswers.add("Das kann ich empfehlen!");
        posAnswers.add("Ich denke schon.");
        posAnswers.add("Wahrscheinlich schon.");
        posAnswers.add("Dazu kann ich dir raten.");
        posAnswers.add("Wenn du meinst.");
        posAnswers.add("Meiner Meinung nach ja!");
        posAnswers.add("Ich sage ja.");

        negAnswers.add("Nein");
        negAnswers.add("Sicher nicht!");
        negAnswers.add("Auf gar keinen Fall!");
        negAnswers.add("Ich denke nicht.");
        negAnswers.add("Das würde ich nicht tun.");
        negAnswers.add("Liebet nicht.");
        negAnswers.add("Das lässt du ganz schnell sein!");
        negAnswers.add("Am besten nicht.");
        negAnswers.add("Ich sage nein!");
        negAnswers.add("Nö");
    }

    public String getRandomAnswer(String question)
    {
        String answer = "";
        Random rnd = new Random();
        if(!question.contains("?"))
            answer = "Das ist keine Frage!";
        else if (question.contains("Software") || question.contains("liebt") || question.contains("Java") || question.contains("fertig"))
            answer = posAnswers.get(rnd.nextInt(posAnswers.size()));
        else if (question.contains("töten") || question.contains("Schule") || question.contains("essen") || question.contains("Drogen"))
            answer = negAnswers.get(rnd.nextInt(negAnswers.size()));
        else if (rnd.nextBoolean())
            answer = posAnswers.get(rnd.nextInt(posAnswers.size()));
        else
            answer = negAnswers.get(rnd.nextInt(negAnswers.size()));

        return answer;
    }

    public void addNegAnswer(String answer) {
        this.negAnswers.add(answer);
    }
    public void addPosAnswer(String answer) {
        this.posAnswers.add(answer);
    }
}
