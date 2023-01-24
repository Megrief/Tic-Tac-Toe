package org.example;

import field.Cell;
import field.Field;
import player.*;
import utils.GetInput;
import utils.IsGameFinished;

import java.util.Scanner;

public class TicTacToe implements IsGameFinished {
    Scanner scan = new Scanner(System.in).useDelimiter("\\n");
    String first = setFirst();
    Player comp = new Computer();
    Player human = new Human();
    Field board = new Field();
    String winner = null;


    public String setFirst() {
        System.out.println("Who will move first (computer or player):");
        switch (scan.next().toLowerCase()) {
            case ("computer") -> {
                return "computer";
            }
            case ("player") -> {
                return "player";
            }
            default -> {
                System.out.println("Wrong input!");
                return setFirst();
            }
        }
    }

    public void init() {
        comp.mark = GetInput.getMark(first, comp);
        human.mark = GetInput.getMark(first, human);
        Player current = first.equals("computer") ? comp : human;

        while (isEmptyCellsLeft(board.field)) {
            makeMove(current);
            if (winner != null) break;
            if (!isEmptyCellsLeft(board.field)) {
                board.outputField();
                System.out.println("\nFriendship wins! Try again.");
                break;
            }
            current = current.toString().equalsIgnoreCase("computer") ? human : comp;
        }
    }

    public void makeMove(Player player) {
        board.outputField();
        Cell cell = player.chooseCell(board.field);
        board.field[cell.x][cell.y].setMark(player.mark);
        if (evaluate(player, board.field) > 0) {
            winner = player.toString();
            board.outputField();
            System.out.println("\n" + winner + " wins!");
        }
    }

}
