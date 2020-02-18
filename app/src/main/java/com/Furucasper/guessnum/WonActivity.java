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
        if (GuessGameActivity.h==0){
            countShow.setText("guessed "+GuessGameActivity.n+" times");
        }else{
            countShow.setText("guessed  "+GuessGameActivity.n+" times  &  used hint");
        }
        GuessGameActivity.h = 0;
        GuessGameActivity.n = 0;
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
    }
}
