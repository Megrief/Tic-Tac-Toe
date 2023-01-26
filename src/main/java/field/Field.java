package field;

public class Field {
    final int size = 3;
    public final Cell[][] field = buildField();

    private Cell[][] buildField() {
        Cell[][] field = new Cell[size][size];
        for (int row = 0; row < size; row += 1) {
            for (int col = 0; col < size; col += 1) {
                field[row][col] = new Cell(row, col, '*');
            }
        }
        return field;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int ind = -1; ind < size; ind += 1) {
            if (ind == size - 1) {
                str.append(ind).append("\n");
            } else if (ind == -1) {
                str.append("+ ");
            } else str.append(ind).append(" ");
        }
        for (int row = 0; row < size; row += 1) {
            for (int col = 0; col < size; col += 1) {
                if (col == 0) str.append(row).append(" ");
                if (col < size - 1) {
                    str.append(field[row][col]).append(" ");
                } else {
                    str.append(field[row][col]).append("\n");
                }
            }
        }
        return str.toString();
    }
}

