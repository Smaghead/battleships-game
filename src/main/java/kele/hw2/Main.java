package kele.hw2;

public class Main {
    public static void main(String[] args) {
        UserInterface.greetUser();
        Board player1 = new Board("Kele");
        player1.addShip("A",2,2,"vertical","right");
        player1.addShip("B",4,3,"vertical","left");
        player1.addShip("C",3,4,"horizontal","below");
        player1.addShip("F",5,5,"horizontal","above");
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
