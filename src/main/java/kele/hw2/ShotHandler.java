package kele.hw2;

import java.util.HashMap;


public class ShotHandler {
    public HashMap<String, String[]> dataToShow = new HashMap<>();
    public HashMap<String, String[]> shipData = new HashMap<>();
    public static final String[] rowNames = {"A", "B", "C", "D", "E", "F"};

    public void fire(String row, Integer column, Board enemy) throws InvalidMoveException {
        if (Utility.isShipThere(row, column, enemy)) {
            System.out.println("Ship hit on cell: (row: " + row + " column: " + column + ")");
            addHit(row, column);
            //TODO deduct point from ship life
        } else if (Utility.isValidMove(row, column, (Board) this)) {
            System.out.println("Ship missed on cell: (row: " + row + " column: " + column + ")");
            addMiss(row, column);
        } else {
            throw new InvalidMoveException();
        }
    }

    private void addMiss(String row, Integer column) {
        String[] technical = dataToShow.get(row);
        technical[column - 1] = "o";
    }

    private void addHit(String row, Integer column) {
        String[] technical = dataToShow.get(row);
        technical[column - 1] = "x";
    }
    //TODO add method to get ship sign
    private String getShipSign(String row, Integer column, Board player){
            String[] technical = player.shipData.get(row);
        return technical[column - 1];
    }
}
