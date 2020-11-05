package Mastermind;

import java.util.ArrayList;
import java.util.List;

public class Board {

    List<Result> resultList;
    private Secret secret;
    private int countResults;
    private static final int ATTEMPTS = 10;

    public Board(){
        resultList = new ArrayList<Result>();
        countResults = 0;
        secret = new Secret();
    }

    public void play(){
        Result result;
        do {
            IO.getInstance().printText(countResults + " attempt(s):");
            secret.showAsterisks();
            result = new Result(secret, new ProposedCombination());
            resultList.add(result);
            this.showAllResults();
            countResults++;
            if ( countResults == ATTEMPTS){
                IO.getInstance().printText("You've lost!!! :-(");
            }
        }while ( this.countResults < ATTEMPTS && result.numberOfBlackPieces() != 4);
    }

    private void showAllResults(){
        resultList.stream().forEach(Result::showBlackAndWhite);
    }
}