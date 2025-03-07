package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    // Тест проверяет корректное решение уравнения с двумя корнями
    @Test
    void testTwoRoots() {
        Task1 equation = new Task1(1, -3, 2); // x^2 - 3x + 2 = 0
        double[] roots = equation.execute();
        assertEquals(2, roots.length);
        assertArrayEquals(new double[]{2.0, 1.0}, roots, 1e-9);
    }

    // Тест проверяет корректное решение уравнения с одним корнем (дискриминант равен 0)
    @Test
    void testOneRoot() {
        Task1 equation = new Task1(1, -2, 1); // x^2 - 2x + 1 = 0
        double[] roots = equation.execute();
        assertEquals(1, roots.length);
        assertEquals(1.0, roots[0], 1e-9);
    }

    // Тест проверяет случай, когда корней нет (дискриминант меньше 0)
    @Test
    void testNoRoots() {
        Task1 equation = new Task1(1, 0, 1); // x^2 + 1 = 0
        double[] roots = equation.execute();
        assertEquals(0, roots.length);
    }

    // Тест проверяет выброс исключения при a = 0 (это не квадратное уравнение)
    @Test
    void testInvalidCoefficientA() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Task1(0, 2, 1)
        );
        assertEquals("Коэффициент a не может быть равен 0 (это не квадратное уравнение).", exception.getMessage());
    }

    // Тест проверяет корректный вывод метода toString()
    @Test
    void testToString() {
        Task1 equation = new Task1(1, -3, 2);
        assertEquals("Уравнение: 1.0x^2 + -3.0x + 2.0", equation.toString());
    }
}
