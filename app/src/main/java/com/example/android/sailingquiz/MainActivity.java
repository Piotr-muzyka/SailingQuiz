package com.example.android.sailingquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox ch1,ch2;
    Button b1,b2;
    Switch s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ch1=(CheckBox)findViewById(R.id.checkBox);
        ch2=(CheckBox)findViewById(R.id.checkBox2);
        s1=(Switch)findViewById(R.id.switch1);
        b1=(Button)findViewById(R.id.button);

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
                result.append("Thanks : ").append(ch1.isChecked());
                result.append("\nThanks: ").append(ch2.isChecked());
                Toast.makeText(MainActivity.this, result.toString(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}
