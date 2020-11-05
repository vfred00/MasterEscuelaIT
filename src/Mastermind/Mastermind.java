package Mastermind;

public class Mastermind {

    private Board board;

    public Mastermind(){
        board = new Board();
    }

    public void play(){
        IO.getInstance().printText("-----MASTERMIND-----");
        do{
            board.countToZero();
            board.show();

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
