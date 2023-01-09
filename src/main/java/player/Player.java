package player;

import field.Cell;

public abstract class Player {
    public char mark;

    public abstract Cell chooseCell(Cell[][] field);
}
