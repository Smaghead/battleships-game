package kele.hw2;

import java.util.Scanner;

public class Utility extends Board {
    protected static final Scanner scanner = new Scanner(System.in);

    public static String getStringInput(String question) {
        System.out.print(question + " - ");
        return scanner.next();
    }

    public static int getIntInput(String question) {
        Boolean isRepeatNecessary = true;
        Integer integer = 0;
        while (isRepeatNecessary) {
            try {
                System.out.print(question + " - ");
                String input = scanner.next();
                integer = Integer.valueOf(input);
                isRepeatNecessary = false;
            } catch (Exception e) {
                System.out.println("Do provide a valid integer.");
                isRepeatNecessary = true;
            }
        }
        return integer;
    }

    public static boolean isShipThere(String row, Integer column, Board player) {
        String[] technical = player.shipData.get(row);
        String dataToValidate = technical[column - 1];
        return !dataToValidate.equals("/");
    }

    public static boolean isValidMove(String row, Integer column, Board player) {
        String[] technical = player.dataToShow.get(row);
        String dataToValidate = technical[column - 1];
        return dataToValidate.equals("/");
    }

    /* Kindly borrowed from the internet
    It is only working if you run the .jar
    in IDE console output won't be cleared */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
