package field;

public class Field {
    public final int size = 3;
    public final Cell[][] field = buildField();

    public Cell[][] getField() {
        Cell[][] copied;
        copied = field;
        return copied;
    }

    public Cell getCell(int row, int col) {
        return field[row][col];
    }

    private Cell[][] buildField() {
        Cell[][] field = new Cell[size][size];
        for (int row = 0; row < size; row += 1) {
            for (int col = 0; col < size; col += 1) {
                field[row][col] = new Cell('*');
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

