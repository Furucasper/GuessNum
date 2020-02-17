package com.Furucasper.guessnum;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_game);
        final Button guess = findViewById(R.id.guessButton);
        final Button hint = findViewById(R.id.hintButton);
        final EditText inGuess = findViewById(R.id.guessEdt);
        final TextView show = findViewById(R.id.showText);
        final GuessGame random = new GuessGame();
        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String checknum = inGuess.getText().toString();
                if (checknum.length()<=3&&checknum.length()!=0){
                    int num = Integer.parseInt(checknum);
                    if (num>1&&num<=100){
                        String x = random.Guess(num);
                        if (x == "You won!"){
                            startActivity(new Intent(GuessGameActivity.this,WonActivity.class));
                            inGuess.setText("");
                            finish();
                        }else {
                            show.setText(x);
                            inGuess.setText("");

                        }
                    }else {
                        Toast.makeText(getApplicationContext(), "Number not correct, input again.", Toast.LENGTH_SHORT).show();
                        inGuess.setText("");
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Number not correct, input again.", Toast.LENGTH_SHORT).show();
                    inGuess.setText("");
                }
            }
        });
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hint.setText(""+random.getHint());
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
