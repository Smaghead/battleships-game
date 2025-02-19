package kele.hw2;

import java.util.HashMap;

public class AddShipToBoard {
    protected HashMap<String, String[]> dataToShow = new HashMap<>();
    protected HashMap<String, String[]> dataShips = new HashMap<>();
    protected static final String[] rowNames = {"A", "B", "C", "D", "E", "F"};


    protected void addShip(Integer length) {
        String row = UserInterface.getStringInput("In which row do you want your ship to start?").toUpperCase();
        Integer column = UserInterface.getIntInput("In which column do you want your ship to start?");
        String direction = UserInterface.getStringInput("In which direction do you want your ship to go? vertical/horizontal").toLowerCase();
        if ("vertical".equals(direction)) {
            String orientation = UserInterface.getStringInput("In which orientation do you want your ship to go? right/left").toLowerCase();
            if ("right".equals(orientation)) {
                addShipVerticalRight(row, column, length);
            } else if ("left".equals(orientation)) {
                addShipVerticalLeft(row, column, length);
            }
        } else if ("horizontal".equals(direction)) {
            String orientation = UserInterface.getStringInput("In which orientation do you want your ship to go? below/above").toLowerCase();
            if ("below".equals(orientation)) {
                addShipHorizontalBelow(row, column, length);
            } else if ("above".equals(orientation)) {
                addShipHorizontalAbove(row, column, length);
            }
        }
    }

    private void addShipVerticalLeft(String row, Integer column, Integer length) {
        for (int i = 0; i < length; i++) {
            String[] technical = dataShips.get(row);
            String shipSign = String.valueOf(length);
            technical[column - 1 - i] = shipSign;
        }
    }

    private void addShipVerticalRight(String row, Integer column, Integer length) {
        for (int i = 0; i < length; i++) {
            String[] technical = dataShips.get(row);
            String shipSign = String.valueOf(length);
            technical[column - 1 + i] = shipSign;
        }
    }

    private void addShipHorizontalBelow(String row, Integer column, Integer length) {
        for (int i = 0; i < length; i++) {
            String[] technical = dataShips.get(row);
            String shipSign = String.valueOf(length);
            technical[column - 1] = shipSign;
            if (getRowIndex(row) < 5) {
                row = rowNames[getRowIndex(row) + 1];
            }
        }
    }

    private void addShipHorizontalAbove(String row, Integer column, Integer length) {
        for (int i = 0; i < length; i++) {
            String[] technical = dataShips.get(row);
            String shipSign = String.valueOf(length);
            technical[column - 1] = shipSign;
            if (getRowIndex(row) > 1) {
                row = rowNames[getRowIndex(row) - 1];
            }
        }
    }

    private Integer getRowIndex(String row) {
        for (int i = 0; i < rowNames.length; i++) {
            if (rowNames[i].equals(row)) {
                return i;
            }
        }
        return -1;
    }
}
