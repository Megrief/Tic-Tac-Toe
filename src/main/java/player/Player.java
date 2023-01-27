package player;

import field.Field;

public abstract class Player {
    private char mark;

    public char getMark() {
        return mark;
    }
    public void setMark(char input) {
        mark = input;
    }
//    public abstract Cell chooseCell(Cell[][] field);
    public abstract int[] chooseCell(Field field);
    //TODO think about work with just indices, not cells.
}
