package kele.hw2;

public class Validator extends Utility {


    public static boolean isAddShipHorizontalLeftOrientationValid(String row, Integer column, Integer length, Board player) {
        for (int i = 0; i < length; i++) {
            if (Utility.isShipThere(row, (column - i), player)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAddShipHorizontalRightOrientationValid(String row, Integer column, Integer length, Board player) {
        for (int i = 0; i < length; i++) {
            if (Utility.isShipThere(row, (column + i),player)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAddShipVerticalDownOrientationValid(String row, Integer column, Integer length, Board player) {
        Integer counterF = 0;
        for (int i = 0; i < length; i++) {
            if (Utility.isShipThere(row, column, player) || !isRowValid(row) || counterF == 1) {
                return false;
            }
            if ("F".equals(row)) {
                counterF++;
            }
            if (getRowIndex(row) < 5) {
                row = rowNames[getRowIndex(row) + 1];
            }
        }
        return true;
    }

    public static boolean isAddShipVerticalUpOrientationValid(String row, Integer column, Integer length, Board player) {
        Integer counterA = 0;
        for (int i = 0; i < length; i++) {
            if (Utility.isShipThere(row, column, player) || !isRowValid(row) || counterA == 1) {
                return false;
            }
            if ("A".equals(row)) {
                counterA++;
            }
            if (getRowIndex(row) > 0) {
                row = rowNames[getRowIndex(row) - 1];
            }
        }
        return true;
    }

    public static String getValidVerticalOrientation() {
        String orientation = "";
        Integer errorCounter = 0;
        while (!isVerticalOrientationValid(orientation)) {
            if (errorCounter > 0) {
                System.out.println("Valid inputs: U,D,up,down");
            }
            orientation = Utility.getStringInput("In which orientation do you want your ship to go? \033[4mU\033[0mp / \033[4mD\033[0mown").toLowerCase();
            errorCounter++;
        }
        return orientation;
    }

    public static String getValidHorizontalOrientation() {
        String orientation = "";
        Integer errorCounter = 0;
        while (!isHorizontalOrientationValid(orientation)) {
            if (errorCounter > 0) {
                System.out.println("Valid inputs: L,R,left,right");
            }
            orientation = Utility.getStringInput("In which orientation do you want your ship to go? \033[4mR\033[0might / \033[4mL\033[0meft").toLowerCase();
            errorCounter++;
        }
        return orientation;
    }

    public static String getValidDirection() {
        String direction = "";
        Integer errorCounter = 0;
        while (!isDirectionValid(direction)) {
            if (errorCounter > 0) {
                System.out.println("Valid inputs: V,H,vertical,horizontal");
            }
            direction = Utility.getStringInput("In which direction do you want your ship to go? \033[4mV\033[0mertical / \033[4mH\033[0morizontal").toLowerCase();
            errorCounter++;
        }
        return direction;
    }

    public static String getValidRow() {
        String row = "";
        Integer errorCounter = 0;
        while (!isRowValid(row)) {
            if (errorCounter > 0) {
                System.out.println("Valid rows: A,B,C,D,E,F");
            }
            row = Utility.getStringInput("Do provide a valid row").toUpperCase();
            errorCounter++;
        }
        return row;
    }

    public static Integer getValidColumn() {
        Integer column = 0;
        Integer errorCounter = 0;
        while (!isColumnValid(column)) {
            if (errorCounter > 0) {
                System.out.println("Valid columns: 1,2,3,4,5,6");
            }
            column = Utility.getIntInput("Do provide a valid column");
            errorCounter++;
        }
        return column;
    }

    private static Boolean isVerticalOrientationValid(String orientation) {
        orientation = orientation.toLowerCase();
        return "u".equals(orientation) ||
                "d".equals(orientation) ||
                "up".equals(orientation) ||
                "down".equals(orientation);
    }

    private static Boolean isHorizontalOrientationValid(String orientation) {
        orientation = orientation.toLowerCase();
        return "l".equals(orientation) ||
                "r".equals(orientation) ||
                "left".equals(orientation) ||
                "right".equals(orientation);
    }

    private static Boolean isDirectionValid(String direction) {
        direction = direction.toLowerCase();
        return "v".equals(direction) ||
                "h".equals(direction) ||
                "vertical".equals(direction) ||
                "horizontal".equals(direction);
    }

    private static Boolean isRowValid(String row) {
        row = row.toUpperCase();
        return "A".equals(row) ||
                "B".equals(row) ||
                "C".equals(row) ||
                "D".equals(row) ||
                "E".equals(row) ||
                "F".equals(row);
    }

    private static Boolean isColumnValid(Integer column) {
        return (1 == column) ||
                (2 == column) ||
                (3 == column) ||
                (4 == column) ||
                (5 == column) ||
                (6 == column);
    }

}
