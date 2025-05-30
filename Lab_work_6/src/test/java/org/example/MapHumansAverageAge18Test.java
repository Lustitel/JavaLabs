package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MapHumansAverageAge18Test {

    private Human human1;
    private Human human2;
    private Human human3;
    private Human human4;

    private Map<Integer, Human> mapHuman;

    @BeforeEach
    void setUp() {
        human1 = new Human("Иван", "Иванов", "Семёнович", 17); // < 18
        human2 = new Human("Максим", "Сергеев", "Олегович", 18); // == 18
        human3 = new Human("Василий", "Шилов", "Аланович", 25); // > 18
        human4 = new Human("Анна", "Петрова", "Игоревна", 16); // < 18

        mapHuman = new HashMap<>();
        mapHuman.put(1, human1);
        mapHuman.put(2, human2);
        mapHuman.put(3, human3);
        mapHuman.put(4, human4);
    }

    @Test
    void testCorrectFiltering() {
        List<Integer> expected = Arrays.asList(2, 3); // human2 и human3
        List<Integer> result = ListDemo.mapHumansAverageAge18(mapHuman);
        assertEquals(expected, result);
    }

    @Test
    void testEmptyMapThrowsException() {
        mapHuman.clear();
        assertThrows(IllegalArgumentException.class, () -> ListDemo.mapHumansAverageAge18(mapHuman));
    }

    @Test
    void testMapContainsNullKeyThrowsException() {
        mapHuman.put(null, human2);
        assertThrows(NullPointerException.class, () -> ListDemo.mapHumansAverageAge18(mapHuman));
    }

    @Test
    void testMapContainsNullValueThrowsException() {
        mapHuman.put(5, null);
        assertThrows(NullPointerException.class, () -> ListDemo.mapHumansAverageAge18(mapHuman));
    }

    @Test
    void testAllUnderageReturnsEmptyList() {
        Map<Integer, Human> underageMap = new HashMap<>();
        underageMap.put(1, new Human("А", "Б", "В", 10));
        underageMap.put(2, new Human("Г", "Д", "Е", 5));
        List<Integer> result = ListDemo.mapHumansAverageAge18(underageMap);
        assertEquals(Collections.emptyList(), result);
    }
}
