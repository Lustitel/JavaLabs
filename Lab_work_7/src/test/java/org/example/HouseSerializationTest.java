package org.example;

import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class HouseSerializationServiceTest {

    @Test
    void testSerializeAndDeserializeHouse() throws Exception {
        Person person = new Person("Иванович", "Иван", "Иванов", "01.01.1990");
        House originalHouse = new House("123", "ул. Ленина", person, List.of(new Flat(1, 50, List.of(person))));

        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        HouseSerialization.serializeHouse(originalHouse, byteOut);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        House deserializedHouse = HouseSerialization.deserializeHouse(byteIn);

        assertEquals(originalHouse.getCadastralNumber(), deserializedHouse.getCadastralNumber());
        assertEquals(originalHouse.getAddress(), deserializedHouse.getAddress());
    }

}