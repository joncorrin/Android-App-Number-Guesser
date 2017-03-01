package com.joncorrin.tryapp;

import java.util.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int randomNum;

    public void submitNum(View view) {

        // Client's # guess
        EditText inputNum = (EditText) findViewById(R.id.inputNum);
        int userNum = Integer.parseInt(inputNum.getText().toString());
        Log.i("num", inputNum.getText().toString());

        if (userNum >= 1 && userNum <= 100){

            if (randomNum > userNum) {
                Toast.makeText(MainActivity.this, "Guess higher", Toast.LENGTH_SHORT).show();
            } else if (randomNum < userNum) {
                Toast.makeText(MainActivity.this, "Guess lower", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Correct! New Number has been set", Toast.LENGTH_LONG).show();
                Random rand = new Random();
                randomNum = rand.nextInt(100) + 1;
                Log.i("randoNum", "New random # is " + randomNum);
            }
        } else {
            Toast.makeText(MainActivity.this, "Number needs to be between 1-100", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Random # generated on app launch
        Random rand = new Random();
        randomNum = rand.nextInt(100) + 1;
        Log.i("randoNum", "Random # is " + randomNum);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
