package pl.ewagit.workshop.consoleapps;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        printWelcomeMessage();
        while (true) {
            showMenu();
            String userInput = getDecision();
            if (validAction(userInput)) {
                if (isExitAction(userInput)) {
                    exitAction();
                    break;
                }
                executeAction(userInput);
            }
        }
        printGoodbyeMessage();

    }

    private static void executeAction(String userInput) {
        String correctedInput = userInput.trim().toLowerCase();
        if ("1".equals(correctedInput)) {
            GuessNumber.run();
        } else if ("2".equals(correctedInput)) {
            LottoSimulator.run();
        } else if ("3".equals(correctedInput)) {
            GuessNumber2.run();
        } else if ("4".equals(correctedInput)) {
            Cubes.run();
        } else if ("5".equals(correctedInput)) {
            MostPopular.run();
        }
    }

    private static void exitAction() {
        System.out.println("Kończę działanie...");
    }

    private static boolean isExitAction(String userInput) {
        return "6".equals(userInput.trim().toLowerCase());
    }

    private static boolean validAction(String userInput) {
        String correctInput = userInput.trim().toLowerCase();
        String[] validActions = {"1", "2", "3", "4", "5", "6"};
        Arrays.sort(validActions);
        int index = Arrays.binarySearch(validActions, correctInput);
        return index >= 0;
    }

    private static String getDecision() {
        System.out.println("Podaj liczbę reprezentującą grę w którą chcesz zagrac");
        Scanner scan = new Scanner(System.in);


        String decision = scan.nextLine();

        return decision;
    }

    private static void showMenu() {
        System.out.println("Menu\n");
        System.out.println("(1) Gra w zgadywanie liczb");
        System.out.println("(2) Symulator LOTTO");
        System.out.println("(3) Gra w zgadywanie liczb2");
        System.out.println("(4) Kostka do gry");
        System.out.println("(5) Wyszukiwarka najpopularniejszych słów");
        System.out.println("(6) Exit");
    }

    private static void printGoodbyeMessage() {
        System.out.println("Miło było, do zobaczenia");
    }

    private static void printWelcomeMessage() {
        System.out.println("Witaj w naszym programie");
    }
}
