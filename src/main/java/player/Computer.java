package player;

import field.Field;
import utils.Minimax;
import utils.Output;

public class Computer extends Player implements Output, Minimax {

    @Override
    public int[] chooseCell(Field field) {
        Output.printInConsole("Computer is thinking...");
        return findBestMove(field, this);
    }
    @Override
    public String toString() {
        return "Computer";
    }
}