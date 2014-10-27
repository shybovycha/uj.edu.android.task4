package edu.uj.android.task4;

import android.graphics.drawable.Drawable;

import java.util.List;

/**
 * Created by shybovycha on 27.10.14.
 */
public class Question {
    protected String text;
    protected List<Answer> answers;

    public Question(String text) {
        this.text = text;
    }

    public void addAnswer(String text, Drawable image, boolean isCorrect) {
        Answer a = new Answer(text, image, isCorrect);
        answers.add(a);
    }

    public boolean check(int index) {
        if (index < 0 || index >= answers.size()) {
            return false;
        }

        return answers.get(index).isCorrect();
    }
}
