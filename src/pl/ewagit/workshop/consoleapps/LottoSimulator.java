package pl.ewagit.workshop.consoleapps;

import jdk.swing.interop.SwingInterOpUtils;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LottoSimulator {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        System.out.println("Podaj 6 liczb z zakresu 1-49");
        Scanner scan = new Scanner(System.in);

        int[] userNumbers = new int[6];
        int[] userCompare = new int[1];
        int k = 0;

        while (k < 6) {

            while (!scan.hasNextInt()) {
                System.out.println("niepoprawny format danych");
                scan.next();
            }

            int number = scan.nextInt();

            while (number > 49 || number < 1) {
                System.out.println("liczba ze złego zakresu podaj jeszcze raz");
                number = scan.nextInt();
            }
            userCompare[0] = number;

            for (int i = 0; i <= k; ) {

                if (userNumbers[i] == userCompare[0]) {

                    while (!scan.hasNextInt()) {
                        System.out.println("niepoprawny format danych");
                        scan.next();
                    }
                    userCompare[0] = scan.nextInt();
                    while (userCompare[0] > 49 || userCompare[0] < 1) {
                        System.out.println("liczba ze złego zakresu podaj jeszcze raz");
                        userCompare[0] = scan.nextInt();
                    }
                    i = -1;
                }
                i++;
            }

            userNumbers[k] = userCompare[0];
            k++;
        }

        Arrays.sort(userNumbers);
        System.out.println(Arrays.toString(userNumbers));
        int[] lottoNumbers = new int[6];
        int compare;
        Random r = new Random();
        int i = 0;
        while (i < lottoNumbers.length) {
            compare = 1 + r.nextInt(48);
            for (int j = 0; j < i; ) {
                if (compare == lottoNumbers[i]) {
                    compare = 1 + r.nextInt(48);
                    j = -1;
                }
                j++;
            }
            lottoNumbers[i] = compare;
            i++;
        }
        System.out.println(Arrays.toString(lottoNumbers));
        int count = 0;
        for (int l = 0; l < lottoNumbers.length; l++) {
            for (int m = 0; m < userNumbers.length; m++) {
                if (lottoNumbers[l] == userNumbers[m]) {
                    count++;
                }
            }
        }
        System.out.println("trafiłeś " + count + "liczbę");
    }
}





