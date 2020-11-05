package Mastermind;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Secret extends Combination{

    public Secret(){
        super();
        this.getRandom();
    }

    public Combination getRandom(){
        Set<Integer> UniqueColorSet = new HashSet<>();
        int count = 0;
        int colorOrdinal;
        do {
            colorOrdinal = new Random().nextInt(Color.values().length);
            if (!UniqueColorSet.contains(colorOrdinal)){
                this.colorList.add(Color.values()[colorOrdinal]);
                UniqueColorSet.add(colorOrdinal);
                count++;
            }
        }while ( count < 4 );
        return this;
    }

    public void getAsterisks(){
        StringBuilder asterisks = new StringBuilder();
        for (Color color : colorList){
            asterisks.append("x");
        }
        IO.getInstance().printText(asterisks);

    }
}
