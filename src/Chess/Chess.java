package Chess;

public class Chess {

    private Board board;
    private Turn turn;

    public Chess(){
        board = new Board();
        turn = new Turn();
    }

    public void play(){
        turn.getCurrent();
        do{
            board.show();
            IO.getInstance().printText("Turno de " + turn.getCurrent().getColor());
            int originX = IO.getInstance().readInt("origen X: ");
            int originY = IO.getInstance().readInt("origen Y: ");
            int destinationX = IO.getInstance().readInt("destino X: ");
            int destinationY = IO.getInstance().readInt("destino Y: ");
            Coordinate userGetCoordinateOrigin = new Coordinate(originX,originY);
            Coordinate userGetCoordinateDestination = new Coordinate(destinationX,destinationY);
            if (board.isPieceOnCordinate(userGetCoordinateOrigin) && board.getPiece(userGetCoordinateOrigin).getColor() == turn.getCurrent().getColor()){
                //si hay una pieza en origen y es del mismo color que player
                Piece piece = board.getPiece(userGetCoordinateOrigin);
                piece.isValidMovement(userGetCoordinateOrigin, userGetCoordinateDestination);
                if (board.isPieceOnCordinate(userGetCoordinateDestination)){
                    //comprobar si en destino hay alguien a quien matar, y en caso afirmativo, le cambio el estado a muerto
                    board.getPiece(userGetCoordinateDestination).kill();
                    //ahora coloco la pieza en el destino
                    board.setCoordinateOnPiece(userGetCoordinateOrigin,userGetCoordinateDestination);
                } else {
                    //ahora coloco la pieza en el destino
                    board.setCoordinateOnPiece(userGetCoordinateOrigin,userGetCoordinateDestination);
                }
                //acabo de comprobar que el movimento está permitido
                turn.next();
            }
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
