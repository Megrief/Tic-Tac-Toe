package utils;

import field.Cell;
import player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface IsGameFinished {

    default boolean isEmptyCellsLeft(Cell[][] field) {
        for (Cell[] cells: field) {
            if (Arrays.stream(cells).anyMatch(cell -> cell.mark == '*')) return true;
        }
        return false;
    }

    default int evaluate(Player player, Cell[][] field) {
        ArrayList<Cell> firstD = new ArrayList<>();
        ArrayList<Cell> secondD = new ArrayList<>();

        for (int ind = 0; ind < 3; ind += 1) {
            List<Character> row = Arrays.stream(field[ind]).map(cell -> cell.mark).distinct().toList();
            if (row.size() == 1 && row.get(0) != '*') {
                return row.get(0) == player.mark ? 10 : -10;
            }

            ArrayList<Character> col = new ArrayList<>();
            for (Cell[] cells: field) {
                col.add(cells[ind].mark);
            }
            if (col.stream().distinct().toList().size() == 1 && col.get(0) != '*') {
                return col.get(0) == player.mark ? 10 : -10;
            }

            firstD.add(field[ind][field.length - (ind + 1)]);
            secondD.add(field[ind][ind]);
        }

        if (firstD.stream().map(cell -> cell.mark).distinct().toList().size() == 1
                && firstD.get(0).mark != '*') {
            return firstD.get(0).mark == player.mark ? 10 : -10;
        } else if (secondD.stream().map(cell -> cell.mark).distinct().toList().size() == 1
                && secondD.get(0).mark != '*') {
            return secondD.get(0).mark == player.mark ? 10 : -10;
        } else return 0;
    }
}
