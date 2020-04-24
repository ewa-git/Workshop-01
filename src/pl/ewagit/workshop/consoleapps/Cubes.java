package pl.ewagit.workshop.consoleapps;

import java.util.Random;

public class Cubes {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        String cube = "D3-20";
        int roll = 0;
        int cubeType = 0;
        double add = 0;
        String cubeSides;
        String cubeAdd;


        if (Character.isDigit(cube.charAt(0))) {
            String rollAmount = cube.substring(0, 1);
            try {
                roll = Integer.parseInt(rollAmount);
            } catch (IllegalArgumentException e) {
                System.out.println("blad w zapisie operacji");
            }

        } else {
            roll = 1;
        }
        for (int i = 0; i < cube.length(); i++) {
            if (cube.charAt(i) == ('D')) {
                for (int j = i+1; j < cube.length(); j++) {
                    if (cube.charAt(j) == ('+')) {
                        cubeSides = cube.substring(i + 1, cube.lastIndexOf('+'));
                        cubeAdd = cube.substring(cube.lastIndexOf('+'));
                        try {
                            cubeType = Integer.parseInt(cubeSides);
                            add = Double.parseDouble(cubeAdd);
                        } catch (IllegalArgumentException e) {
                            System.out.println("niepoprawny format danych");
                        } break;
                    } else if (cube.charAt(j) == ('-')) {
                        cubeSides = cube.substring(i + 1, cube.lastIndexOf('-'));
                        cubeAdd = cube.substring(cube.lastIndexOf('-'));
                        try {
                            cubeType = Integer.parseInt(cubeSides);
                            add = Double.parseDouble(cubeAdd);
                        } catch (IllegalArgumentException e) {
                            System.out.println("niepoprawny format danych");
                        } break;
                    } else {
                        cubeSides = cube.substring(i + 1);

                        try {
                            cubeType = Integer.parseInt(cubeSides);
                            add = 0;
                        } catch (IllegalArgumentException e) {

                        }
                    }
                }

            }

        }
        Random r = new Random();
        int[] randomValue = new int[roll];
        int randomAdd = 0;
        for (int n =0; n<roll; n++){
            randomValue[n] = 1 + r.nextInt(cubeType);
            randomAdd += randomValue[n];
        }

        double result =randomAdd+add;
        System.out.println(roll + " " + cubeType + " " + add);
        System.out.println(randomAdd);
        System.out.println(result);


    }
}
