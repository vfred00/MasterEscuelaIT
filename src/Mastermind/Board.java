package Mastermind;

import java.util.Arrays;

public class Board {

    private Result[] results;
    private Secret secret;
    private Proposed proposed;
    private int countResults;
    private boolean win;

    public Board(){
        results = new Result[10];
    }

    public void show(){
        do {
            IO.getInstance().printText(countResults + " attempt(s):");
            //secret.show(); //for trace purpose only
            secret.getAsterisks();
            this.printResult();
            this.tryProposedResult();
        }while ( this.countResults < 10 && !this.win );
        secret.getAsterisks();
        this.printResult();
    }

    private void tryProposedResult() {
            this.proposed = new Proposed();
            results[ countResults ] = new Result(secret, proposed);
            if (this.results[ countResults ].numberOfBlackPieces() == 4){
                IO.getInstance().printText("You've won!!! ;-)");
                win = true;
            }
            if ( countResults == 9 ){
                IO.getInstance().printText("You've lost!!! :-(");
            }
            countResults++;

    }

    private void printResult(){
        Arrays.stream(results).filter(element -> element != null)
                .forEach(Result::showResult);
    }

    public void countToZero(){
        countResults = 0;
        secret = new Secret();
        win = false;
        for (int i = 0; i < 10; i++){
            results[i] = null;
        }
    }
}