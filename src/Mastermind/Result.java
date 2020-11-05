package Mastermind;

public class Result {

    private Proposed proposed;
    private Secret secret;
    private int piecesBlack;
    private int piecesWhite;

    public Result(Secret secret, Proposed proposed) {
        this.proposed = proposed;
        this.secret = secret;
        this.piecesBlack = 0;
        this.piecesWhite = 0;

        for (int i = 0; i < this.secret.size(); i++) {
            if (this.secret.colorList.get(i).equals(this.proposed.colorList.get(i))) {
                piecesBlack++;
            } else if (this.secret.colorList.contains(this.proposed.colorList.get(i))) {
                piecesWhite++;
            }
        }
    }

    public void showResult() {
        for (int i = 0; i < this.proposed.size(); i++) {
            IO.getInstance().printTextWithoutNewLine((char)proposed.colorList.get(i).getKeyword());
        }
        IO.getInstance().printText("-->" + this.piecesBlack
                + " Blacks and "
                + this.piecesWhite + " whites");
    }

    public int numberOfBlackPieces(){
        return this.piecesBlack;
    }
}
