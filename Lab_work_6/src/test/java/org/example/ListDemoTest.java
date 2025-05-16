package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class ListDemoTest {
    //Test task 2 start
    @Test
    void testSameNameListReturnsMatchingHumans() {
        Human dude = new Human("Иван", "Иванов", "Петрович", 30);
        List<Human> input = List.of(
                new Human("Андрей", "Петров", "Иванович", 25),
                new Human("Ольга", "Иванова", "Сергеевна", 22),
                new Human("Сергей", "Иванов", "Александрович", 35)
        );

        List<Human> result = new ListDemo().sameNameList(input, dude);

        // Ожидается: 1 человек с фамилией "Иванов", но метод добавляет самого dude
        List<Human> expected = List.of(new Human("Сергей", "Иванов", "Александрович", 35));
        assertEquals(expected, result);

    }

    @Test
    void inputListIsNull() {
        Human dude = new Human("Иван", "Иванов", "Петрович", 30);
        assertThrows(IllegalArgumentException.class, () -> new ListDemo().sameNameList(null, dude));
    }

    @Test
    void inputListIsEmpty() {
        Human dude = new Human("Иван", "Иванов", "Петрович", 30);
        assertThrows(IllegalArgumentException.class, () -> new ListDemo().sameNameList(new ArrayList<>(), dude));
    }

    @Test
    void dudeIsNull() {
        List<Human> input = List.of(new Human("Андрей", "Петров", "Иванович", 25));
        assertThrows(IllegalArgumentException.class, () -> new ListDemo().sameNameList(input, null));
    }

    @Test
    void dudeSecondNameIsEmpty() {
        Human dude = new Human("Иван", "", "Петрович", 30);
        List<Human> input = List.of(new Human("Сергей", "Иванов", "Александрович", 35));
        assertThrows(IllegalArgumentException.class, () -> new ListDemo().sameNameList(input, dude));
    }

    @Test
    void elementInListIsNull() {
        Human dude = new Human("Иван", "Иванов", "Петрович", 30);
        List<Human> input = new ArrayList<>();
        input.add(new Human("Сергей", "Иванов", "Александрович", 35));
        input.add(null); // ошибка
        assertThrows(IllegalArgumentException.class, () -> new ListDemo().sameNameList(input, dude));
    }

    @Test
    void elementSecondNameIsEmpty() {
        Human dude = new Human("Иван", "Иванов", "Петрович", 30);
        List<Human> input = List.of(new Human("Сергей", "", "Александрович", 35));
        assertThrows(IllegalArgumentException.class, () -> new ListDemo().sameNameList(input, dude));
    }
    //Test task 2 end

    //Test task 3 start
    @Test
    void testCopyWithoutSelected() {
        Human h1 = new Human("Иван", "Иванов", "Петрович", 30);
        Human h2 = new Human("Ольга", "Петрова", "Сергеевна", 25);
        Human h3 = new Human("Иван", "Иванов", "Петрович", 30); // дубликат h1 по equals

        List<Human> input = List.of(h1, h2, h3);
        List<Human> result = new ListDemo().copyWithoutSelectedList(input, h1);
        assertEquals(1, result.size());
        assertEquals(h2, result.get(0));
    }

    @Test
    void testCopyListIndependence() {
        Human h1 = new Human("Иван", "Иванов", "Петрович", 30);
        Human h2 = new Human("Ольга", "Петрова", "Сергеевна", 25);

        List<Human> input = List.of(h1, h2);
        List<Human> result = new ListDemo().copyWithoutSelectedList(input, h1);

        // Меняем исходный список — результат не должен измениться
        h2.setFirstName("Мария");

        assertNotEquals("Мария", result.get(0).getFirstName());
        assertEquals("Ольга", result.get(0).getFirstName());
    }

    @Test
    void inputCopyListIsNull() {
        Human unwanted = new Human("Иван", "Иванов", "Петрович", 30);
        assertThrows(IllegalArgumentException.class, () -> new ListDemo().copyWithoutSelectedList(null, unwanted));
    }

    @Test
    void inputCopyListIsEmpty() {
        Human unwanted = new Human("Иван", "Иванов", "Петрович", 30);
        assertThrows(IllegalArgumentException.class, () -> new ListDemo().copyWithoutSelectedList(new ArrayList<>(), unwanted));
    }

    @Test
    void UnwantedIsNull() {
        Human h = new Human("Ольга", "Петрова", "Сергеевна", 25);
        List<Human> list = List.of(h);
        assertThrows(IllegalArgumentException.class, () -> new ListDemo().copyWithoutSelectedList(list, null));
    }

    @Test
    void copyListContainsNull() {
        Human h = new Human("Ольга", "Петрова", "Сергеевна", 25);
        List<Human> list = new ArrayList<>();
        list.add(h);
        list.add(null);
        assertThrows(IllegalArgumentException.class, () -> new ListDemo().copyWithoutSelectedList(list, h));
    }
    //Test task 3 end

    //Test task 5 start
    @Test
    void testOneEldest() {
        List<Human> humans = List.of(
                new Human("Иван", "Алексеевич", "Донцов", 20),
                new Human("Мария", "Борисовна", "Смирнова", 22),
                new Human("Николай", "Викторович", "Леонов", 21)
        );

        Set<Human> result = ListDemo.elderStudentsList(humans);

        assertEquals(1, result.size());
        assertTrue(result.contains(new Human("Мария", "Борисовна", "Смирнова", 22)));
    }

    @Test
    void testMultipleEldest() {
        List<Human> humans = List.of(
                new Human("Алиса", "Андреевна", "Иванова", 25),
                new Human("Борис", "Борисович", "Миллер", 25),
                new Human("Кирилл", "Сергеевич", "Чернов", 22)
        );

        Set<Human> result = ListDemo.elderStudentsList(humans);

        assertEquals(2, result.size());
        assertTrue(result.contains(new Human("Алиса", "Андреевна", "Иванова", 25)));
        assertTrue(result.contains(new Human("Борис", "Борисович", "Миллер", 25)));
    }

    @Test
    void testOnlyOneHuman() {
        List<Human> humans = List.of(new Human("Дмитрий", "Игоревич", "Соловьёв", 30));
        Set<Human> result = ListDemo.elderStudentsList(humans);

        assertEquals(1, result.size());
        assertTrue(result.contains(new Human("Дмитрий", "Игоревич", "Соловьёв", 30)));
    }

    @Test
    void testNullElementInList() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Анна", "Александровна", "Яровая", 18));
        humans.add(null);

        assertThrows(IllegalArgumentException.class, () -> {ListDemo.elderStudentsList(humans);});
    }

    @Test
    void testEmptyList() {
        List<Human> humans = new ArrayList<>();

        assertThrows(IllegalArgumentException.class, () -> {ListDemo.elderStudentsList(humans);});
    }
    //Test task 5 end;
}
