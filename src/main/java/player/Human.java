package player;

import field.Cell;
import utils.Input;
import utils.Output;

public class Human extends Player implements Input, Output {

    private int getRowCol(String rowOrCol, int size) {
        printInConsole(String.format("Enter index of %s (0 - %d):", rowOrCol, size - 1));
        int res = getNum();
        if (res >= size) {
            printInConsole(String.format("Wrong index of %s!", rowOrCol));
            return getRowCol(rowOrCol, size);
        } else return res;
    }
    @Override
    public Cell chooseCell(Cell[][] field) {
        printInConsole("Choose cell on the field:");
        int row = getRowCol("row", field.length);
        int col = getRowCol("column", field.length);
        if (field[row][col].getMark() != '*') {
            printInConsole("Current cell is occupied! Try again.");
            return chooseCell(field);
        } else return field[row][col];
    }

    @Override
    public String toString() {
        return "Player";
    }
}
