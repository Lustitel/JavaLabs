package org.example;

import java.io.*;

public class HouseSerialization {
    public static void serializeHouse(House house, OutputStream output) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(output)) {oos.writeObject(house);}
    }

    public static House deserializeHouse(InputStream input) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(input)) {return (House) ois.readObject();}
    }
}