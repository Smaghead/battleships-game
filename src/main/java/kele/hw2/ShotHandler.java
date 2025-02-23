package kele.hw2;

import java.util.HashMap;


public class ShotHandler {
    private Boolean isGameRunning = true;
    protected HashMap<String, String[]> dataToShow = new HashMap<>();
    protected HashMap<String, String[]> shipData = new HashMap<>();
    protected static final String[] rowNames = {"A", "B", "C", "D", "E", "F"};
    private Integer carrierHp = 5;
    private Integer battleshipHp = 4;
    private Integer cruiserHp = 3;
    private Integer submarineHp = 2;
    private Integer destroyerHp = 1;


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
            String shipSign = getShipSign(row, column, enemy);
            deductShipHp(shipSign);
            addHit(row, column, enemy, (Board) this);
            printDestroyedShip();
            setIsGameRunning(enemy);
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

    private String getShipSign(String row, Integer column, Board player) {
        String[] technical = player.shipData.get(row);
        return technical[column - 1];
    }

    private void deductShipHp(String string) {
        switch (string) {
            case "1" -> destroyerHp--;
            case "2" -> submarineHp--;
            case "3" -> cruiserHp--;
            case "4" -> battleshipHp--;
            case "5" -> carrierHp--;
        }
    }

    private void printDestroyedShip(){
        if (destroyerHp == 0) {
            System.out.println("The enemy's Destroyer has been sunk! (length 1)");
            destroyerHp = 69;
        }
        if (submarineHp == 0) {
            System.out.println("The enemy's Submarine has been sunk! (length 2)");
            submarineHp = 69;
        }
        if (cruiserHp == 0) {
            System.out.println("The enemy's Cruiser has been sunk! (length 3)");
            cruiserHp = 69;
        }
        if (battleshipHp == 0) {
            System.out.println("The enemy's Battleship has been sunk! (length 4)");
            battleshipHp = 69;
        }
        if (carrierHp == 0) {
            System.out.println("The enemy's Carrier has been sunk! (length 5)");
            carrierHp = 69;
        }
    }

    private void setIsGameRunning(Board enemy) {
        if (enemy.getDestroyerHp() == 69
                && enemy.getSubmarineHp() == 69
        && enemy.getCruiserHp() == 69
        && enemy.getBattleshipHp() ==69
        && enemy.getCarrierHp() == 69) {
            isGameRunning = false;
        }
        isGameRunning = true;
    }

    public Integer getCarrierHp() {
        return carrierHp;
    }

    public Integer getBattleshipHp() {
        return battleshipHp;
    }

    public Integer getCruiserHp() {
        return cruiserHp;
    }

    public Integer getSubmarineHp() {
        return submarineHp;
    }

    public Integer getDestroyerHp() {
        return destroyerHp;
    }
}
