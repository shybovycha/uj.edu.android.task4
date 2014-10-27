package edu.uj.android.task4;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity implements QuestionFragment.OnQuestionAnsweredListener, AnswerFragment.OnAnswerSelectedListener {
    protected int correctAnswers;
    protected int currentQuestion;
    protected List<QuestionFragment> questionFragments;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        setupQuestions();

        nextQuestion();
    }

    protected void setupQuestions() {
        correctAnswers = 0;
        currentQuestion = 0;

        questionFragments = new ArrayList<QuestionFragment>();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        QuestionFragment fragment = new QuestionFragment(1, "Where's HOME?", 1);
        questionFragments.add(fragment);

        fragment = new QuestionFragment(1, "Where's GOOGLE?", 3);
        questionFragments.add(fragment);

        fragment = new QuestionFragment(1, "Where's IMAGE?", 2);
        questionFragments.add(fragment);

        fragmentTransaction.commit();
    }

    @Override
    public void onQuestionAnswered(boolean isCorrect) {
        if (isCorrect) {
            correctAnswers++;
        }

        nextQuestion();
    }

    protected void nextQuestion() {
        if (currentQuestion >= questionFragments.size()) {
            // TODO
            return;
        }

        currentQuestion++;

        QuestionFragment fragment = questionFragments.get(currentQuestion);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        transaction.replace(R.id.question_container, fragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }

    @Override
    public void onAnswerSelected(boolean isCorrect) {
        // null
    }
}
