package utils;

import player.Player;

import java.util.Scanner;

public class GetInput {
    static Scanner scan = new Scanner(System.in).useDelimiter("\\n");

    public static char getMark(String first, Player player) {
        if (first.equalsIgnoreCase(player.toString())) return 'x';
        return 'o';
    }
    public static int getNum() {
        String input = scan.next();

        while (!input.matches("\\d+")) {
            System.out.println("Wrong input!");
            System.out.println("Enter not negative integer number:");
            input = scan.next();
        }
        return Integer.parseInt(input);
    }
}
