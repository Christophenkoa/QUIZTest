package com.example.quizgame.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizgame.R;
import com.example.quizgame.model.Question;
import com.example.quizgame.model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements View.OnClickListener  {

    private Button mAnswer3;
    private TextView mQuestion;
    private Button mAnswer1;
    private Button mAnswer2;
    private Button mAnswer4;
    private int mScore;
    private int mNumberOfQuestion;

    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionBank = this.generateQuestions();

        mScore = 0;
        mNumberOfQuestion = 4;

        mQuestion = (TextView) findViewById(R.id.textView2);
        mAnswer1  = (Button) findViewById(R.id.button1);
        mAnswer2  = (Button) findViewById(R.id.button2);
        mAnswer3  = (Button) findViewById(R.id.button3);
        mAnswer4  = (Button) findViewById(R.id.button4);

        //Use the tag property to 'name' the buttons
        mAnswer1.setTag(0);
        mAnswer2.setTag(1);
        mAnswer3.setTag(2);
        mAnswer4.setTag(3);

        mAnswer1.setOnClickListener(this);
        mAnswer2.setOnClickListener(this);
        mAnswer3.setOnClickListener(this);
        mAnswer4.setOnClickListener(this);

        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);
    }

    @Override
    public void onClick(View v) {
        int responseIndex = (int) v.getTag();

        if(responseIndex == mCurrentQuestion.getAnswerIndex()) {
            //Good Answer
            Toast.makeText(this, "Correct answer", Toast.LENGTH_SHORT).show();
            mScore++;

        }else {
            //Wrong answer
            Toast.makeText(this, "Wrong answer", Toast.LENGTH_SHORT).show();
        }

        if(--mNumberOfQuestion == 0) {
            //finish
            endGame();
        }else {
            mCurrentQuestion = mQuestionBank.getQuestion();
            displayQuestion(mCurrentQuestion);
        }
    }

    private void endGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Well done")
                .setMessage("Your score is "+mScore)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //end activity
                        finish();
                    }
                })
                .create()
                .show();
    }

    private void displayQuestion(final Question question) {
         mQuestion.setText(question.getQuestion());
         mAnswer1.setText(question.getChoiceList().get(0));
         mAnswer2.setText(question.getChoiceList().get(1));
         mAnswer3.setText(question.getChoiceList().get(2));
         mAnswer4.setText(question.getChoiceList().get(3));
     }

    private QuestionBank generateQuestions() {
        Question question1 = new Question("What is the name of the current cameroon president?",
                Arrays.asList("Cabral Libi" , "Hamadou Aidjo" , "Paul Biya" , "Maurice Kamto"),
                2);
        Question question2 = new Question("How many countries are there in Africa?",
                Arrays.asList("54" , "33" , "39" , "45"),
                0);
        Question question3 = new Question("Who is the creator of android os?",
                Arrays.asList("Andy Rubin" , "Steve Job" , "Bill Gate" , "Paul Smith"),
                0);
        Question question4 = new Question("When did the first man land on the moon?",
                Arrays.asList("1958" , "1962" , "1967" , "1969"),
                3);
        Question question5 = new Question("what is the capital of Ivory Coast?",
                Arrays.asList("Abidjan" , "Cotonou" , "Yamoussoukro" , "Accra"),
                2);
        Question question6 = new Question("which African country has the most African cup of nation?",
                Arrays.asList("Cameroon" , "Egypt" , "Tunisia" , "Ghana"),
                1);
        Question question7 = new Question("What is the highest mountain in the world?",
                Arrays.asList("Mount Cameroon" , "Everest mountain" , "Kilimandjaro mountain" , "Aconcagua Mountain"),
                1);
        Question question8 = new Question("The first world war lasted how long?",
                Arrays.asList("5" , "7" , "4" , "6"),
                2);
        Question question9 = new Question("which country has the most world cup of nation?",
                Arrays.asList("Brasilia" , "French" , "Argentina" , "Spain"),
                0);

        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3,
                question4,
                question5,
                question6,
                question7,
                question8,
                question9));
    }

}