package utils;

import field.Cell;
import player.Player;

public class Minimax implements IsGameFinished {

    private int minimax(Cell[][] field, int depth, Player player, boolean playersMove) {
        int score = evaluate(player, field);
        int best;

        if (score == 10 || score == -10) {
            return score;
        }

        if (!isEmptyCellsLeft(field)) {
            return 0;
        }

        if (playersMove) {
            best = -1000;
            for(Cell[] cells: field) {
                for (Cell cell: cells) {
                    if (cell.mark == '*') {
                        cell.mark = player.mark;
                        best = Math.max(best, minimax(field, depth + 1, player, false));
                        cell.mark = '*';
                    }
                }
            }
        } else {
            best = 1000;
            for (Cell[] cells: field) {
                for (Cell cell: cells) {
                    if (cell.mark == '*') {
                        cell.mark = player.mark == 'x' ? 'o' : 'x';
                        best = Math.min(best, minimax(field, depth + 1, player, true));
                        cell.mark = '*';
                    }
                }
            }
        }

        return best;
    }

    public Cell findBestMove(Cell[][] field, Player player) {
        int best = -1000;
        Cell bestMove = new Cell(-1, -1, '*');

        for (Cell[] cells: field) {
            for (Cell cell: cells) {
                if (cell.mark == '*') {
                    cell.mark = player.mark;
                    int moveVal = minimax(field, 0, player, false);
                    cell.mark = '*';
                    if (moveVal > best) {
                        bestMove = cell;
                        best = moveVal;
                    }
                }
            }
        }

        return bestMove;
    }
}
