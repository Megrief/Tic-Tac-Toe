package org.example;

import field.Field;
import player.*;
import utils.Input;
import utils.IsGameFinished;
import utils.Output;

public class TicTacToe implements IsGameFinished, Input, Output {
    Player comp = new Computer();
    Player human = new Human();
    Field board = new Field();

    public void init() {
        setFirst();
        Player current = comp.getMark() == 'x' ? comp : human;

        while (true) {
            if (fieldIsFilled(board.getField())) {
                Output.printInConsole(board.toString());
                Output.printInConsole("Friendship wins! Try again.");
                break;
            }
            moving(current);
            if (evaluate(current, board.field) > 0) {
                Output.printInConsole(board.toString());
                Output.printInConsole(current + " wins!");
                break;
            }
            current = current instanceof Computer ? human : comp;
        }
    }

    public void setFirst() {
        Output.printInConsole("Who will move first (computer or player):");
        String input = Input.getString().toLowerCase();
        while (!input.equals("computer") && !input.equals("player")) {
            Output.printInConsole("Wrong input!");
            input = Input.getString().toLowerCase();
        }
        comp.setMark(input.equals("computer") ? 'x' : 'o');
        human.setMark(input.equals("computer") ? 'o' : 'x');
    }

    public void moving(Player player) {
        Output.printInConsole(board.toString());
        int[] loc = player.chooseCell(board);
        board.getCell(loc[0], loc[1]).setMark(player.getMark());
    }

}
