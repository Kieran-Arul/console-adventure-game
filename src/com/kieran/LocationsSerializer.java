package com.kieran;

import java.io.*;

public class LocationsSerializer {

    private static final GameDataReader LOCATIONS = new GameDataReader();

    public static void main(String[] args) throws IOException {

        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {

            for (Location location: LOCATIONS.values()) {

                locFile.writeObject(location);

            }

        }

    }

}
