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

    public void message(String string) {
        Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
    }

    public void submitNum(View view) {

        // Client's # guess
        EditText inputNum = (EditText) findViewById(R.id.inputNum);
        int userNum = Integer.parseInt(inputNum.getText().toString());
        Log.i("num", inputNum.getText().toString());

        if (userNum >= 1 && userNum <= 100){

            if (randomNum > userNum) {
                message("Guess higher");
            } else if (randomNum < userNum) {
                message("Guess lower");
            } else {
                message("Correct! New Number has been set");
                Random rand = new Random();
                randomNum = rand.nextInt(100) + 1;
                Log.i("randoNum", "New random # is " + randomNum);
            }
        } else {
            message("Number needs to be between 1-100");
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
