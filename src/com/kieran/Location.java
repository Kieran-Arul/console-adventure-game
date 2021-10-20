package com.kieran;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Location implements Serializable {

    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    // Ensures serialised objects can be de-serialised properly
    // regardless of what implementation of compiler is being used
    private static final long serialVersionUID = 1L;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;

        if (exits != null) {

            this.exits = new LinkedHashMap<>(exits);

        } else {

            this.exits = new LinkedHashMap<>();

        }

        // Ensure we can quit the game from any location in the game
        this.exits.put("Q", 0);
    }

    public int getLocationID() {
        return this.locationID;
    }

    public String getDescription() {
        return this.description;
    }

    public Map<String, Integer> getExits() {
        return new LinkedHashMap<>(exits);
    }

    protected void addExit(String direction, int location) {
        this.exits.put(direction, location);
    }

}


