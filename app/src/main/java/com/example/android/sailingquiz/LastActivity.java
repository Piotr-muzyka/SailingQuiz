package com.example.android.sailingquiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by PiotrM on 01.04.2017.
 */

public class LastActivity extends AppCompatActivity {
    int score;
    long remainingTime;

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4);
        Intent myIntent = getIntent();
        score = myIntent.getExtras().getInt("score");
        remainingTime = myIntent.getExtras().getLong("time");

        b1 = (Button) findViewById(R.id.confirmButton3);

        final CountDownTimer finalCountdown = new CountDownTimer(remainingTime, 1000) {
            TextView textView2 = (TextView) findViewById(R.id.time3);

            public void onTick(long millisUntilFinished) {
                textView2.setText(getString(R.string.secondsText) + millisUntilFinished / 1000);
            }

            public void onFinish() {
                textView2.setText(R.string.done);
                Intent myIntent = new Intent(LastActivity.this, MainActivity.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                LastActivity.this.startActivity(myIntent);
                Toast.makeText(LastActivity.this, R.string.toast,
                        Toast.LENGTH_LONG).show();
                userScores();
                result();
                finish();
            }
        }.start();


        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finalCountdown.cancel();
                userScores();
                Intent myIntent = new Intent(LastActivity.this, MainActivity.class);
                myIntent.putExtra("score", score); //Optional parameters
                LastActivity.this.startActivity(myIntent);
                result();
                finish();

            }
        });
    }

    public void userScores() {

        EditText answer = (EditText) findViewById(R.id.question5edit1);
        String correctAnswer = answer.getText().toString();
        if (correctAnswer.equals(getString(R.string.textAnswer5)) || correctAnswer.equals(getString(R.string.textAnswer5A))) {
            score++;
        }

        EditText answer2 = (EditText) findViewById(R.id.question6edit1);
        String correctAnswer2 = answer2.getText().toString();
        if (correctAnswer2.equals(getString(R.string.textAnswer6)) || correctAnswer2.equals(getString(R.string.textAnswer6A))) {
            score++;
        }

        EditText answer3 = (EditText) findViewById(R.id.question7edit1);
        String correctAnswer3 = answer3.getText().toString();
        if (correctAnswer3.equals(getString(R.string.textAnswer7)) || correctAnswer3.equals(getString(R.string.textAnswer7A))) {
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
