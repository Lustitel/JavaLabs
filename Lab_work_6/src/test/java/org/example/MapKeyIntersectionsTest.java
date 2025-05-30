package org.example;
import org.junit.jupiter.api.Test;

import java.util.*;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MapKeyIntersectionsTest {
    private Human human1;
    private Human human2;
    private Human human3;

    private Map<Integer, Human> mapHuman;
    private Set<Integer> keySet;

    @BeforeEach
    void setUp() {
        human1 = new Human("Иван", "Иванов", "Семёнович", 13);
        human2 = new Human("Максим", "Сергеев", "Олегович", 22);
        human3 = new Human("Василий", "Шилов", "Аланович", 13);

        mapHuman = new HashMap<>();
        mapHuman.put(1, human1);
        mapHuman.put(2, human2);
        mapHuman.put(3, human3);

        keySet = new HashSet<>(Arrays.asList(1, 3));
    }

    @Test
    void testCorrectIntersection() {
        Set<Human> expected = new HashSet<>(Arrays.asList(human1, human3));
        Set<Human> result = ListDemo.mapHumansIntersectionSet(mapHuman, keySet);
        assertEquals(expected, result);
    }

    @Test
    void testEmptyMap() {
        mapHuman.clear();
        assertThrows(IllegalArgumentException.class, () -> ListDemo.mapHumansIntersectionSet(mapHuman, keySet));
    }

    @Test
    void testEmptySet() {
        keySet.clear();
        assertThrows(IllegalArgumentException.class, () -> ListDemo.mapHumansIntersectionSet(mapHuman, keySet));
    }

    @Test
    void testSetContainsNull() {
        keySet.add(null);
        assertThrows(NullPointerException.class, () -> ListDemo.mapHumansIntersectionSet(mapHuman, keySet));
    }

    @Test
    void testNoIntersectionReturnsEmptySet() {
        Set<Integer> ids = new HashSet<>(Arrays.asList(10, 20));
        Set<Human> result = ListDemo.mapHumansIntersectionSet(mapHuman, ids);
        assertEquals(Collections.emptySet(), result);
    }
}