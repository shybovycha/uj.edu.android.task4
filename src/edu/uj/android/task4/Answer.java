package edu.uj.android.task4;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by shybovycha on 27.10.14.
 */
public class Answer implements Serializable {
    protected Drawable image;
    protected boolean isCorrect;

    public Answer(Drawable image, boolean isCorrect) {
        this.image = image;
        this.isCorrect = isCorrect;
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
