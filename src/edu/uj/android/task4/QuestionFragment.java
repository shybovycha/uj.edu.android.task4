package edu.uj.android.task4;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by shybovycha on 27.10.14.
 */
public class QuestionFragment extends Fragment implements AnswerFragment.OnAnswerSelectedListener {
    public interface OnQuestionAnsweredListener {
        public void onQuestionAnswered(boolean isCorrect);
    }

    protected OnQuestionAnsweredListener questionListener;
    protected String questionText;
    protected int questionNumber;
    protected int correctIndex;

    public QuestionFragment() {
        super();
    }

    @SuppressLint("ValidFragment")
    public QuestionFragment(int questionNumber, String questionText, int correctIndex) {
        this.questionText = questionText;
        this.questionNumber = questionNumber;
        this.correctIndex = correctIndex;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.question_fragment, container, false);

        ((TextView) v.findViewById(R.id.question_number)).setText(String.format("%d", questionNumber));
        ((TextView) v.findViewById(R.id.question_text)).setText(questionText);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        List<Integer> drawables = new ArrayList<Integer>();

        drawables.add(R.drawable.ic_launcher_appwidget);
        drawables.add(R.drawable.ic_launcher_home);
        drawables.add(R.drawable.ic_launcher_wallpaper);
        drawables.add(R.drawable.ic_search_widget);

        int answerCount = drawables.size();

        for (int i = 0; i < answerCount; i++) {
            boolean isCorrect = (i == this.correctIndex);
            Integer drawableId = drawables.get(i);

            AnswerFragment fragment = new AnswerFragment(v.getResources().getDrawable(drawableId), isCorrect);
            fragmentTransaction.add(R.id.answers_container, fragment);
        }

        fragmentTransaction.commit();

        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            this.questionListener = (OnQuestionAnsweredListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnAnswerSelectedListener");
        }
    }

    @Override
    public void onAnswerSelected(boolean isCorrect) {
        questionListener.onQuestionAnswered(isCorrect);
    }
}