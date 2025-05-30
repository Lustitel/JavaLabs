package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MapAgeHumansListTest {

    private Human human1;
    private Human human2;
    private Human human3;
    private Human human4;

    private Set<Human> humanSet;

    @BeforeEach
    void setUp() {
        human1 = new Human("Иван", "Иванов", "Семёнович", 18);
        human2 = new Human("Максим", "Сергеев", "Олегович", 25);
        human3 = new Human("Василий", "Шилов", "Аланович", 18);
        human4 = new Human("Олег", "Петров", "Иванович", 30);

        humanSet = new HashSet<>(Arrays.asList(human1, human2, human3, human4));
    }

    @Test
    void testCorrectAgeGrouping() {
        Map<Integer, List<Human>> result = ListDemo.mapAgeHumansList(humanSet);

        assertEquals(3, result.size());

        assertTrue(result.containsKey(18));
        assertTrue(result.get(18).containsAll(List.of(human1, human3)));
        assertEquals(2, result.get(18).size());

        assertEquals(List.of(human2), result.get(25));
        assertEquals(List.of(human4), result.get(30));
    }

    @Test
    void testEmptyInputThrowsException() {
        humanSet.clear();
        assertThrows(IllegalArgumentException.class, () -> ListDemo.mapAgeHumansList(humanSet));
    }

    @Test
    void testSetContainsNullThrowsException() {
        humanSet.add(null);
        assertThrows(NullPointerException.class, () -> ListDemo.mapAgeHumansList(humanSet));
    }

    @Test
    void testSameAgeAllHumans() {
        Human a = new Human("А", "Б", "В", 20);
        Human b = new Human("Г", "Д", "Е", 20);
        Set<Human> sameAgeSet = new HashSet<>(List.of(a, b));

        Map<Integer, List<Human>> result = ListDemo.mapAgeHumansList(sameAgeSet);
        assertEquals(1, result.size());
        assertTrue(result.containsKey(20));
        assertTrue(result.get(20).containsAll(List.of(a, b)));
    }

    @Test
    void testOneHuman() {
        Set<Human> one = Set.of(human4);
        Map<Integer, List<Human>> result = ListDemo.mapAgeHumansList(one);

        assertEquals(1, result.size());
        assertTrue(result.containsKey(30));
        assertEquals(List.of(human4), result.get(30));
    }
}
