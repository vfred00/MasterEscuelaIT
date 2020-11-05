package Mastermind;

public class Mastermind {

    private Board board;

    public void play(){
        IO.getInstance().printText("-----MASTERMIND-----");
        do{
            this.board = new Board();
            this.board.play();
        }while(this.isResumed());
}

    private boolean isResumed() {
        String answer;
        do{
            answer = IO.getInstance().readText("¿RESUME? (y/n): ");
        } while ( !answer.equals("y") && !answer.equals("n") );
        return answer.equals("y");
}

    public static void main(String[] args) {
        new Mastermind().play();
    }
}
