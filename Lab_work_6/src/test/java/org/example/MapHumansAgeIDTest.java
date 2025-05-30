package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MapHumansAgeIDTest {

    private Human human1;
    private Human human2;
    private Human human3;
    private Map<Integer, Human> mapHuman;

    @BeforeEach
    void setUp() {
        human1 = new Human("Иван", "Иванов", "Семёнович", 17);
        human2 = new Human("Максим", "Сергеев", "Олегович", 18);
        human3 = new Human("Василий", "Шилов", "Аланович", 25);

        mapHuman = new HashMap<>();
        mapHuman.put(1, human1);
        mapHuman.put(2, human2);
        mapHuman.put(3, human3);
    }

    @Test
    void testCorrectMapping() {
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 17);
        expected.put(2, 18);
        expected.put(3, 25);

        Map<Integer, Integer> result = ListDemo.mapHumansAgeID(mapHuman);
        assertEquals(expected, result);
    }

    @Test
    void testEmptyMapThrowsException() {
        mapHuman.clear();
        assertThrows(IllegalArgumentException.class, () -> ListDemo.mapHumansAgeID(mapHuman));
    }

    @Test
    void testNullKeyThrowsException() {
        mapHuman.put(null, human1);
        assertThrows(NullPointerException.class, () -> ListDemo.mapHumansAgeID(mapHuman));
    }

    @Test
    void testNullValueThrowsException() {
        mapHuman.put(4, null);
        assertThrows(NullPointerException.class, () -> ListDemo.mapHumansAgeID(mapHuman));
    }

    @Test
    void testOnlyOneEntry() {
        mapHuman.clear();
        mapHuman.put(10, new Human("А", "Б", "В", 42));
        Map<Integer, Integer> result = ListDemo.mapHumansAgeID(mapHuman);
        assertEquals(Collections.singletonMap(10, 42), result);
    }
}
