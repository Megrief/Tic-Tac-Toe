package utils;

import field.Cell;
import field.Field;
import player.Player;

public interface Minimax extends IsGameFinished {
    //TODO create instance of field equals to original for minimax. Don't change original field
    private int minimax(Cell[][] field, int depth, Player player, boolean playersMove) {
        int score = evaluate(player, field);
        int best;

        if (score == 10 || score == -10) {
            return score;
        }

        if (fieldIsFilled(field)) {
            return 0;
        }

        if (playersMove) {
            best = -1000;
            for(Cell[] cells: field) {
                for (Cell cell: cells) {
                    if (cell.getMark() == '*') {
                        cell.setMark(player.getMark());
                        best = Math.max(best, minimax(field, depth + 1, player, false));
                        cell.setMark('*');
                    }
                }
            }
        } else {
            best = 1000;
            for (Cell[] cells: field) {
                for (Cell cell: cells) {
                    if (cell.getMark() == '*') {
                        cell.setMark(player.getMark() == 'x' ? 'o' : 'x');
                        best = Math.min(best, minimax(field, depth + 1, player, true));
                        cell.setMark('*');
                    }
                }
            }
        }

        return best;
    }

    default int[] findBestMove(Field field, Player player) {
        int best = -1000;
        int[] bestMove = new int[] { -1, -1 };

        for (int row = 0; row < field.size; row += 1) {
            for (int col = 0; col < field.size; col += 1) {
                Cell cell = field.getCell(row, col);
                if (cell.getMark() == '*') {
                    cell.setMark(player.getMark());
                    int moveVal = minimax(field.getField(), 0, player, false);
                    cell.setMark('*');
                    if (moveVal > best) {
                        bestMove = new int[] { row, col };
                        best = moveVal;
                    }
                }
            }
        }

        return bestMove;
    }
}
