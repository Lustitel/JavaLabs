package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testConstructorAndGetters() {
        Person person = new Person("Иванович", "Иван", "Иванов", "1980.01.01");

        assertEquals("Иванович", person.getLastName());
        assertEquals("Иван", person.getFirstName());
        assertEquals("Иванов", person.getMiddleName());
        assertEquals("1980.01.01", person.getBirthDate());
    }

    @Test
    void testSetters() {
        Person person = new Person();

        person.setLastName("Петров");
        person.setFirstName("Петр");
        person.setMiddleName("Петрович");
        person.setBirthDate("1990.05.10");

        assertEquals("Петров", person.getLastName());
        assertEquals("Петр", person.getFirstName());
        assertEquals("Петрович", person.getMiddleName());
        assertEquals("1990.05.10", person.getBirthDate());
    }

    @Test
    void testEqualsAndHashCode() {
        Person p1 = new Person("Сидорович", "Сидор", "Сидоров", "1970.03.03");
        Person p2 = new Person("Сидорович", "Сидор", "Сидоров", "1970.03.03");
        Person p3 = new Person("Александрович", "Александр", "Александров", "2000.01.01");

        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
        assertNotEquals(p1, p3);
    }

    @Test
    void testToStringContainsKeyFields() {
        Person person = new Person("Кузьмич", "Кузьма", "Кузнецов", "1985.10.10");

        String output = person.toString();

        assertTrue(output.contains("Кузнецов"));
        assertTrue(output.contains("Кузьма"));
        assertTrue(output.contains("Кузьмич"));
        assertTrue(output.contains("1985.10.10"));
    }
}