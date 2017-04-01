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
                MainActivity.this.startActivity(myIntent);
                finish();

            }
        });
    }
}
