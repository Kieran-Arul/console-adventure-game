package com.kieran;

import java.io.*;
import java.util.*;

public class LocationsDeserializer implements Map<Integer, Location> {

    private static final Map<Integer, Location> GAME_LOCATIONS = new LinkedHashMap<>();

    static {

        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {

            boolean eof = false;

            while (!eof) {

                try {

                    // Perform de-serialization
                    Location gameLocation = (Location) locFile.readObject();

                    GAME_LOCATIONS.put(gameLocation.getLocationID(), gameLocation);

                } catch (EOFException e) {

                    eof = true;

                }

            }

            // Allows us to distinguish between EOF exceptions occurring, which would be expected,
            // and these ClassNotFoundException occurring which would not be expected
        } catch (IOException | ClassNotFoundException e) {

            e.printStackTrace();

        }
    }

    // ***************************** INSTANCE METHODS *****************************

    @Override
    public int size() {
        return GAME_LOCATIONS.size();
    }

    @Override
    public boolean isEmpty() {
        return GAME_LOCATIONS.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return GAME_LOCATIONS.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return GAME_LOCATIONS.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return GAME_LOCATIONS.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return GAME_LOCATIONS.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return GAME_LOCATIONS.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
        System.out.println("No putAll method for this object");
    }

    @Override
    public void clear() {
        GAME_LOCATIONS.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return GAME_LOCATIONS.keySet();
    }

    @Override
    public Collection<Location> values() {
        return GAME_LOCATIONS.values();
    }

    @Override
    public Set<Map.Entry<Integer, Location>> entrySet() {
        return GAME_LOCATIONS.entrySet();
    }

}


