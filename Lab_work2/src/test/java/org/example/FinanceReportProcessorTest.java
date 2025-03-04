package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FinanceReportProcessorTest {

    FinanceReport report;

    
    @BeforeEach
    void setUp() {
        Payment user1 = new Payment("Илья", 12, 2, 2000, 15345);
        Payment user2 = new Payment("Максим", 25, 4, 2014, 352345);
        Payment user3 = new Payment("Иван", 5, 6, 2020, 5435);

        Payment[] payments = {user1, user2, user3};
        report = new FinanceReport(payments, "Максим Олегович", 8, 12, 2024);
    }

    // Тест проверяет корректность работы метода getPaymentsChar,
    // возвращающего платежи, где фамилия начинается на указанную букву.
    @Test
    void testGetPaymentsChar_validChar() {
        List<Payment> result = FinanceReportProcessor.getPaymentsChar(report, 'И');
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(p -> p.getfullName().equals("Илья")));
        assertTrue(result.stream().anyMatch(p -> p.getfullName().equals("Иван")));
    }

    // Тест проверяет, что метод getPaymentsChar возвращает пустой список,
    // если фамилии на указанную букву отсутствуют.
    @Test
    void testGetPaymentsChar_noMatch() {
        List<Payment> result = FinanceReportProcessor.getPaymentsChar(report, 'З');
        assertTrue(result.isEmpty());
    }

    // Тест проверяет, что метод getPaymentsChar выбрасывает исключение,
    // если передан null вместо отчета.
    @Test
    void testGetPaymentsChar_nullReport() {
        assertThrows(IllegalArgumentException.class, () ->
                FinanceReportProcessor.getPaymentsChar(null, 'И'));
    }

    // Тест проверяет, что метод getPaymentsChar выбрасывает исключение,
    // если передан пустой символ.
    @Test
    void testGetPaymentsChar_emptyChar() {
        assertThrows(IllegalArgumentException.class, () ->
                FinanceReportProcessor.getPaymentsChar(report, '\u0000'));
    }

    // Тест проверяет корректность работы метода getPaymentsOnMinPayment,
    // возвращающего платежи с суммой меньше указанной.
    @Test
    void testGetPaymentsOnMinPayment_validLimit() {
        List<Payment> result = FinanceReportProcessor.getPaymentsOnMinPayment(report, 20000);
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(p -> p.getPayment_amount() == 15345));
        assertTrue(result.stream().anyMatch(p -> p.getPayment_amount() == 5435));
    }

    // Тест проверяет, что метод getPaymentsOnMinPayment возвращает пустой список,
    // если нет платежей меньше указанной суммы.
    @Test
    void testGetPaymentsOnMinPayment_noMatch() {
        List<Payment> result = FinanceReportProcessor.getPaymentsOnMinPayment(report, 1000);
        assertTrue(result.isEmpty());
    }

    // Тест проверяет, что метод getPaymentsOnMinPayment выбрасывает исключение,
    // если передан null вместо отчета.
    @Test
    void testGetPaymentsOnMinPayment_nullReport() {
        assertThrows(IllegalArgumentException.class, () ->
                FinanceReportProcessor.getPaymentsOnMinPayment(null, 20000));
    }

    // Тест проверяет, что метод getPaymentsOnMinPayment выбрасывает исключение,
    // если передана отрицательная сумма.
    @Test
    void testGetPaymentsOnMinPayment_negativeLimit() {
        assertThrows(IllegalArgumentException.class, () ->
                FinanceReportProcessor.getPaymentsOnMinPayment(report, -100));
    }
}
