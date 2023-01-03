package player;

import utils.GetInput;
public class Human extends Player {

    private int getRowCol(String rowOrCol, int size) {
        System.out.println(String.format("Enter index of %s (0 - %d):", rowOrCol, size - 1));
        int res = GetInput.getNum();
        if (res >= size) {
            System.out.println(String.format("Wrong index of %s!", rowOrCol));
            return getRowCol(rowOrCol, size);
        } else return res;
    }
    @Override
    public int[] chooseCell(int size) {
        System.out.println("Choose cell on the field:");
        int row = getRowCol("row", size);
        int col = getRowCol("column", size);
        return new int[] { row, col } ;
    }

    @Override
    public String toString() {
        return "player";
    }
}
