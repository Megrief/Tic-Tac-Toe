package utils;

import player.Player;

import java.util.Scanner;

public interface Input {
    Scanner scan = new Scanner(System.in).useDelimiter("\\n");

    default char getMark(String first, Player player) {
        //TODO rewrite or remove this method.
        if (first.equalsIgnoreCase(player.toString())) return 'x';
        return 'o';
    }

    default int getNum() {
        String input = Input.scan.next();

        while (!input.matches("\\d+")) {
            System.out.println("Wrong input!");
            System.out.println("Enter not negative integer number:");
            input = Input.scan.next();
        }
        return Integer.parseInt(input);
    }


}
