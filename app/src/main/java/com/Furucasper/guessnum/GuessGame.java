package com.Furucasper.guessnum;

import java.util.Random;

class GuessGame {
    private final int ranNum;
    GuessGame(){
        Random ran = new Random();
        ranNum = ran.nextInt(100)+1; //random a number 1-100
    }
    String Guess(int guess ){
        if (guess>ranNum){
            return "Your guess is too high";
        }else if (guess<ranNum){
            return "Your guess is too low";
        }else{
            return "You won!";
        }
    }

    //hint function
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