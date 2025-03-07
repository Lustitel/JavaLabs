package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    //Тест проверяет корректное получение максимального корня у уравнения с двумя корнями
    @Test
    void testGetMaxElement_TwoRoots() {
        Task1 equation = new Task1(1, -3, 2); // x^2 - 3x + 2 = 0, корни 1 и 2
        Task2 rootFinder = new Task2(equation);
        double maxRoot = rootFinder.getMaxElement();
        assertEquals(2.0, maxRoot, 1e-9); // Проверяем, что максимальный корень равен 2
    }

    //Тест проверяет корректную работу, когда только один корень (D == 0)
    @Test
    void testGetMaxElement_OneRoot() {
        Task1 equation = new Task1(1, -2, 1); // x^2 - 2x + 1 = 0, корень 1
        Task2 rootFinder = new Task2(equation);
        double maxRoot = rootFinder.getMaxElement();
        assertEquals(1.0, maxRoot, 1e-9); // Проверяем, что единственный корень равен 1
    }

    //Тест проверяет выброс исключения, если у уравнения нет корней
    @Test
    void testGetMaxElement_NoRoots() {
        Task1 equation = new Task1(1, 0, 1); // x^2 + 1 = 0, корней нет
        Task2 rootFinder = new Task2(equation);
        assertThrows(
                IllegalStateException.class,
                rootFinder::getMaxElement,
                "Нет корней у квадратного уравнения."
        );
    }

    //Тест проверяет выброс исключения, если в конструктор передали null
    @Test
    void testConstructor_NullTask1() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Task2(null)
        );
        assertEquals("Не может быть null", exception.getMessage());
    }

    //Тест проверяет корректный вывод строки из toString()
    @Test
    void testToString() {
        Task1 equation = new Task1(1, -3, 2);
        Task2 rootFinder = new Task2(equation);
        assertEquals(
                "Квадратный трёхчлен: Уравнение: 1.0x^2 + -3.0x + 2.0",
                rootFinder.toString()
        );
    }
}
