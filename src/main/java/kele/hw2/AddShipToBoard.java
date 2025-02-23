package kele.hw2;


public class AddShipToBoard extends ShotHandler{


    public void addShip(Integer length) throws InvalidMoveException {
        String row = Validator.getValidRow();
        Integer column = Validator.getValidColumn();
        String direction = Validator.getValidDirection();
        if ("vertical".equals(direction) || "v".equals(direction)) {
            addShipVertical(length, row, column, (Board) this);
        } else if ("horizontal".equals(direction) || "h".equals(direction)) {
            addShipHorizontal(length, row, column, (Board) this);
        }
    }

    private void addShipVertical(Integer length, String row, Integer column, Board player) throws InvalidMoveException {
        String orientation = Validator.getValidVerticalOrientation();
        if ("below".equals(orientation) || "b".equals(orientation)) {
            addShipVerticalBelowOrientation(row, column, length, player);
        } else if ("above".equals(orientation) || "a".equals(orientation)) {
            addShipVerticalAboveOrientation(row, column, length, player);
        }
    }

    private void addShipHorizontal(Integer length, String row, Integer column, Board player) throws InvalidMoveException {
        String orientation = Validator.getValidHorizontalOrientation();
        if ("right".equals(orientation) || "r".equals(orientation)) {
            addShipHorizontalRightOrientation(row, column, length, player);
        } else if ("left".equals(orientation) || "l".equals(orientation)) {
            addShipHorizontalLeftOrientation(row, column, length, player);
        }
    }

    private void addShipHorizontalLeftOrientation(String row, Integer column, Integer length, Board player) throws InvalidMoveException {
        if (Validator.isAddShipHorizontalLeftOrientationValid(row, column, length, player )) {
            for (int i = 0; i < length; i++) {
                String[] technical = shipData.get(row);
                String shipSign = String.valueOf(length);
                technical[column - 1 - i] = shipSign;
            }
        } else {
            throw new InvalidMoveException();
        }
    }

    private void addShipHorizontalRightOrientation(String row, Integer column, Integer length, Board player) throws InvalidMoveException {
        if (Validator.isAddShipHorizontalRightOrientationValid(row, column, length, player)) {
            for (int i = 0; i < length; i++) {
                String[] technical = shipData.get(row);
                String shipSign = String.valueOf(length);
                technical[column - 1 + i] = shipSign;
            }
        } else {
            throw new InvalidMoveException();
        }
    }

    private void addShipVerticalBelowOrientation(String row, Integer column, Integer length, Board player) throws InvalidMoveException {
        if (Validator.isAddShipVerticalBelowOrientationValid(row, column, length, player)) {
            for (int i = 0; i < length; i++) {
                String[] technical = player.shipData.get(row);
                String shipSign = String.valueOf(length);
                technical[column - 1] = shipSign;
                if (getRowIndex(row) < 5) {
                    row = rowNames[getRowIndex(row) + 1];
                }
            }
        } else {
            throw new InvalidMoveException();
        }
    }

    private void addShipVerticalAboveOrientation(String row, Integer column, Integer length, Board player) throws InvalidMoveException {
        if (Validator.isAddShipVerticalAboveOrientationValid(row, column, length, player)) {
            for (int i = 0; i < length; i++) {
                String[] technical = player.shipData.get(row);
                String shipSign = String.valueOf(length);
                technical[column - 1] = shipSign;
                if (getRowIndex(row) > 0) {
                    row = rowNames[getRowIndex(row) - 1];
                }
            }
        } else {
            throw new InvalidMoveException();
        }
    }

    public static Integer getRowIndex(String row) {
        for (int i = 0; i < rowNames.length; i++) {
            if (rowNames[i].equals(row)) {
                return i;
            }
        }
        return -1;
    }
}
