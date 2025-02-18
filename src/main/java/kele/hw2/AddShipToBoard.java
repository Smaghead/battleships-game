package kele.hw2;

import java.util.HashMap;

public class AddShipToBoard {
    protected HashMap<String, String[]> dataToShow = new HashMap<>();
    protected HashMap<String, String[]> dataShips = new HashMap<>();
    protected static final String[] rowNames = {"A", "B", "C", "D", "E", "F"};

    //TODO add error handling
    public void addShip(String row, Integer column, Integer length, String direction, String orientation) {
        if ("vertical".equals(direction)) {
            if ("right".equals(orientation)) {
                addShipVerticalRight(row, column, length);
            } else if ("left".equals(orientation)) {
                addShipVerticalLeft(row, column, length);
            } else {
                //TODO add exception here
                System.out.println("replace me with exception");
            }
        } else if ("horizontal".equals(direction)) {
            if ("below".equals(orientation)) {
                addShipHorizontalBelow(row, column, length);
            } else if ("above".equals(orientation)) {
                addShipHorizontalAbove(row, column, length);
            } else {
                //TODO add exception here
                System.out.println("replace me with exception");
            }
        } else {
            //TODO add exception here
            System.out.println("replace me with exception");
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

    private void addShipHorizontalBelow(String row, Integer column, Integer length) {
        for (int i = 0; i < length; i++) {
            //TODO dataToShow to be replaced with dataShips
            String[] technical = dataToShow.get(row);
            String shipSign = String.valueOf(length);
            technical[column - 1] = shipSign;
            if (getRowIndex(row) < 5) {
                row = rowNames[getRowIndex(row) + 1];
            }
        }
    }

    private void addShipHorizontalAbove(String row, Integer column, Integer length) {
        for (int i = 0; i < length; i++) {
            //TODO dataToShow to be replaced with dataShips
            String[] technical = dataToShow.get(row);
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
        //TODO add exception here
        return -1;
    }
}
