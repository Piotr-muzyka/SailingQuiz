package com.example.android.sailingquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    Button b1;
    Switch s1;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        s1 = (Switch) findViewById(R.id.switch2);
        b1 = (Button) findViewById(R.id.button2);

        s1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                Toast.makeText(MainActivity.this, "Time is ticking!",
                        Toast.LENGTH_LONG).show();


                Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                MainActivity.this.startActivity(myIntent);

            }
        });
    }
    public void scores (View view) {

        RadioButton answer1 = (RadioButton) findViewById(R.id.radio1);
        Boolean firstIsCorrect = answer1.isChecked();
        if (firstIsCorrect) { score ++; }

//        EditText answer2 = (EditText) findViewById(R.id.question_2_answer);
//        String secondIsCorrect = answer2.getText().toString();
//        if (secondIsCorrect.equals("241")) {userScore ++;}


        CheckBox answer3_1 = (CheckBox) findViewById(R.id.question_3_correct);
        Boolean thirdCorrect1 = answer3_1.isChecked();
        if (thirdCorrect1) {userScore ++;}


        if (firstIsCorrect) { score++;

            if(score <=4){
                Toast.makeText(this, "You have scored " + score + " out of 8 points, keep on working", Toast.LENGTH_LONG).show();

            }
            else {
                Toast.makeText(this, "You have scored " + score + " out of 8 points, good job ! ", Toast.LENGTH_LONG).show();
            }


            score = 0;
        }
    }




}
