package com.Furucasper.guessnum;

import java.lang.Math;
class GuessGame {
    private int ranNum;
    public GuessGame(){
        ranNum =(int) Math.floor(Math.random() * Math.floor(100))+1;
    }
    public String Guess(int guess ){
        String checkshow;
        if (guess>ranNum){
            checkshow = "Your guess is too high";
        }else if (guess<ranNum){
            checkshow = "Your guess is too low";
        }else{
            checkshow = "You won!";
        }
        return checkshow;
    }
    public int getHint(){
        return ranNum;
    }
}