package org.example.filter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InterfaceTest {

    @Test
    public void testBeginStringFilter() {
        String str = "Мама мыла раму";

        // Создаем фильтр для проверки начала строки
        BeginStringFilter beginFilter1 = new BeginStringFilter("Мама");
        BeginStringFilter beginFilter2 = new BeginStringFilter("мыла");

        // Проверяем, что фильтр правильно работает
        assertTrue(beginFilter1.apply(str), "Строка должна начинаться с 'Мама'");
        assertFalse(beginFilter2.apply(str), "Строка не должна начинаться с 'мыла'");
    }

    @Test
    public void testEndStringFilter() {
        String str = "Мама мыла раму";

        // Создаем фильтр для проверки конца строки
        EndStringFilter endFilter1 = new EndStringFilter("раму");
        EndStringFilter endFilter2 = new EndStringFilter("мыла");

        // Проверяем, что фильтр правильно работает
        assertTrue(endFilter1.apply(str), "Строка должна заканчиваться на 'раму'");
        assertFalse(endFilter2.apply(str), "Строка не должна заканчиваться на 'мыла'");
    }

    @Test
    public void testContainsStringFilter() {
        String str = "Мама мыла раму";

        // Создаем фильтр для проверки наличия подстроки
        ContainsStringFilter containsFilter1 = new ContainsStringFilter("мыла");
        ContainsStringFilter containsFilter2 = new ContainsStringFilter("папа");

        // Проверяем, что фильтр правильно работает
        assertTrue(containsFilter1.apply(str), "Строка должна содержать 'мыла'");
        assertFalse(containsFilter2.apply(str), "Строка не должна содержать 'папа'");
    }

    @Test
    public void testFilterNullPattern() {
        // Проверяем, что при передаче null в конструктор фильтра выбрасывается исключение
        assertThrows(IllegalArgumentException.class, () -> new BeginStringFilter(null), "Pattern не может быть null");
        assertThrows(IllegalArgumentException.class, () -> new EndStringFilter(null), "Pattern не может быть null");
        assertThrows(IllegalArgumentException.class, () -> new ContainsStringFilter(null), "Pattern не может быть null");
    }
}