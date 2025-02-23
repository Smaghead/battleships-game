package kele.hw2;

import java.util.concurrent.TimeUnit;

public class UserInterface extends Board {
    static Board player1 = new Board();
    static Board player2 = new Board();
    private static Boolean turnTracker = true;


    public static void initGame() {
        greetUser();
        createPlayers();
        System.out.println(player1.getName() + " place all 5 of your ships to the board");
        player1.addAllShipsToBoard();
        Utility.clearScreen();
        System.out.println(player2.getName() + " place all 5 of your ships to the board");
        player2.addAllShipsToBoard();
        Utility.clearScreen();
    }

    public static void mainGameLoop() throws InterruptedException {
        while (ShotHandler.getGameRunning() && turnTracker) {
            System.out.println("It's your turn to fire " + player1.getName());
            player1.printBoard();
            System.out.println("Ship(s) that has been already sunken:");
            ShotHandler.printDestroyedShip(player2);
            player1.fireAction(player2);
            turnTracker = false;
            TimeUnit.SECONDS.sleep(5);
            Utility.clearScreen();
        }
        while (ShotHandler.getGameRunning() && !turnTracker) {
            System.out.println("It's your turn to fire " + player2.getName());
            player2.printBoard();
            System.out.println("Ship(s) that has been already sunken:");
            ShotHandler.printDestroyedShip(player1);
            player2.fireAction(player1);
            turnTracker = true;
            TimeUnit.SECONDS.sleep(5);
            Utility.clearScreen();
        }
    }

    private static void greetUser() {
        System.out.println("Starting Battleships by Smagh, have fun!");
        System.out.println("______       _   _   _           _     _           ");
        System.out.println("| ___ \\     | | | | | |         | |   (_)          ");
        System.out.println("| |_/ / __ _| |_| |_| | ___  ___| |__  _ _ __  ___");
        System.out.println("| ___ \\/ _` | __| __| |/ _ \\/ __| '_ \\| | '_ \\/ __|");
        System.out.println("| |_/ / (_| | |_| |_| |  __/\\__ \\ | | | | |_) \\__ \\");
        System.out.println("\\____/ \\__,_|\\__|\\__|_|\\___||___/_| |_|_| .__/|___/");
        System.out.println("                                        | |        ");
        System.out.println("                                        | |        ");
        System.out.println("                                -Hesitation is defeat!");
    }

    private static void createPlayers() {
        player1.setName(Utility.getStringInput("Player 1 what is your nickname?"));
        player2.setName(Utility.getStringInput("Player 2 what is your nickname?"));
    }


}
