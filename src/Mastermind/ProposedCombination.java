package Mastermind;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProposedCombination extends Combination{

    private String userInput;
    private static final  Pattern PATTERN = Pattern.compile( "[^rbyopg]", Pattern.CASE_INSENSITIVE);
    public ProposedCombination(){
        super();
        do {
            userInput = IO.getInstance().readText("Propose a combination: ");
        }while (!checkIntegrity());
        for (int i = 0; i < 4; i++){
            this.colorList.add(Color.valueOf( userInput.charAt(i)) );
        }
    }

    private boolean checkIntegrity() {
        return isCorrectLength() && isCharColors() && isUniqueChars();
    }

    private boolean isCorrectLength() {
        if (userInput.length() != 4) {
            IO.getInstance().printText("Wrong proposed combination length");
            return false;
        }
    return true;
    }

    private boolean isCharColors(){
        Matcher match = PATTERN.matcher(userInput);
        if (match.find()){
            IO.getInstance().printText("Wrong colors, they must be: rbygop");
            return false;
        }
        return true;
    }

    private boolean isUniqueChars(){
        Set<Character> CharSet = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++){
            if (!CharSet.contains( userInput.charAt(i)) ){
                CharSet.add( userInput.charAt(i) );
            }
        }
        if (CharSet.size() != 4){
            IO.getInstance().printText("Repeated colors not allowed");
            return false;
        }
        return true;
    }
}
