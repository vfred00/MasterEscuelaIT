package Chess;

public class Chess {

    private Board board;
    private Turn turn;

    public Chess(){
        board = new Board();
        turn = new Turn();
    }

    public void play(){
        do{
            board.show();
            IO.getInstance().printText("Turno de " + turn.getCurrent().getColor());
            int originX = IO.getInstance().readInt("origen X: ");
            int originY = IO.getInstance().readInt("origen Y: ");
            int destinationX = IO.getInstance().readInt("destino X: ");
            int destinationY = IO.getInstance().readInt("destino Y: ");
            Coordinate userGetCoordinateOrigin = new Coordinate(originX,originY);
            Coordinate userGetCoordinateDestination = new Coordinate(destinationX,destinationY);
            if (board.isPieceOnCordinate(userGetCoordinateOrigin) && board.getPiece(userGetCoordinateOrigin).getColor() == turn.getCurrentColor()){
                Piece piece = board.getPiece(userGetCoordinateOrigin);
                piece.isValidMovement(userGetCoordinateOrigin, userGetCoordinateDestination);
                if (board.isPieceOnCordinate(userGetCoordinateDestination)){
                    board.getPiece(userGetCoordinateDestination).kill();
                    board.setCoordinateOnPiece(userGetCoordinateOrigin,userGetCoordinateDestination);
                } else {
                    board.setCoordinateOnPiece(userGetCoordinateOrigin,userGetCoordinateDestination);
                }
            }
            turn.next();
        }while(true);
        //}while(board.getBlackKingAliveState() || board.getWhiteKingAliveState());
    }

    public static void main(String[] args) {
        new Chess().play();
    }

    public Coordinate userOriginDialog(){
        return null;
    }
}
