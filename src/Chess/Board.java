package Chess;

import java.util.HashMap;

public class Board {

    private HashMap<Coordinate, Piece> pieces;

    public Board(){
        pieces = new HashMap<Coordinate, Piece>();
        pieces.put(new Coordinate(0,1), new Knight(Color.BLACK));
        pieces.put(new Coordinate(0,6), new Knight(Color.BLACK));
        pieces.put(new Coordinate(7,1), new Knight(Color.WHITE));
        pieces.put(new Coordinate(7,6), new Knight(Color.WHITE));
        for (int i = 0; i < 8; i++){
            pieces.put(new Coordinate(1,i), new Pawn(Color.BLACK));
            pieces.put(new Coordinate(6,i), new Pawn(Color.WHITE));
        }
    }

    public void show() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Coordinate evaluate = new Coordinate(i, j);
                if (pieces.containsKey(evaluate) && pieces.get(evaluate).isAlive()) {
                    System.out.print(pieces.get(evaluate).show());
                } else {
                    System.out.print(" + ");
                }
            }
            System.out.println();
        }
    }

    public Piece getPiece(Coordinate coordinate){
        return pieces.get(coordinate);
    }

    public boolean isCoordinateOnBoard(Coordinate coordinate){
        return pieces.containsKey(coordinate);
    }
}
