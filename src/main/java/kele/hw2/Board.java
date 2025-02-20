package kele.hw2;


public class Board extends AddShipToBoard {

    private static final String FIRST_SEPARATOR_LINE = "_____________";
    private static final String LAST_SEPARATOR_LINE = "¯¯¯¯¯¯¯¯¯¯¯¯¯";
    private static final String COLUMNS = " 1 2 3 4 5 6 ";
    private static final String SEPARATOR_LINE = "-------------";
    private final String name;


    public Board(String name) {
        this.name = name;
        for (int i = 0; i < rowNames.length; i++) {
            dataToShow.put(rowNames[i], new String[]{"/", "/", "/", "/", "/", "/"});
        }
        for (int i = 0; i < rowNames.length; i++) {
            shipData.put(rowNames[i], new String[]{"/", "/", "/", "/", "/", "/"});
        }
    }

    public void addAllShipsToBoard() {
        for (int i = 1; i < 6; i++) {
            System.out.println("Placing ship with length: " + i);
            addShip(i);
            System.out.println("Currently placed ships on board:");
            printBoardWithShips();
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

