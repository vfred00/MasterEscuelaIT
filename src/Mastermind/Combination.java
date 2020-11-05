package Mastermind;

import java.util.ArrayList;

public class Combination {

    protected ArrayList<Color> colorList;

    public Combination(){
        colorList = new ArrayList<Color>();
    }

    protected void show(){
        for(Color color : colorList){
            IO.getInstance().printText(color);
        }
    }

    protected int size(){
        return this.colorList.size();
    }
}