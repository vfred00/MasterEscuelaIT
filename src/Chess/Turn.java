package Chess;

public class Turn {
    private Player playerBlack;
    private Player playerWhite;
    private Player current;

    public Turn(){
        playerBlack = new Player(Color.WHITE);
        playerWhite = new Player(Color.BLACK);
        current = playerWhite;
    }

    public Player next(){
        if (this.current == playerBlack){
            return playerWhite;
        }
        return playerBlack;
    }

    public Player getCurrent(){
        return this.current;
    }

}
