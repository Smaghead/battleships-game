package kele.hw2;

import java.util.Scanner;

// Utility class shouldn't extend any other class, that's against the purpose of a Util class
// though I believe this is not necessary a util class; might be better to rename it.
public class Utility extends Board {
    protected static final Scanner scanner = new Scanner(System.in);

    public static String getStringInput(String question) {
        System.out.print(question + " - ");
        return scanner.next();
    }

    //check regex to validate user input
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

    private static Boolean isWinner(Board player) {
        if (player.getDestroyerHp() == 69
                && player.getSubmarineHp() == 69
                && player.getCruiserHp() == 69
                && player.getBattleshipHp() == 69
                && player.getCarrierHp() == 69) {
            return false;
        }
        return true;
    }

    public static String returnWinnerName(Board player1, Board player2) {
        if (isWinner(player1)) {
            return player1.getName();
        }
        return player2.getName();
    }

    /* Kindly borrowed from the internet
    It's only working if you run the .jar
    in IDE console output won't be cleared */
    // I am unsure about the purpose of this method, maybe we can check it out together
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
