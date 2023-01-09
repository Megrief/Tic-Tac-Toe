package field;

public class Field {
    public final Cell[][] field = buildField();

    private Cell[][] buildField() {
        Cell[][] field = new Cell[3][3];
        for (int row = 0; row < 3; row += 1) {
            for (int col = 0; col < 3; col += 1) {
                field[row][col] = new Cell(row, col, '*');
            }
        }
        return field;
    }

    public void outputField() {
        for (int ind = -1; ind < 3; ind += 1) {
            if (ind == 3 - 1) {
                System.out.println(ind);
            } else if (ind == -1) {
                System.out.print("+ ");
            } else System.out.print(ind + " ");
        }
        for (int row = 0; row < 3; row += 1) {
            for (int col = 0; col < 3; col += 1) {
                if (col == 0) System.out.print(row + " ");
                if (col < 3 - 1) {
                    System.out.print(field[row][col] + " ");
                } else {
                    System.out.println(field[row][col]);
                }
            }
        }
    }
}

