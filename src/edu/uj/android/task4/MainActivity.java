package edu.uj.android.task4;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements QuestionFragment.OnQuestionAnsweredListener {
    protected int correctAnswers;
    protected int currentQuestion;
    protected List<Question> questions;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        setupQuestions();
        nextQuestion();
    }

    protected void setupQuestions() {
        correctAnswers = 0;
        currentQuestion = -1;

        questions = new ArrayList<Question>();

        QuestionFactory factory = new QuestionFactory();
        factory.addAnswer("cog", getResources().getDrawable(R.drawable.cog));
        factory.addAnswer("google", getResources().getDrawable(R.drawable.google));
        factory.addAnswer("home", getResources().getDrawable(R.drawable.home));
        factory.addAnswer("image", getResources().getDrawable(R.drawable.image));

        questions.add(factory.getQuestion("Where's HOME?", "home"));
        questions.add(factory.getQuestion("Where's GOOGLE?", "google"));
        questions.add(factory.getQuestion("Where's PICTURE?", "image"));
    }

    protected void nextQuestion() {
        if (currentQuestion >= questions.size() - 1) {
            // TODO
            Toast.makeText(this, String.format("Correct answers: %d out of %d", correctAnswers, questions.size()), Toast.LENGTH_LONG).show();
            return;
        }

        currentQuestion++;

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        QuestionFragment fragment = new QuestionFragment(currentQuestion, questions.get(currentQuestion));
        fragmentTransaction.replace(R.id.question_container, fragment);
        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }

    @Override
    public void onQuestionAnswered(boolean isCorrect) {
        correctAnswers++;
        nextQuestion();
    }
}
