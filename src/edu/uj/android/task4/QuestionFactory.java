package edu.uj.android.task4;

import android.graphics.drawable.Drawable;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by shybovycha on 27.10.14.
 */
public class QuestionFactory {
    protected HashMap<String, Drawable> availableAnswers;
    protected Random rnd;

    public QuestionFactory() {
        rnd = new Random();
        availableAnswers = new HashMap<String, Drawable>();
    }

    public void addAnswer(String title, Drawable image) {
        availableAnswers.put(title, image);
    }

    public Question getQuestion(String title, String correctAnswer) {
        Question question = new Question(title);

        for (String key : availableAnswers.keySet()) {
            question.addAnswer(availableAnswers.get(key), (key.equals(correctAnswer)));
        }

        question.shuffleAnswers();

        return question;
    }
}
