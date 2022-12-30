package org.example;

import utils.GetInput;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Field {
    Scanner scan = new Scanner(System.in).useLocale(Locale.UK).useDelimiter("\\n");
    final ArrayList<Character[]> field = buildField();
    private int setSize() {
        System.out.println("Enter field size (3 - 5):");
        int res = GetInput.getNum();
        if (res < 3 || res > 5) {
            System.out.println("Wrong size!");
            return setSize();
        } else return res;

    }

    private ArrayList<Character[]> buildField() {
        ArrayList<Character[]> field = new ArrayList<>();
        int size = setSize();
        for (int row = 0; row < size; row += 1) {
            Character[] line = new Character[size];
            for (int col = 0; col < size; col += 1) {
                line[col] = '*';
            }
            field.add(line);
        }
        return field;
    }

    public void outputField() {
        int size = field.size();
        for (int ind = -1; ind < field.get(0).length; ind += 1) {
            if (ind == size - 1) {
                System.out.println(ind);
            } else if (ind == -1) {
                System.out.print("+ ");
            } else System.out.print(ind + " ");
        }
        for (int row = 0; row < size; row += 1) {
            for (int col = 0; col < size; col += 1) {
                if (col == 0) System.out.print(row + " ");
                if (col < size - 1) {
                    System.out.print(field.get(row)[col] + " ");
                } else {
                    System.out.println(field.get(row)[col]);
                }
            }
        }
    }
}
