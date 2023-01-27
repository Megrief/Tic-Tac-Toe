package player;

import field.Field;
import utils.Input;
import utils.Output;

public class Human extends Player implements Input, Output {

    private int getRowCol(String rowOrCol, int size) {
        Output.printInConsole(String.format("Enter index of %s (0 - %d):", rowOrCol, size - 1));
        int res = Input.getNum();
        if (res >= size) {
            Output.printInConsole(String.format("Wrong index of %s!", rowOrCol));
            return getRowCol(rowOrCol, size);
        } else return res;
    }
    @Override
    public int[] chooseCell(Field field) {
        Output.printInConsole("Choose cell on the field:");
        int row = getRowCol("row", field.size);
        int col = getRowCol("column", field.size);
        if (field.getCell(row, col).getMark() != '*') {
            Output.printInConsole("Current cell is occupied! Try again.");
            return chooseCell(field);
        } else return new int[] { row, col };
    }

    @Override
    public String toString() {
        return "Player";
    }
}
