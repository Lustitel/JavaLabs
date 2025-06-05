package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlatTest {

    @Test
    void testConstructorAndGetters() {
        Person owner = new Person("Иванович", "Иван", "Иванов", "1980.01.01");
        Flat flat = new Flat(1, 45.5, List.of(owner));

        assertEquals(1, flat.getNumber());
        assertEquals(45.5, flat.getArea());
    }

    @Test
    void testSetters() {
        Flat flat = new Flat();

        flat.setNumber(2);
        flat.setArea(60.0);

        assertEquals(2, flat.getNumber());
        assertEquals(60.0, flat.getArea());
    }

    @Test
    void testEqualsAndHashCode() {
        Person owner = new Person("Сидорович", "Сидор", "Сидоров", "1975.03.20");
        Flat f1 = new Flat(3, 75.0, List.of(owner));
        Flat f2 = new Flat(3, 75.0, List.of(owner));
        Flat f3 = new Flat(4, 80.0, List.of(owner));

        assertEquals(f1, f2);
        assertEquals(f1.hashCode(), f2.hashCode());
        assertNotEquals(f1, f3);
    }

    @Test
    void testToStringIncludesDetails() {
        Person owner = new Person("Кузьмич", "Кузьма", "Кузнецов", "1985.08.15");
        Flat flat = new Flat(5, 88, List.of(owner));

        String output = flat.toString();

        assertTrue(output.contains("Flat"));
        assertTrue(output.contains("5"));
        assertTrue(output.contains("88"));
        assertTrue(output.contains("Кузнецов"));
    }
}