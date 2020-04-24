package pl.ewagit.workshop.consoleapps;

import java.util.Scanner;

public class GuessNumber2 {
    public static void main(String[] args) {
        run();
    }

    public static void run() {

        Scanner scan = new Scanner(System.in);
        System.out.println("pomyśl liczbę od 0 do 1000 a ja ją zgadnę w max 10 próbach");
        int min = 0;
        int max = 1000;
        int p = 0;
        int guess = 0;
//        int guess = ((max - min) / 2) + min;
        while (p < 11) {
            guess = ((max - min) / 2) + min;
            System.out.println("zgaduję: " + guess);
            System.out.println("podaj podpowiedź: za mało, za dużo lub zgadłeś");
            String userRespond = scan.nextLine();
            if (userRespond.equalsIgnoreCase("zgadłeś")) {
                System.out.println("Wygrałem!");
                return;
            } else if (userRespond.equalsIgnoreCase("za dużo")) {
                max = guess;
            } else if (userRespond.equalsIgnoreCase("za mało")) {
                min = guess;
            } else {
                System.out.println("nie oszukuj!");
                p--;
            } p++;
        }
        System.out.println(guess);


    }
}
