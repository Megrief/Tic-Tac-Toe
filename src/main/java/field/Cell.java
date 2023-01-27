package field;

public class Cell {
    public char mark;

    public Cell(char mark) {
        this.mark = mark;
    }

    public void setMark(char input) {
        mark = input;
    }
    public char getMark() {
        return mark;
    }
    @Override
    public String toString() {
        return String.valueOf(mark);
    }
}
