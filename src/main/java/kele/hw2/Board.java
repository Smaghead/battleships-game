package kele.hw2;


public class Board extends AddShipToBoard {

    private static final String FIRST_SEPARATOR_LINE = "_____________";
    private static final String LAST_SEPARATOR_LINE = "¯¯¯¯¯¯¯¯¯¯¯¯¯";
    private static final String COLUMNS = " 1 2 3 4 5 6 ";
    private static final String ADD_SHIP_TOOL_TIP = "Board layout:\n Rows (left to right): 1,2,3,4,5,6\n Columns (top to bottom): A,B,C,D,E,F ";
    private static final String SEPARATOR_LINE = "-------------";
    private String name;


    public Board() {
        for (int i = 0; i < rowNames.length; i++) {
            dataToShow.put(rowNames[i], new String[]{"/", "/", "/", "/", "/", "/"});
        }
        for (int i = 0; i < rowNames.length; i++) {
            shipData.put(rowNames[i], new String[]{"/", "/", "/", "/", "/", "/"});
        }
    }

    public void addAllShipsToBoard() {
        System.out.println(ADD_SHIP_TOOL_TIP);
        for (int i = 1; i < 6; i++) {
            System.out.println("");
            System.out.println("Placing ship with length: " + i);
            Boolean isRepeatNecessary = true;
            while (isRepeatNecessary) {
                try {
                    addShip(i);
                    Utility.clearScreen();
                    isRepeatNecessary = false;
                } catch (RuntimeException e) {
                    switch (e){
                        case InvalidMoveException ignored -> {
                            System.out.println("Ships will collide or part(s) of the ship will be outside of the board, try again!");
                            isRepeatNecessary = true;
                        }
                        case IndexOutOfBoundsException ignored -> {
                            System.out.println("Part(s) of the ship will be outside of the board");
                            isRepeatNecessary = true;
                        }
                        default -> throw new IllegalStateException("Unexpected value: " + e);
                    }

                }
                System.out.println("Currently placed ships on board:");
                printBoardWithShips();
            }
        }
    }

    public void printBoard() {
        System.out.println(COLUMNS);
        System.out.println(FIRST_SEPARATOR_LINE);
        for (int i = 0; i < rowNames.length; i++) {
            this.printRow(i);
            if (i < (rowNames.length - 1)) {
                System.out.println(SEPARATOR_LINE);
            } else {
                System.out.println(LAST_SEPARATOR_LINE);
            }
        }
    }

    public void printBoardWithShips() {
        System.out.println(COLUMNS);
        System.out.println(FIRST_SEPARATOR_LINE);
        for (int i = 0; i < rowNames.length; i++) {
            this.printShipRow(i);
            if (i < (rowNames.length - 1)) {
                System.out.println(SEPARATOR_LINE);
            } else {
                System.out.println(LAST_SEPARATOR_LINE);
            }
        }
    }

    private void printShipRow(Integer row) {
        Integer shown = 0;
        for (int o = 0; o < 13; o++) {
            if (o % 2 == 0) {
                System.out.print("|");
            } else {
                String[] technical = shipData.get(rowNames[row]);
                String toPrint = technical[shown];
                System.out.print(toPrint);
                shown++;
            }
        }
        System.out.print(" " + rowNames[row]);
        System.out.println("");
    }

    private void printRow(Integer row) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

