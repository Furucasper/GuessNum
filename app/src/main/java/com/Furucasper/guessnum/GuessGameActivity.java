package com.Furucasper.guessnum;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GuessGameActivity extends AppCompatActivity {
    static int n,h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_game);
        final Button guess = findViewById(R.id.guessButton);
        final Button hint = findViewById(R.id.hintButton);
        final EditText inGuess = findViewById(R.id.guessEdt);
        final TextView show = findViewById(R.id.showText);
        final TextView count = findViewById(R.id.guessCount);
        final GuessGame random = new GuessGame();
        guess.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String checknum = inGuess.getText().toString();
                if(checknum.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter a number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (checknum.length()<=3){
                    int num = Integer.parseInt(checknum);
                    if (num>=1&&num<=100){
                        String x = random.Guess(num);
                        if (x.equals("You won!")){
                            n++;
                            count.setText("");
                            startActivity(new Intent(GuessGameActivity.this,WonActivity.class));
                            inGuess.setText("");
                            finish();
                        }else {
                            n++;
                            show.setText(x);
                            count.setText(Integer.toString(n));
                            inGuess.setText("");

                        }
                    }else {
                        Toast.makeText(getApplicationContext(), "Number is not correct, input again.", Toast.LENGTH_SHORT).show();
                        inGuess.setText("");
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Number is not correct, input again.", Toast.LENGTH_SHORT).show();
                    inGuess.setText("");
                }
            }
        });

        hint.setOnClickListener(new View.OnClickListener() {
            int i = 0;
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                h++;
                if (i==0){
                    hint.setText(random.getHint());
                    i+=1;
                }else {
                    hint.setText("hint");
                    i=0;
                }

            }
        });

        inGuess.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    //do what you want on the press of 'done'
                    guess.performClick();
                }
                return false;
            }
        });
    }
}
