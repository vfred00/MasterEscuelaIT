package Mastermind;

import java.util.Arrays;

public class Board {

    private Attempt[] attempts;
    private Secret secret;
    private Proposed proposed;

    public Board(){
        attempts = new Attempt[10];
        secret.getRandom();
        for (int i = 0; i < 10; i++){ //pendiente de hacer con lambdas
            attempts[i] = null;
        }
    }

    public void show(){
        System.out.println(howManyAttempts() + " attempt(s):");
        secret.getAsterisks();
        proposed.setCombination();
    }



    public int howManyAttempts(){
        int count = 0;
        for (int i = 0; i < attempts.length; i++){
            if (attempts[i] != null){
                count++;
            }
        }
        return count;
    }

}
