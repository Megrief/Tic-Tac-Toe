package field;

public class Cell {
    public int x;
    public int y;
    public char mark;

    public Cell(int x, int y, char mark) {
        this.x = x;
        this.y = y;
        this.mark = mark;
    }

    public void setMark(char newMark) {
        mark = newMark;
    }
    @Override
    public String toString() {
        return String.valueOf(mark);
    }
}
