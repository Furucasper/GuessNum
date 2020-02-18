package com.Furucasper.guessnum;

import java.lang.Math;

class GuessGame {
    private int ranNum;
    GuessGame(){
        ranNum =(int) Math.floor(Math.random() * Math.floor(100))+1;
    }
    String Guess(int guess ){
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

    String getHint(){ // hint is a range of random number ex. ranNum = 12 , hint : 11-15
        int y = ranNum/10;
        String x;
        if((ranNum%10)>5){
            x = (ranNum/10)+""+6+"-"+(((y+1)*10));
        }else if(ranNum%10==0){
            x = (ranNum-4)+"-"+ranNum;
        }else{
            x = (ranNum/10)+""+1+"-"+((y*10+1)+4);
        }
        return x;
    }
}