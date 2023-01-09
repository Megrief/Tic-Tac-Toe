package player;

import field.Cell;
import utils.GetInput;
public class Human extends Player {

    private int getRowCol(String rowOrCol, int size) {
        System.out.printf("Enter index of %s (0 - %d):%n", rowOrCol, size - 1);
        int res = GetInput.getNum();
        if (res >= size) {
            System.out.printf("Wrong index of %s!%n", rowOrCol);
            return getRowCol(rowOrCol, size);
        } else return res;
    }
    @Override
    public Cell chooseCell(Cell[][] field) {
        System.out.println("\nChoose cell on the field:");
        int row = getRowCol("row", field.length);
        int col = getRowCol("column", field.length);
        return field[row][col];
    }

    @Override
    public String toString() {
        return "Player";
    }
}
