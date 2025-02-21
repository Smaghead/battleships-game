package kele.hw2;

public class Main {
    public static void main(String[] args) {
        UserInterface.greetUser();
        Board player1 = new Board("Kele");
        player1.addAllShipsToBoard();
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
        player1.printBoard();
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
