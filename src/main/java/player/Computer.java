package player;

import java.util.Random;

public class Computer extends Player {
    Random random = new Random();
    @Override
    public int[] chooseCell(int size) {
        int row = random.nextInt(0, size - 1);
        int col = random.nextInt(0, size - 1);
        return new int[] { row, col };
    }
    @Override
    public String toString() {
        return "computer";
    }
}
