package com.Furucasper.guessnum;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WonActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);
        Button again = findViewById(R.id.playAgainButton);
        TextView countShow = findViewById(R.id.guessCountShow);

        if (GuessGameActivity.hintCatch==0){ //check hint catch
            countShow.setText("guessed "+GuessGameActivity.guessCounter+" times");
        }else{
            countShow.setText("guessed  "+GuessGameActivity.guessCounter+" times  &  used hint");
        }
        GuessGameActivity.hintCatch = 0; //reset hint catch
        GuessGameActivity.guessCounter = 0; //reset guess counter

        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
    }
}
