package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class FinanceReportTest {

    private Payment payment1;
    private Payment payment2;
    private Payment payment3;
    private Payment payment4;
    private Payment[] payments;

    @BeforeEach
    void setUp() {
        payment1 = new Payment("Васильев Пал Палыч", 10, 3, 2024, 15000);
        payment2 = new Payment("Решко Елена Николаевна", 15, 3, 2024, 20000);
        payment3 = new Payment("Васильев Пал Олегович", 14, 2, 2024, 15000);
        payment4 = new Payment("Решко Елена Владимировна", 11, 4, 2024, 20000);
        payments = new Payment[]{payment1, payment2, payment3, payment4};
    }

    // Тест конструктора с корректными данными
    @Test
    void testValidConstructor() {
        FinanceReport report = new FinanceReport(payments, "Сидоров Сидор Сидорович", 1, 3, 2024);
        assertEquals(4, report.getLengthPayments());
    }

    // Тест конструктора с некорректным массивом платежей (null)
    @Test
    void testConstructorWithNullPayments() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new FinanceReport(null, "Плательщик", 1, 1, 2024));
        assertEquals("Массив не может быть не инициализирован и его длина должна быть больше 0!", exception.getMessage());
    }

    // Тест конструктора с пустым массивом платежей
    @Test
    void testConstructorWithEmptyPayments() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new FinanceReport(new Payment[]{}, "Плательщик", 1, 1, 2024));
        assertEquals("Массив не может быть не инициализирован и его длина должна быть больше 0!", exception.getMessage());
    }

    // Тест конструктора с некорректным именем плательщика
    @Test
    void testConstructorWithEmptyAuthor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new FinanceReport(payments, "", 1, 1, 2024));
        assertEquals("Строчка должна быть не null и не быть пустой!", exception.getMessage());
    }

    // Тест конструктора копирования, проверка глубокой копии
    @Test
    void testCopyConstructor() {
        FinanceReport original = new FinanceReport(payments, "Плательщик", 1, 1, 2024);
        FinanceReport copy = new FinanceReport(original);

        assertNotSame(original, copy); // Проверяем, что это разные объекты
        assertNotSame(original.getIndexPayments(0), copy.getIndexPayments(0)); // Проверяем, что массив скопирован глубоко
        assertEquals(original.getIndexPayments(0), copy.getIndexPayments(0)); // Проверяем, что значения одинаковые
    }

    @Test
    void testCopyConstructorWithDifValue() {
        FinanceReport original = new FinanceReport(payments, "Плательщик", 28, 3, 2024);
        FinanceReport copy = new FinanceReport(original);

        assertNotSame(original, copy); // Проверяем, что это разные объекты
        assertNotSame(original.getIndexPayments(0), copy.getIndexPayments(0)); // Проверяем, что массив скопирован глубоко
        assertEquals(original.getIndexPayments(0), copy.getIndexPayments(0)); // Проверяем, что значения одинаковые
    }

    // Тест получения количества платежей
    @Test
    void testGetLengthPayments() {
        FinanceReport report = new FinanceReport(payments, "Плательщик", 1, 1, 2024);
        assertEquals(4, report.getLengthPayments());
    }

    // Тест получения платежа по индексу
    @Test
    void testGetIndexPayments() {
        FinanceReport report = new FinanceReport(payments, "Плательщик", 1, 1, 2024);
        assertEquals(payment1, report.getIndexPayments(0));
    }

    // Тест исключения при обращении к платежу с некорректным индексом
    @Test
    void testGetIndexPaymentsWithInvalidIndex() {
        FinanceReport report = new FinanceReport(payments, "Плательщик", 1, 1, 2024);
        assertThrows(IndexOutOfBoundsException.class, () -> report.getIndexPayments(-1));
    }

    // Тест установки нового платежа по индексу
    @Test
    void testSetIndexPayments() {
        FinanceReport report = new FinanceReport(payments, "Плательщик", 1, 1, 2024);
        Payment newPayment = new Payment("Смирнов Смирнов Смирнович", 20, 4, 2024, 25000);
        report.setIndexPayments(1, newPayment);
        assertEquals(newPayment, report.getIndexPayments(1));
    }

    // Тест исключения при установке платежа с некорректным индексом
    @Test
    void testSetIndexPaymentsWithInvalidIndex() {
        FinanceReport report = new FinanceReport(payments, "Плательщик", 1, 1, 2024);
        Payment newPayment = new Payment("Смирнов Смирнов Смирнович", 20, 4, 2024, 25000);
        assertThrows(IndexOutOfBoundsException.class, () -> report.setIndexPayments(-1, newPayment));
    }

    // Тест метода toString
    @Test
    void testToString() {
        FinanceReport report = new FinanceReport(payments, "Пиклз", 1, 1, 2024);
        String result = report.toString();
        assertTrue(result.contains("Автор: Пиклз"));
        assertTrue(result.contains("Платит[Имя: Васильев Пал Палыч"));
        assertTrue(result.contains("Платит[Имя: Решко Елена Николаевна"));
        assertTrue(result.contains("Платит[Имя: Васильев Пал Олегович"));
        assertTrue(result.contains("Платит[Имя: Решко Елена Владимировна"));
        System.out.println(result);
    }
}
