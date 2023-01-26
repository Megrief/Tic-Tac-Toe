package player;

import field.Cell;
import utils.Minimax;
import utils.Output;

public class Computer extends Player implements Output, Minimax {

    @Override
    public Cell chooseCell(Cell[][] field) {
        printInConsole("Computer is thinking...");
        return findBestMove(field, this);
    }
    @Override
    public String toString() {
        return "Computer";
    }
}