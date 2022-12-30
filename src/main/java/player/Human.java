package player;

import utils.GetInput;
public class Human extends Player {

    private int getRowCol(String rowOrCol, int size) {
        System.out.println(String.format("Enter index of %s (0 - %d):", rowOrCol, size - 1));
        int res = GetInput.getNum();
        if (res >= size) {
            System.out.println(String.format("Wrong number of %s!", rowOrCol));
            return getRowCol(rowOrCol, size);
        } else return res;
    }
    @Override
    public String chooseCell(int size) {
        System.out.println("Choose cell on the field:");
        int row = getRowCol("row", size);
        int col = getRowCol("column", size);
        return String.format("%d %d", row, col);
    }
}
