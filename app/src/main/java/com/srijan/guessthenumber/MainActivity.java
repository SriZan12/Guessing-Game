package com.srijan.guessthenumber;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView result,rightanswer,remainingChances,replay;
    Button guess;
    EditText inputNumber;
    LinearLayout layout;
    ImageView imageView;
    int chances = 3;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textView2);
        rightanswer = findViewById(R.id.textView3);
        guess = findViewById(R.id.guess);
        inputNumber = findViewById(R.id.inputNumber);
        remainingChances = findViewById(R.id.remains);
        layout = findViewById(R.id.linearlayout);
        imageView = findViewById(R.id.restart);
        replay = findViewById(R.id.replay);


            Random random = new Random();

            int randomNumber ;
            randomNumber = random.nextInt(20);

                guess.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(View view) {

                        if(chances == 0){
                            Toast.makeText(MainActivity.this, "No Remaining Chances", Toast.LENGTH_SHORT).show();
                        }

                        if(chances > 0) {
                            String guessedNumber = inputNumber.getText().toString();
                            int number = Integer.parseInt(guessedNumber);
                            if (randomNumber == number) {
                                result.setText("You Win !");
                                rightanswer.setText("Right answer : " + randomNumber);
                                inputNumber.setText("");

                                imageView.setImageResource(R.drawable.ic_baseline_refresh_24);
                                replay.setText("Tap to play Again");

                            } else if (randomNumber < number) {
                                result.setText("Guess lesser than this !");
                                inputNumber.setText("");
                            } else {
                                result.setText("Guess Higher than this !");
                                inputNumber.setText("");
                            }

                            chances--;

                            if(randomNumber == number) {
                                chances = 0;
                                remainingChances.setText("Remaining Chances : " + chances);
                            }
                            else {
                                remainingChances.setText("Remaining chances : " + chances);

                                if(chances == 0){
                                    rightanswer.setText("Right Answer was = " + randomNumber);
                                    result.setText("You Lose !");
                                    Toast.makeText(MainActivity.this, "No Remaining Chances", Toast.LENGTH_SHORT).show();

                                    imageView.setImageResource(R.drawable.ic_baseline_refresh_24);
                                    replay.setText("Tap to play Again");
                                }
                            }
                        }
                    }
                });

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        remainingChances.setText("Remaining chances : " + chances);

                         int randomNumber = random.nextInt(20);

                        chances = 3;
                        inputNumber.setText("");
                        rightanswer.setText("");
                        result.setText("");
                        remainingChances.setText("");

                        replay.setText("");
                        imageView.setImageResource(0);

                        guess.setOnClickListener(new View.OnClickListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onClick(View view) {

                                if(chances > 0) {
                                    String guessedNumber = inputNumber.getText().toString();
                                    int number = Integer.parseInt(guessedNumber);
                                    if (randomNumber == number) {
                                        result.setText("You Win !");
                                        rightanswer.setText("Right answer : " + randomNumber);
                                        inputNumber.setText("");

                                        imageView.setImageResource(R.drawable.ic_baseline_refresh_24);
                                        replay.setText("Tap to play Again");

                                    } else if (randomNumber < number) {
                                        result.setText("Guess lesser than this !");
                                        inputNumber.setText("");
                                    } else {
                                        result.setText("Guess Higher than this !");
                                        inputNumber.setText("");
                                    }

                                    chances--;

                                    if(randomNumber == number) {
                                        chances = 0;
                                        remainingChances.setText("Remaining Chances = " + chances);
                                    }
                                    else {
                                        remainingChances.setText("Remaining chances : " + chances);

                                        if(chances == 0){
                                            rightanswer.setText("Right Answer was = " + randomNumber);
                                            result.setText("You Lose !");
                                            Toast.makeText(MainActivity.this, "No Remaining Chances", Toast.LENGTH_SHORT).show();

                                            imageView.setImageResource(R.drawable.ic_baseline_refresh_24);
                                            replay.setText("Tap to play Again");
                                        }
                                    }
                                }
                            }
                        });

                    }
                });




    }

    public void onBackPressed(){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Really Exit !")
                .setMessage("Are You Sure You want to Exit")
                .setPositiveButton(R.string.Yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })

                .setNegativeButton(R.string.No, null)
                .setIcon(R.drawable.ic_baseline_exit_to_app_24)
                .show();
    }

}