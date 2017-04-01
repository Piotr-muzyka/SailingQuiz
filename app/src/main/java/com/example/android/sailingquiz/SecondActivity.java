package com.example.android.sailingquiz;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    CheckBox ch1,ch2;
    Button b1;
    Switch s1;
    int score = 0;

    public void shutdown (){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);


        ch1=(CheckBox)findViewById(R.id.checkBox);
        ch2=(CheckBox)findViewById(R.id.checkBox2);
        s1=(Switch)findViewById(R.id.switch1);
        b1=(Button)findViewById(R.id.button);

        new CountDownTimer(30000, 1000) {
            TextView textView2 = (TextView) findViewById(R.id.textView2);

            public void onTick(long millisUntilFinished) {
                textView2.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                textView2.setText("DONE!");
                Intent myIntent = new Intent(SecondActivity.this, MainActivity.class);
                SecondActivity.this.startActivity(myIntent);
                Toast.makeText(SecondActivity.this, "Time is up !",
                        Toast.LENGTH_LONG).show();
                userScores ();
                finish();
            }
        }.start();

        s1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                shutdown();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                userScores();
                Intent myIntent = new Intent(SecondActivity.this, ThirdActivity.class);
                myIntent.putExtra("score", score); //Optional parameters
                SecondActivity.this.startActivity(myIntent);
                finish();
            }
        });
    }
    public void userScores () {

        RadioButton answer1 = (RadioButton) findViewById(R.id.radio1);
        Boolean correctAnswer = answer1.isChecked();
        if (correctAnswer) { score ++; }

        RadioButton answer2 = (RadioButton) findViewById(R.id.radio5);
        Boolean correctAnswer2 = answer2.isChecked();
        if (correctAnswer2) {score ++;}

    }
}
