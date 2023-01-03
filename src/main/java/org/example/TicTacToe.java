package org.example;

import player.Computer;
import player.Human;
import player.Player;

import java.util.Scanner;

public class TicTacToe {
    Scanner scan = new Scanner(System.in).useDelimiter("\\n");
    Player comp = new Computer();
    Player human = new Human();
    Field playground = new Field();
    String first = setFirst();


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
        int cnt = 0;
        while (cnt < playground.field.size() * playground.field.size()) {
            makeMove(first.equals("computer") ? comp : human);
            cnt += 1;
            makeMove(first.equals("computer") ? human : comp);
            cnt += 1;
        }
    }

    public void makeMove(Player player) {
        int[] cell = player.chooseCell(playground.field.size());
        while (!playground.field.get(cell[0])[cell[1]].equals('*')) {
            // Here, infinite loop will be obtained
            cell = player.chooseCell(playground.field.size());
        }
        playground.changeField(
            cell,
            player.toString().equals(first) ? 'x' : 'o'
        );
        playground.outputField();
    }

}
