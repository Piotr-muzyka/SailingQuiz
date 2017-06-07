package com.example.android.sailingquiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by PiotrM on 01.04.2017.
 */

public class ThirdActivity extends AppCompatActivity {
    int score;
    long remainingTime;
    long remainingTime2;

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        Intent myIntent = getIntent();
        score = myIntent.getExtras().getInt("score");
        remainingTime = myIntent.getExtras().getLong("time");

        b1 = (Button) findViewById(R.id.confirmButton2);

        final CountDownTimer finalCountdown = new CountDownTimer(remainingTime, 1000) {
            TextView textView2 = (TextView) findViewById(R.id.time2);

            public void onTick(long millisUntilFinished) {
                textView2.setText(getString(R.string.secondsText) + millisUntilFinished / 1000);
                remainingTime2 = millisUntilFinished;
            }

            public void onFinish() {
                textView2.setText(R.string.done);
                Intent myIntent = new Intent(ThirdActivity.this, LastActivity.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Toast.makeText(ThirdActivity.this, R.string.toast,
                        Toast.LENGTH_LONG).show();
                userScores();
                ThirdActivity.this.startActivity(myIntent);
                finish();
            }
        }.start();

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finalCountdown.cancel();
                userScores();
                Intent myIntent = new Intent(ThirdActivity.this, LastActivity.class);
                myIntent.putExtra("score", score); //Optional parameters
                myIntent.putExtra("time", remainingTime2); //Optional parameters
                ThirdActivity.this.startActivity(myIntent);
                finish();
            }
        });
    }

    public void userScores() {

        RadioButton answer1 = (RadioButton) findViewById(R.id.question3radio2);
        Boolean correctAnswer = answer1.isChecked();
        if (correctAnswer) {
            score++;
        }

        CheckBox answer2 = (CheckBox) findViewById(R.id.question4checkBox1);
        CheckBox answer3 = (CheckBox) findViewById(R.id.question4checkBox4);
        CheckBox answer4 = (CheckBox) findViewById(R.id.question4checkBox2);
        CheckBox answer5 = (CheckBox) findViewById(R.id.question4checkBox3);
        Boolean correctAnswer2 = answer2.isChecked();
        Boolean correctAnswer3 = answer3.isChecked();
        Boolean wrongAnswer1 = answer4.isChecked();
        Boolean wrongAnswer2 = answer5.isChecked();

        if (correctAnswer2 && correctAnswer3 && !wrongAnswer1 && !wrongAnswer2) {
            score++;
        }

    }
}
