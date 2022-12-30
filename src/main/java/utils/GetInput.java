package utils;

import java.util.Locale;
import java.util.Scanner;

public class GetInput {
    static Scanner scan = new Scanner(System.in).useDelimiter("\\n").useLocale(Locale.UK);

    public static int getNum() {
        String input = scan.next();
        while (!input.matches("\\d+")) {
            System.out.println("Wrong input!");
            input = scan.next();
        }
        return Integer.parseInt(input);
    }
}
