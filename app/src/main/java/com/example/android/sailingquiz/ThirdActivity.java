package com.example.android.sailingquiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by PiotrM on 01.04.2017.
 */

public class ThirdActivity extends AppCompatActivity {
    int score;
    CheckBox ch1, ch2;
    Button b1;
    Switch s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
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
                Intent myIntent = new Intent(ThirdActivity.this, LastActivity.class);
                ThirdActivity.this.startActivity(myIntent);
                Toast.makeText(ThirdActivity.this, "Time is up !",
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
                Intent myIntent = new Intent(ThirdActivity.this, LastActivity.class);
                myIntent.putExtra("score", score); //Optional parameters
                ThirdActivity.this.startActivity(myIntent);
                finish();
            }
        });
    }
    public void userScores () {

        RadioButton answer2 = (RadioButton) findViewById(R.id.radioButton2);
        Boolean correctAnswer = answer2.isChecked();
        if (correctAnswer) {
            score++;}

        CheckBox answer1 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox answer3 = (CheckBox) findViewById(R.id.checkBox6);
        Boolean correctAnswer2 = answer1.isChecked();
        Boolean correctAnswer3 = answer3.isChecked();
        if (correctAnswer2 && correctAnswer3) {
            score++;}

    }
}
