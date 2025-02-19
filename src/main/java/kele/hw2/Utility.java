package kele.hw2;

import java.util.Scanner;

public class Utility {
    protected static Scanner scanner = new Scanner(System.in);

    public static String getStringInput(String question) {
        System.out.print(question + " - ");
        return scanner.next();
    }

    public static int getIntInput(String question) {
        System.out.print(question + " - ");
        return scanner.nextInt();
    }
}
