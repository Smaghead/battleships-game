package kele.hw2;

/**
 * General notes:
 *  1. noticed you are using static keyword a lot;
 *      I understand using static keyboard make it easier but that will change the scope of an object and potentially memory issue
 *  2. YOu are not using the magic of method parameters at all, which could be due to static keyword as well but use it more often.
 *  3. The same as point 2 goes for constructor, they are powerful tools.
 *  4. It is nice to use your own consume Exception class ("InvalidMoveException"), it would even make it more fascinating to define your own methods as well;
 *      That would give you the power to control what you want to show to user and improves your exception handling + message.
 *      - I put an example method in the exception class.
 *  5. There is no difference between System.out.println(); and System.out.println(""); - nothing serious but you can remove double quotations "".
 *  6. Generally it is better to user Logger (e.g. log4j) to log events.
 *  7. It is better to move name object (the users' name from Board class) with its getter and setter to a POJO class with final - check UserInputData class.
 *  8. Similarly to name object, the carrierHp, battleshipHp, cruiserHp, submarineHp, and destroyerHp (from ShotHandler class)
 *     can (highly suggested) be moved to a proper POJO class.
 *  9. The isRowValid and isColumnValid validator are good but, you could use regex to check user's input;
 *     also you need to consider that Java is case-sensitive meaning a user input for Horizontal is different to horizontal, to avoid issue,
 *     you can use equalsIgnoreCase instead of equals which will take care of user input uppercase or lowercase
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // I would suggest to instantiate the classes here or find a better way -> this way you won't need to static keyboard in other classes
        UserInterface.initGame();
        while (ShotHandler.getIsGameRunning()) {
            UserInterface.mainGameLoop();
        }
        UserInterface.endScreen();
    }
}
