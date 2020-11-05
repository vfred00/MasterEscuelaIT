package Mastermind;

public class Result {

    private ProposedCombination proposedCombination;
    private Secret secret;
    private int piecesBlack;
    private int piecesWhite;

    public Result(Secret secret, ProposedCombination proposedCombination) {
        this.proposedCombination = proposedCombination;
        this.secret = secret;
        this.piecesBlack = 0;
        this.piecesWhite = 0;

        for (int i = 0; i < this.secret.size(); i++) {
            if (this.secret.colorList.get(i).equals(this.proposedCombination.colorList.get(i))) {
                piecesBlack++;
            } else if (this.secret.colorList.contains(this.proposedCombination.colorList.get(i))) {
                piecesWhite++;
            }
        }
    }

    public void showResult() {
        for (int i = 0; i < this.proposedCombination.size(); i++) {
            IO.getInstance().printTextWithoutNewLine((char) proposedCombination.colorList.get(i).getKeyword());
        }
        IO.getInstance().printText("-->" + this.piecesBlack
                + " Blacks and "
                + this.piecesWhite + " whites");
        if (this.numberOfBlackPieces() == 4){
            IO.getInstance().printText("You've won!!! ;-)");

        }
    }

    public int numberOfBlackPieces(){
        return this.piecesBlack;
    }
}
