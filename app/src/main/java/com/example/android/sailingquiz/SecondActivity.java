package com.example.android.sailingquiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity {

    Button b1;

    int score = 0;
    long remainingTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        b1 = (Button) findViewById(R.id.confirmButton1);

        final CountDownTimer finalCountdown = new CountDownTimer(10000, 1000) {
            TextView textView2 = (TextView) findViewById(R.id.time1);

            public void onTick(long millisUntilFinished) {
                textView2.setText(getString(R.string.secondsText) + millisUntilFinished / 1000);
                remainingTime = millisUntilFinished;
            }

            public void onFinish() {
                textView2.setText(R.string.done);
                Intent myIntent = new Intent(SecondActivity.this, MainActivity.class);
                Toast.makeText(SecondActivity.this, R.string.toast,
                        Toast.LENGTH_LONG).show();
                userScores();
                result();
                SecondActivity.this.startActivity(myIntent);
                finish();
            }
        }.start();

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finalCountdown.cancel();
                userScores();
                Intent myIntent = new Intent(SecondActivity.this, ThirdActivity.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                myIntent.putExtra("score", score); //Optional parameter for keeping score between activities.
                myIntent.putExtra("time", remainingTime); //Optional parameter for keeping time between activities.
                SecondActivity.this.startActivity(myIntent);
                finish();
            }
        });
    }

    public void userScores() {

        RadioButton answer1 = (RadioButton) findViewById(R.id.question1radio2);
        Boolean correctAnswer = answer1.isChecked();
        if (correctAnswer) {
            score++;
        }

        RadioButton answer2 = (RadioButton) findViewById(R.id.question2radio3);
        Boolean correctAnswer2 = answer2.isChecked();
        if (correctAnswer2) {
            score++;
        }
    }
    public void result(){
        if (score <= 3) {
            Toast.makeText(this, getString(R.string.scoredText) + " " + score + getString(R.string.pointsTotal), Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, getString(R.string.scoredText) + " " + score + getString(R.string.pointsTotalGood), Toast.LENGTH_LONG).show();
        }

    }
}
