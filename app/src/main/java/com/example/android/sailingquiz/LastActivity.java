package com.example.android.sailingquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by PiotrM on 01.04.2017.
 */

public class LastActivity extends AppCompatActivity {
    int score;
    CheckBox ch1, ch2;
    Button b1;
    Switch s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4);
        Intent myIntent = getIntent();
        score = myIntent.getExtras().getInt("score");

        ch1 = (CheckBox) findViewById(R.id.checkBox);
        ch2 = (CheckBox) findViewById(R.id.checkBox2);
        s1 = (Switch) findViewById(R.id.switch1);
        b1 = (Button) findViewById(R.id.button);

        new CountDownTimer(60000, 1000) {
            TextView textView2 = (TextView) findViewById(R.id.textView2);

            public void onTick(long millisUntilFinished) {
                textView2.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                textView2.setText("DONE!");
                Intent myIntent = new Intent(LastActivity.this, MainActivity.class);
                LastActivity.this.startActivity(myIntent);
                Toast.makeText(LastActivity.this, "Time is up !",
                        Toast.LENGTH_LONG).show();
                userScores ();
                finish();
            }
        }.start();

        s1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                userScores ();
                finish();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                userScores();
                Intent myIntent = new Intent(LastActivity.this, MainActivity.class);
                myIntent.putExtra("score", score); //Optional parameters
                LastActivity.this.startActivity(myIntent);
                finish();
            }
        });
    }
    public void userScores () {

        EditText answer = (EditText) findViewById(R.id.edit);
        String correctAnswer = answer.getText().toString();
        if (correctAnswer.equals("Halyard") || correctAnswer.equals("halyard") ) {score ++;}

        EditText answer2 = (EditText) findViewById(R.id.edit2);
        String correctAnswer2 = answer2.getText().toString();
        if (correctAnswer2.equals("Apparent") || correctAnswer2.equals("apparent") ) {score ++;}

        EditText answer3 = (EditText) findViewById(R.id.edit3);
        String correctAnswer3 = answer3.getText().toString();
        if (correctAnswer3.equals("Pulpit") || correctAnswer3.equals("pulpit") ) {score ++;}


        if(score <=3){
            Toast.makeText(this, "You have scored " + score + " out of 7 points, keep on working", Toast.LENGTH_LONG).show();

        }
        else {
            Toast.makeText(this, "You have scored " + score + " out of 7 points, good job ! ", Toast.LENGTH_LONG).show();
        }


        score = 0;
    }
}
