package kele.hw2;

public class ShotHandler extends Board {

    public static void fire(String row, Integer column, Board player) throws InvalidMoveException {
        if (Utility.isEnemyShipThere(row, column, player)) {
            System.out.println("Ship hit on row: " + row + " column: " + column);
            addHit(row, column);
            //TODO deduct point from ship life
        } else if (Utility.isValidMove(row, column)) {
            addMiss(row, column);
        } else {
            throw new InvalidMoveException();
        }
    }

    private static void addMiss(String row, Integer column) {
        String[] technical = dataToShow.get(row);
        technical[column - 1] = "o";
    }

    private static void addHit(String row, Integer column) {
        String[] technical = dataToShow.get(row);
        technical[column - 1] = "x";
    }
    //TODO add method to get ship sign
    private static String getShipSign(String row, Integer column, Board player){
            String[] technical = player.shipData.get(row);
        return technical[column - 1];
    }
}
