package kele.hw2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        UserInterface.initGame();
        while (ShotHandler.getIsGameRunning()) {
            UserInterface.mainGameLoop();
        }
        UserInterface.endScreen();
    }
}
