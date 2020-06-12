package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private Button mAnswer3;
    private TextView mQuestion;
    private Button mAnswer1;
    private Button mAnswer2;
    private Button mAnswer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestion = findViewById(R.id.textView2);
        mAnswer1  =  findViewById(R.id.button1);
        mAnswer2  = findViewById(R.id.button2);
        mAnswer3  = findViewById(R.id.button3);
        mAnswer4  = findViewById(R.id.button4);

    }
}