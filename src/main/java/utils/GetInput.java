package utils;

import java.util.Scanner;

public class GetInput {
    static Scanner scan = new Scanner(System.in).useDelimiter("\\n");

    public static int getNum() {
        String input = scan.next();
        while (!input.matches("\\d+")) {
            System.out.println("Wrong input!");
            System.out.println("Enter integer number:");
            input = scan.next();
        }
        return Integer.parseInt(input);
    }
}
