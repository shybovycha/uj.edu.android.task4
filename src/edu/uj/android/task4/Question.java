package edu.uj.android.task4;

import android.graphics.drawable.Drawable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shybovycha on 27.10.14.
 */
public class Question implements Serializable {
    protected String text;
    protected List<Answer> answers;

    public Question(String text) {
        this.text = text;
        this.answers = new ArrayList<Answer>();
    }

    public void addAnswer(Drawable image, boolean isCorrect) {
        Answer a = new Answer(image, isCorrect);
        answers.add(a);
    }

    public boolean isCorrect(int index) {
        if (index < 0 || index >= answers.size()) {
            return false;
        }

        return answers.get(index).isCorrect();
    }

    public void shuffleAnswers() {
        Collections.shuffle(answers);
    }

    public String getText() {
        return text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
