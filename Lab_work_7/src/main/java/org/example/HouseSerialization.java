package org.example;

import java.io.*;

// Класс для сериализации и десериализации объектов House в поток и из потока
public class HouseSerialization {
    public static void serializeHouse(House house, OutputStream output) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(output)) {oos.writeObject(house);}
    }

    public static House deserializeHouse(InputStream input) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(input)) {return (House) ois.readObject();}
    }
}