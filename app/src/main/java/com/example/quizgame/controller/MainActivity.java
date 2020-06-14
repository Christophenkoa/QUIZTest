package com.example.quizgame.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.quizgame.R;
import com.example.quizgame.model.User;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private EditText mNameInput;
    private Button mButton;
    private User mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUser = new User();

        mTextView = findViewById(R.id.textView);
        mNameInput = findViewById(R.id.textInputEditText);
        mButton = findViewById(R.id.button);

        mButton.setEnabled(false);

        enterPlayerName();

        playGame();

    }


    private void playGame() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = mNameInput.getText().toString();
                mUser.setFirstName(firstName);
                Intent intent = new Intent(MainActivity.this , GameActivity.class);
                startActivity(intent);
            }
        });
    }


    private void enterPlayerName() {
        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mButton.setEnabled(s.toString().length() !=0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}