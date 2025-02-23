package kele.hw2;

public class Main {
    public static void main(String[] args) {
        UserInterface.initGame();
        while (ShotHandler.getGameRunning()) {
            UserInterface.mainGameLoop();
        }
    }
}
