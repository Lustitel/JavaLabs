package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class HouseTest {
    @Test
    void testConstructorAndGetters() {
        Person manager = new Person("Иванович", "Иван", "Иванов", "1980.01.01");
        Person owner = new Person("Петрович", "Петр", "Петров", "1990.05.10");
        Flat flat = new Flat(1, 45.0, List.of(owner));
        House house = new House("123-456", "ул. Ленина, д.1", manager, List.of(flat));

        assertEquals("123-456", house.getCadastralNumber());
        assertEquals("ул. Ленина, д.1", house.getAddress());

    }

    @Test
    void testSetters() {
        House house = new House();

        house.setCadastralNumber("999-999");
        house.setAddress("пр. Мира, д.2");

        assertEquals("999-999", house.getCadastralNumber());
        assertEquals("пр. Мира, д.2", house.getAddress());
    }

    @Test
    void testEqualsAndHashCode() {
        Person manager = new Person("Кузьмич", "Кузьма", "Кузнецов", "1985.08.15");
        Flat flat = new Flat(3, 70.0, List.of(manager));

        House house1 = new House("111-222", "ул. Свободы, д.3", manager, List.of(flat));
        House house2 = new House("111-222", "ул. Свободы, д.3", manager, List.of(flat));
        House house3 = new House("333-444", "ул. Победы, д.5", manager, List.of(flat));

        assertEquals(house1, house2);
        assertEquals(house1.hashCode(), house2.hashCode());
        assertNotEquals(house1, house3);
    }

    @Test
    void testToStringContainsInfo() {
        Person manager = new Person("Васильевич", "Василий", "Васильев", "1992.12.12");
        Flat flat = new Flat(5, 80.0, List.of(manager));
        House house = new House("AB-321", "ул. Гагарина, д.10", manager, List.of(flat));

        String output = house.toString();

        assertTrue(output.contains("AB-321"));
        assertTrue(output.contains("ул. Гагарина"));
        assertTrue(output.contains("Васильев"));

    }
}