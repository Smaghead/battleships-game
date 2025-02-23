package kele.hw2;

public class Main {
    public static void main(String[] args) {
        UserInterface.greetUser();
        Board player1 = new Board();
        Board player2 = new Board();
        System.out.println("Player 1 add all ships");
        player1.addAllShipsToBoard();
        System.out.println("p2 fire");
        player2.fire(Validator.getValidRow(), Validator.getValidColumn(),player1);
        System.out.println("p1 fire");
        player1.fire(Validator.getValidRow(), Validator.getValidColumn(),player2);
        System.out.println("p2 fire");
        player2.fire(Validator.getValidRow(), Validator.getValidColumn(),player1);
//        player2.addAllShipsToBoard();
//        try {
//            Utility.validateIsValidMove("A", 1);
//            player1.addHit("A", 1);
//
//        } catch (Exception e) {
//            System.out.println("You shouldn't see this");
//        }
//        try {
//            Utility.validateIsValidMove("A", 1);
//            player1.addMiss("A", 1);
//        } catch (Exception e) {
//            System.out.println("You wanna see me!");
//            ;
//        }
        System.out.println("p1 board");
        player1.printBoard();
        System.out.println("p2 board");
        player2.printBoard();
//        System.out.println(player1.getName() + "'s board after miss on A1 and hit on C6");
//        player1.addMiss("A",1);
//        player1.addHit("C",6);
//        player1.printBoard();
//        Board player2 = new Board("Test2");
//        System.out.println(player2.getName() + "'s board after miss on C4 and hit on A3");
//        player2.addMiss("C",4);
//        player2.addHit("A", 3);
//        player2.printBoard();
    }
}
