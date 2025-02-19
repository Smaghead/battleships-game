package kele.hw2;

public class InputValidator extends Utility {


    public static String getValidDirection() {
        String direction = "";
        Integer errorCounter = 0;
        while (!isDirectionValid(direction)) {
            if (errorCounter > 0) {
                System.out.println("Valid inputs: V,H,vertical,horizontal");
            }
            direction = Utility.getStringInput("In which direction do you want your ship to go? \033[4mV\033[0mertical / \033[4mH\033[0morizontal").toUpperCase();
            errorCounter++;
        }
        return direction.toLowerCase();
    }

    public static String getValidRow() {
        String row = "";
        Integer errorCounter = 0;
        while (!isRowValid(row)) {
            if (errorCounter > 0) {
                System.out.println("Valid rows: A,B,C,D,E,F");
            }
            row = Utility.getStringInput("In which row do you want your ship to start?").toUpperCase();
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
            column = Utility.getIntInput("In which column do you want your ship to start?");
            errorCounter++;
        }
        return column;
    }

    private static Boolean isDirectionValid(String direction) {
        direction = direction.toUpperCase();
        return "V".equals(direction) ||
                "H".equals(direction) ||
                "VERTICAL".equals(direction) ||
                "HORIZONTAL".equals(direction);
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
