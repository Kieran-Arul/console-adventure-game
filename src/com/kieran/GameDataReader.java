package com.kieran;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GameDataReader implements Map<Integer, Location> {

    private static final Map<Integer, Location> LOCATIONS = new LinkedHashMap<>();

    static {

        try (Scanner scanner = new Scanner(new FileReader("locations.txt"))) {

            while (scanner.hasNextLine()) {

                String[] locationInfo = scanner.nextLine().split(",", 2);

                int loc = Integer.parseInt(locationInfo[0]);
                String description = locationInfo[1];

                System.out.println("Imported loc: " + loc + ": " + description);

                Map<String, Integer> tempExit = new HashMap<>();

                LOCATIONS.put(loc, new Location(loc, description, tempExit));

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("directions.txt")))) {

            while (scanner.hasNextLine()) {

                String[] exitInfo = scanner.nextLine().split(",");

                // Gets the information we want from the array
                int currentLoc = Integer.parseInt(exitInfo[0]);
                String exitDirection = exitInfo[1];
                int destinationLoc = Integer.parseInt(exitInfo[2]);

                System.out.println(currentLoc + ": " + exitDirection + ": " + destinationLoc);

                Location location = LOCATIONS.get(currentLoc);

                location.addExit(exitDirection, destinationLoc);

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    // ***************************** INSTANCE METHODS *****************************

    @Override
    public int size() {
        return LOCATIONS.size();
    }

    @Override
    public boolean isEmpty() {
        return LOCATIONS.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return LOCATIONS.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return LOCATIONS.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return LOCATIONS.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return LOCATIONS.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return LOCATIONS.remove(key);
    }

    // putAll method will not work for this object
    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
        System.out.println("No putAll method for this object");
    }

    @Override
    public void clear() {
        LOCATIONS.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return LOCATIONS.keySet();
    }

    @Override
    public Collection<Location> values() {
        return LOCATIONS.values();
    }

    @Override
    public Set<Map.Entry<Integer, Location>> entrySet() {
        return LOCATIONS.entrySet();
    }

}

