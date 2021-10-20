package com.kieran;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final LocationsDeserializer LOCATIONS = new LocationsDeserializer();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");

        int loc = 1;

        while (true) {

            System.out.println(LOCATIONS.get(loc).getDescription());

            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = LOCATIONS.get(loc).getExits();
            System.out.print("Available exits are ");

            for (String exit: exits.keySet()) {

                System.out.print(exit + ", ");

            }

            System.out.println();

            String direction = scanner.nextLine().toUpperCase();

            if (direction.length() > 1) {

                String[] words = direction.split(" ");

                for (String word: words) {

                    if (vocabulary.containsKey(word)) {

                        direction = vocabulary.get(word);
                        break;

                    }

                }

            }

            if (exits.containsKey(direction)) {

                loc = exits.get(direction);

            } else {

                System.out.println("Invalid Direction");

            }

        }

        scanner.close();

    }

}
