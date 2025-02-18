package kele.hw2;

import java.util.HashMap;

public class Board {

    private static final String FIRSTSEPARATORLINE = "_____________";
    private static final String LASTSEPARATORLINE = "¯¯¯¯¯¯¯¯¯¯¯¯¯";
    private static final String COLUMNS = " 1 2 3 4 5 6 ";
    private static final String SEPARATORLINE = "-------------";
    private final String name;
    private HashMap<String, String[]> dataToShow = new HashMap<>();
    private HashMap<String, String[]> dataShips = new HashMap<>();
    private static final String[] rowNames = {"A", "B", "C", "D", "E", "F"};

    public Board(String name) {
        this.name = name;
        for (int i = 0; i < rowNames.length; i++) {
            dataToShow.put(rowNames[i], new String[]{"/", "/", "/", "/", "/", "/"});
        }
        for (int i = 0; i < rowNames.length; i++) {
            dataShips.put(rowNames[i], new String[]{"/", "/", "/", "/", "/", "/"});
        }
    }

    //TODO continue addShip method
    public void addShip(String row, Integer column, Integer length, String direction, String orientation) {
        if ("vertical".equals(direction)) {
            if ("right".equals(orientation)) {
                addShipVerticalRight(row, column, length);
            } else if ("left".equals(orientation)){
                addShipVerticalLeft(row, column, length);
            } else {
                //TODO add exception here
                System.out.println("replace me with exception");
            }
        }
    }

    private void addShipVerticalLeft(String row, Integer column, Integer length) {
        for (int i = 0; i < length; i++) {
            //TODO dataToShow to be replaced with dataShips
            String[] technical = dataToShow.get(row);
            String shipSign = String.valueOf(length);
            technical[column - 1 - i] = shipSign;
        }
    }

    private void addShipVerticalRight(String row, Integer column, Integer length) {
        for (int i = 0; i < length; i++) {
            //TODO dataToShow to be replaced with dataShips
            String[] technical = dataToShow.get(row);
            String shipSign = String.valueOf(length);
            technical[column - 1 + i] = shipSign;
        }
    }

    public void printBoard() {
        System.out.println(COLUMNS);
        System.out.println(FIRSTSEPARATORLINE);
        for (int i = 0; i < rowNames.length; i++) {
            this.printRow(i);
            if (i < (rowNames.length - 1)) {
                System.out.println(SEPARATORLINE);
            } else {
                System.out.println(LASTSEPARATORLINE);
            }
        }
    }

    public void printRow(Integer row) {
        Integer shown = 0;
        for (int o = 0; o < 13; o++) {
            if (o % 2 == 0) {
                System.out.print("|");
            } else {
                String[] technical = dataToShow.get(rowNames[row]);
                String toPrint = technical[shown];
                System.out.print(toPrint);
                shown++;
            }
        }
        System.out.print(" " + rowNames[row]);
        System.out.println("");
    }

    public void addMiss(String row, Integer column) {
        String[] technical = dataToShow.get(row);
        technical[column - 1] = "o";
    }

    public void addHit(String row, Integer column) {
        String[] technical = dataToShow.get(row);
        technical[column - 1] = "x";
    }

    public String getName() {
        return name;
    }
}

