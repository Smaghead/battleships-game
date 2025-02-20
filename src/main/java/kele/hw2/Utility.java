package kele.hw2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utility {
    protected static Scanner scanner = new Scanner(System.in);
    private static boolean isRepeatNecessary = true;

    public static String getStringInput(String question) {
        System.out.print(question + " - ");
        return scanner.next();
    }

    public static int getIntInput(String question) {
        Integer integer = 0;
        while (isRepeatNecessary) {
            try {
                System.out.print(question + " - ");
                String input = scanner.next();
                integer = Integer.valueOf(input);
                isRepeatNecessary = false;
            }
            catch (Exception e) {
                System.out.println("Do provide a valid integer.");
                isRepeatNecessary = true;
            }
        }
        return integer;
    }
}
