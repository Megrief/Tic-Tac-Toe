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

    public void makeMove(Player player) {

    }

}
