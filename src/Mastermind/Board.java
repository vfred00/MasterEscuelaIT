package Mastermind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    //private Result[] results;
    List<Result> resultList;
    private Secret secret;
    private ProposedCombination proposedCombination;
    private int countResults;
    private boolean win;
    private static final int ATTEMPTS = 10;

    public Board(){
        resultList = new ArrayList<Result>();
        countResults = 0;
        secret = new Secret();
        win = false;
        ProposedCombination proposedCombination;
    }

    public void play(){
        Result result;
        do {
            IO.getInstance().printText(countResults + " attempt(s):");
            secret.showAsterisks();
            //secret.show(); //for trace purpose only
            result = new Result(secret, new ProposedCombination());
            resultList.add(new Result(secret, new ProposedCombination()));
            this.showAllResults();

            if ( countResults == ATTEMPTS){
                IO.getInstance().printText("You've lost!!! :-(");
            }
            countResults++;
        }while ( this.countResults < ATTEMPTS && result.numberOfBlackPieces() != 4);
    }

    private void showAllResults(){
        resultList.stream().filter(element -> element != null)
                            .forEach(Result::showResult);
    }
}