package kele.hw2;

import java.util.Scanner;

public class Utility extends AddShipToBoard {
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
            } catch (Exception e) {
                System.out.println("Do provide a valid integer.");
                isRepeatNecessary = true;
            }
        }
        return integer;
    }

    private static boolean isShipThere(String row, Integer column) {
        String[] technical = shipData.get(row);
        String dataToValidate = technical[column - 1];
        return !dataToValidate.equals("/");
    }

    private static boolean isValidMove(String row, Integer column) {
        String[] technical = dataToShow.get(row);
        String dataToValidate = technical[column - 1];
        return dataToValidate.equals("/");
    }

    public static void validateIsValidMove(String row, Integer column) throws InvalidMoveException {
        if (!isValidMove(row,column)){
            throw new InvalidMoveException();
        }
    }

    public static void validateIsShipThere(String row, Integer column) throws InvalidMoveException {
        if (isShipThere(row,column)){
            throw new InvalidMoveException();
        }
    }
}
