package kele.hw2;

import java.util.HashMap;


public class ShotHandler {
    public HashMap<String, String[]> dataToShow = new HashMap<>();
    public HashMap<String, String[]> shipData = new HashMap<>();
    public static final String[] rowNames = {"A", "B", "C", "D", "E", "F"};

    public void fireAction(Board player) {
        Boolean isRepeatNecessary = true;
        while (isRepeatNecessary) {
            try {
                fireCommand(Validator.getValidRow(), Validator.getValidColumn(), player);
                isRepeatNecessary = false;
            } catch (InvalidMoveException e) {
                System.out.println("Invalid move, you already targeted that cell.");
                isRepeatNecessary = true;
            }
        }
    }

    private void fireCommand(String row, Integer column, Board enemy) throws InvalidMoveException {
        if (Utility.isShipThere(row, column, enemy) && Utility.isValidMove(row, column, (Board) this)) {
            System.out.println("Ship hit on cell: " + row + column);
            addHit(row, column, enemy, (Board) this);
            //TODO deduct point from ship life
        }else if (Utility.isValidMove(row, column, (Board) this)) {
            System.out.println("Ship missed on cell: " + row + column);
            addMiss(row, column, (Board) this);
        } else {
            throw new InvalidMoveException();
        }
    }

    private void addMiss(String row, Integer column, Board player) {
        String[] technical = player.dataToShow.get(row);
        technical[column - 1] = "o";
    }

    private void addHit(String row, Integer column, Board enemy, Board player) {
        String[] technical = this.dataToShow.get(row);
        technical[column - 1] = "x";
        String[] technicalShip = enemy.shipData.get(row);
        technicalShip[column - 1] = "x";
    }

    //TODO add method to get ship sign
    private String getShipSign(String row, Integer column, Board player) {
        String[] technical = player.shipData.get(row);
        return technical[column - 1];
    }
}
