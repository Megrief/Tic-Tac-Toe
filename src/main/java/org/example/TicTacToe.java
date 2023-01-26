package org.example;

import field.Cell;
import field.Field;
import player.*;
import utils.Input;
import utils.IsGameFinished;
import utils.Output;

public class TicTacToe implements IsGameFinished, Input, Output {
    String first = setFirst();
    Player comp = new Computer();
    Player human = new Human();
    Field board = new Field();
    String winner = null;


    public String setFirst() {
        printInConsole("Who will move first (computer or player):");
        switch (Input.scan.next().toLowerCase()) {
            case ("computer") -> {
                //TODO set mark of player from this method
                return "computer";
            }
            case ("player") -> {
                return "player";
            }
            default -> {
                printInConsole("Wrong input!");
                return setFirst();
            }
        }
    }

    public void init() {
        comp.setMark(getMark(first, comp));
        human.setMark(getMark(first, human));
        Player current = first.equals("computer") ? comp : human;

        while (isEmptyCellsLeft(board.field)) {
            makeMove(current);
            if (winner != null) break;
            if (!isEmptyCellsLeft(board.field)) {
                printInConsole(board.toString());
                printInConsole("Friendship wins! Try again.");
                break;
            }
            current = current.toString().equalsIgnoreCase("computer") ? human : comp;
        }
    }

    public void makeMove(Player player) {
        //TODO think about possibility to move this method in Player class
        printInConsole(board.toString());
        Cell cell = player.chooseCell(board.field);
        board.field[cell.x][cell.y].setMark(player.getMark());
        if (evaluate(player, board.field) > 0) {
            winner = player.toString();
            printInConsole(board.toString());
            printInConsole(winner + " wins!");
        }
    }

}
