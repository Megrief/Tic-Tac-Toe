package utils;

public interface Output {
    default void printInConsole(String input) {
        System.out.println(input);
    }

}
