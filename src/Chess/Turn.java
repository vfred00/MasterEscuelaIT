package Chess;

import java.util.Random;

public class Turn {
    private Player playerBlack;
    private Player playerWhite;
    private Player current;

    public Turn(){
        playerBlack = new Player(Color.WHITE);
        playerWhite = new Player(Color.BLACK);
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

    public Player getRandomPlayer(){
        Random random = new Random();
        int randomUser = random.nextInt(2);
        if (randomUser == 0){
            this.current = playerBlack;
            return playerBlack;
        }
        this.current = playerWhite;
        return playerWhite;
    }
}
