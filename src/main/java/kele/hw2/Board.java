package kele.hw2;


public class Board extends AddShipToBoard {

    private static final String FIRSTSEPARATORLINE = "_____________";
    private static final String LASTSEPARATORLINE = "¯¯¯¯¯¯¯¯¯¯¯¯¯";
    private static final String COLUMNS = " 1 2 3 4 5 6 ";
    private static final String SEPARATORLINE = "-------------";
    private final String name;


    public Board(String name) {
        this.name = name;
        for (int i = 0; i < rowNames.length; i++) {
            dataToShow.put(rowNames[i], new String[]{"/", "/", "/", "/", "/", "/"});
        }
        for (int i = 0; i < rowNames.length; i++) {
            dataShips.put(rowNames[i], new String[]{"/", "/", "/", "/", "/", "/"});
        }
    }

    public void addAllShipsToBoard() {
        for (int i = 1; i < 6; i++) {
            System.out.println("Placing ship with length: " + i);
            addShip(i);
            printBoardWithShips();
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

    public void printBoardWithShips() {
        System.out.println(COLUMNS);
        System.out.println(FIRSTSEPARATORLINE);
        for (int i = 0; i < rowNames.length; i++) {
            this.printShipRow(i);
            if (i < (rowNames.length - 1)) {
                System.out.println(SEPARATORLINE);
            } else {
                System.out.println(LASTSEPARATORLINE);
            }
        }
    }

    public void printShipRow(Integer row) {
        Integer shown = 0;
        for (int o = 0; o < 13; o++) {
            if (o % 2 == 0) {
                System.out.print("|");
            } else {
                String[] technical = dataShips.get(rowNames[row]);
                String toPrint = technical[shown];
                System.out.print(toPrint);
                shown++;
            }
        }
        System.out.print(" " + rowNames[row]);
        System.out.println("");
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

