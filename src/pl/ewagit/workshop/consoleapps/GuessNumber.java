package pl.ewagit.workshop.consoleapps;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Random r = new Random();
        int toGuess = 1+ r.nextInt(100);


        int userGuess = getNumber();
        while (true) {
            if (userGuess < toGuess) {
                System.out.println("za mało");
                userGuess = getNumber();
            } else if (userGuess > toGuess) {
                System.out.println("za dużo");
                userGuess = getNumber();

            }
            else {
                System.out.println("zgadłes");
                break;
            }
        }


    }

    public static int getNumber() {
        System.out.println("Zgadnij liczbę");
        Scanner scan = new Scanner(System.in);

        while (!scan.hasNextInt()) {
            System.out.println("To nie jest liczba. Zgadnij liczbę:");
            scan.next();
        }
        int userGuess = scan.nextInt();
        return userGuess;
    }
}
