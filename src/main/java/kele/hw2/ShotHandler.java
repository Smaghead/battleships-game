package kele.hw2;

public class ShotHandler extends Board {

    public static void fire(String row, Integer column, Board enemy) {
        if (Utility.isEnemyShipThere(row, column, enemy)) {
            System.out.println("Ship hit on row: " + row + " column: " + column);
            addHit(row, column);
            //TODO add method to get ship sign
            //TODO deduct point from ship life
            String[] technical = enemy.shipData.get(row);
            String dataToValidate = technical[column - 1];
        }
        //TODO add miss functionality
    }

    private static void addMiss(String row, Integer column) {
        String[] technical = dataToShow.get(row);
        technical[column - 1] = "o";
    }

    private static void addHit(String row, Integer column) {
        String[] technical = dataToShow.get(row);
        technical[column - 1] = "x";
    }
}
