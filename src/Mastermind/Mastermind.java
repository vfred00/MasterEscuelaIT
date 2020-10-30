package Mastermind;

public class Mastermind {

    private Board board;

    public void play(){
        System.out.println("-----MASTERMIND-----");
        board = new Board();
        do{
            board.show();

        }while(board.howManyAttempts() < 10);
    }

    public static void main(String[] args) {
        new Mastermind().play();
    }
}
