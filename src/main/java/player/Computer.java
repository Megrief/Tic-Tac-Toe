package player;

import field.Cell;
import utils.Minimax;

public class Computer extends Player {
    Minimax minimax = new Minimax();

    @Override
    public Cell chooseCell(Cell[][] field) {
        System.out.println("\nComputer is thinking...");
        return minimax.findBestMove(field, this);
    }
    @Override
    public String toString() {
        return "Computer";
    }
}