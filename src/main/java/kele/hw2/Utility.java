package kele.hw2;

import java.util.Scanner;

public class Utility extends AddShipToBoard {
    protected static Scanner scanner = new Scanner(System.in);

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

    public static boolean isShipThere(String row, Integer column) {
        String[] technical = shipData.get(row);
        String dataToValidate = technical[column - 1];
        return !dataToValidate.equals("/");
    }

    public static boolean isEnemyShipThere(String row, Integer column, Board enemy) {
        String[] technical = enemy.shipData.get(row);
        String dataToValidate = technical[column - 1];
        return !dataToValidate.equals("/");
    }

    public static boolean isValidMove(String row, Integer column) {
        String[] technical = dataToShow.get(row);
        String dataToValidate = technical[column - 1];
        return dataToValidate.equals("/");
    }
}
