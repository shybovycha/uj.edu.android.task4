package edu.uj.android.task4;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by shybovycha on 27.10.14.
 */
public class AnswerFragment extends Fragment {
    public interface OnAnswerSelectedListener {
        public void onAnswerSelected(boolean isCorrect);
    }

    protected Drawable image;
    protected boolean isCorrect;
    protected OnAnswerSelectedListener answerListener;

    public AnswerFragment() {
        super();
    }

    @SuppressLint("ValidFragment")
    public AnswerFragment(Drawable answerImage, boolean isCorrect) {
        super();

        this.image = answerImage;
        this.isCorrect = isCorrect;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.answer_fragment, container, false);
        ImageView answerImage = (ImageView) v.findViewById(R.id.answer_image);
        answerImage.setImageDrawable(image);

        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            this.answerListener = (OnAnswerSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnAnswerSelectedListener");
        }
    }

    public void onAnswerClicked() {
        answerListener.onAnswerSelected(this.isCorrect);
    }
}