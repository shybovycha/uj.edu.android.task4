package edu.uj.android.task4;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by shybovycha on 27.10.14.
 */
public class QuestionFragment extends Fragment {
    public interface OnQuestionAnsweredListener {
        public void onQuestionAnswered(boolean isCorrect);
    }

    protected OnQuestionAnsweredListener questionListener;
    protected Question question;
    protected int questionNumber;

    public QuestionFragment() {
        super();
    }

    @SuppressLint("ValidFragment")
    public QuestionFragment(int questionNumber, Question question) {
        this.question = question;
        this.questionNumber = questionNumber;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.question_fragment, container, false);

        ((TextView) v.findViewById(R.id.question_number)).setText(String.format("%d", questionNumber));
        ((TextView) v.findViewById(R.id.question_text)).setText(question.getText());

        ((ImageView) v.findViewById(R.id.answer0)).setImageDrawable(question.getAnswers().get(0).getImage());
        ((ImageView) v.findViewById(R.id.answer1)).setImageDrawable(question.getAnswers().get(1).getImage());
        ((ImageView) v.findViewById(R.id.answer2)).setImageDrawable(question.getAnswers().get(2).getImage());
        ((ImageView) v.findViewById(R.id.answer3)).setImageDrawable(question.getAnswers().get(3).getImage());

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int answerIndex = Integer.parseInt((String) view.getTag());

                questionListener.onQuestionAnswered(question.isCorrect(answerIndex));
            }
        };

        (v.findViewById(R.id.answer0)).setOnClickListener(clickListener);
        (v.findViewById(R.id.answer1)).setOnClickListener(clickListener);
        (v.findViewById(R.id.answer2)).setOnClickListener(clickListener);
        (v.findViewById(R.id.answer3)).setOnClickListener(clickListener);

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
}