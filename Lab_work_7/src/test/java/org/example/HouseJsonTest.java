package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class HouseJsonTest {
    private final Person person = new Person("Иванович", "Иван", "Иванов", "01.01.1990");
    private final House testHouse = new House("123", "ул. Ленина", person,
            List.of(new Flat(1, 50, List.of(person))));

    @Test
    void fullCycleWorks() throws Exception {
        String json = HouseJson.serializeToJson(testHouse);
        House result = HouseJson.deserializeFromJson(json);

        assertEquals(testHouse.getCadastralNumber(), result.getCadastralNumber());
        assertEquals(testHouse.getAddress(), result.getAddress());
    }

    @Test
    void handlesEmptyHouse() throws Exception {
        House empty = new House(null, null, null, List.of());
        String json = HouseJson.serializeToJson(empty);
        assertNotNull(HouseJson.deserializeFromJson(json));
    }

}