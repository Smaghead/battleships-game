package kele.hw2;

import java.util.HashMap;

public class AddShipToBoard {
    protected static HashMap<String, String[]> dataToShow = new HashMap<>();
    protected static HashMap<String, String[]> shipData = new HashMap<>();
    protected static final String[] rowNames = {"A", "B", "C", "D", "E", "F"};


    protected void addShip(Integer length) {
        String row = InputValidator.getValidRow();
        Integer column = InputValidator.getValidColumn();
        String direction = InputValidator.getValidDirection();
        if ("vertical".equals(direction) || "v".equals(direction)) {
            addShipVertical(length, row, column);
        } else if ("horizontal".equals(direction) || "h".equals(direction)) {
            addShipHorizontal(length, row, column);
        }
    }

    private void addShipHorizontal(Integer length, String row, Integer column) {
        String orientation = InputValidator.getValidHorizontalOrientation();
        if ("below".equals(orientation) || "b".equals(orientation)) {
            addShipHorizontalBelowOrientation(row, column, length);
        } else if ("above".equals(orientation) || "a".equals(orientation)) {
            addShipHorizontalAboveOrientation(row, column, length);
        }
    }

    private void addShipVertical(Integer length, String row, Integer column) {
        String orientation = InputValidator.getValidVerticalOrientation();
        if ("right".equals(orientation) || "r".equals(orientation)) {
            addShipVerticalRightOrientation(row, column, length);
        } else if ("left".equals(orientation) || "l".equals(orientation)) {
            addShipVerticalLeftOrientation(row, column, length);
        }
    }

    private void addShipVerticalLeftOrientation(String row, Integer column, Integer length) {
        for (int i = 0; i < length; i++) {
            String[] technical = shipData.get(row);
            String shipSign = String.valueOf(length);
            technical[column - 1 - i] = shipSign;
        }
    }

    private void addShipVerticalRightOrientation(String row, Integer column, Integer length) {
        for (int i = 0; i < length; i++) {
            String[] technical = shipData.get(row);
            String shipSign = String.valueOf(length);
            technical[column - 1 + i] = shipSign;
        }
    }

    private void addShipHorizontalBelowOrientation(String row, Integer column, Integer length) {
        for (int i = 0; i < length; i++) {
            String[] technical = shipData.get(row);
            String shipSign = String.valueOf(length);
            technical[column - 1] = shipSign;
            if (getRowIndex(row) < 5) {
                row = rowNames[getRowIndex(row) + 1];
            }
        }
    }

    private void addShipHorizontalAboveOrientation(String row, Integer column, Integer length) {
        for (int i = 0; i < length; i++) {
            String[] technical = shipData.get(row);
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
