package utils;

import java.util.Scanner;

public interface Input {
    Scanner scan = new Scanner(System.in).useDelimiter("\\n");

    static String getString() {
        String input = scan.next();
        if (input == null || input.isBlank()) {
            Output.printInConsole("Input is empty! Try again:");
            return getString();
        }
        return input;
    }

    static int getNum() {
        String input = Input.scan.next();

        while (!input.matches("\\d+")) {
            Output.printInConsole("Wrong input!");
            Output.printInConsole("Enter not negative integer number:");
            input = Input.scan.next();
        }
        return Integer.parseInt(input);
    }


}
