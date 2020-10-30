package Mastermind;

public class Proposed extends Combination{

    public void setCombination(){
        String userInput = IO.getInstance().readText("Propose a combination: ");
        //userInput.charAt()

        userInput.chars().filter(i -> i == 'r').forEach(System.out::println);

        for (Color element : colorList){
            element = Color.BLUE;
        }
    }
}
