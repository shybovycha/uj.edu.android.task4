package edu.uj.android.task4;

import android.graphics.drawable.Drawable;

/**
 * Created by shybovycha on 27.10.14.
 */
public class Answer {
    protected String text;
    protected Drawable image;
    protected boolean isCorrect;

    public Answer(String text, Drawable image, boolean isCorrect) {
        this.text = text;
        this.image = image;
        this.isCorrect = isCorrect;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
}
