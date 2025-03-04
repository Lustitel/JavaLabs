package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    // Проверяем корректное создание объекта с валидными данными
    @Test
    void testValidInput() {
        Payment payment = new Payment("Васильев Пал Палыч", 15, 5, 2007, 10000);
        assertEquals("Васильев Пал Палыч", payment.getfullName());
        assertEquals(15, payment.getpayment_date());
        assertEquals(5, payment.getMonth());
        assertEquals(2007, payment.getYear());
        assertEquals(10000, payment.getPayment_amount());
    }

    //Проверяем выброс исключения при передаче пустого ФИО в конструктор
    @Test
    void testInvalidFullNameInConstructor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Payment("", 15, 5, 2007, 10000));
        assertEquals("Ожидалось передача значения для fullName!", exception.getMessage());
    }

    //Проверяем выброс исключения при передаче некорректной даты платежа (>31) в конструктор
    @Test
    void testInvalidPaymentDateInConstructor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Payment("Васильев Пал Палыч", 32, 5, 2007, 10000));
        assertEquals("Дата не должна выходить за пределы 31 или быть меньше 1!", exception.getMessage());
    }

    //Проверяем выброс исключения при передаче некорректного месяца (>12) в конструктор
    @Test
    void testInvalidMonthInConstructor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Payment("Васильев Пал Палыч", 15, 13, 2007, 10000));
        assertEquals("Месяц не должен выходить за пределы 12 или быть меньше 1!", exception.getMessage());
    }

    //Проверяем выброс исключения при передаче некорректного года (0) в конструктор
    @Test
    void testInvalidYearInConstructor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Payment("Васильев Пал Палыч", 15, 5, 0, 10000));
        assertEquals("Год не может быть отрицательным!", exception.getMessage());
    }

    //Проверяем выброс исключения при передаче некорректной суммы платежа (0) в конструктор
    @Test
    void testInvalidPaymentAmountInConstructor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Payment("Васильев Пал Палыч", 15, 5, 2007, 0));
        assertEquals("Платеж не может быть отрицательным!", exception.getMessage());
    }

    //Проверяем выброс исключений при установке некорректных значений через сеттеры
    @Test
    void testSettersWithInvalidValues() {
        Payment payment = new Payment("Васильев Пал Палыч", 15, 5, 2007, 10000);

        assertThrows(IllegalArgumentException.class, () -> payment.setfullName(""));
        assertThrows(IllegalArgumentException.class, () -> payment.setPayment_date(0));
        assertThrows(IllegalArgumentException.class, () -> payment.setMonth(0));
        assertThrows(IllegalArgumentException.class, () -> payment.setYear(0));
        assertThrows(IllegalArgumentException.class, () -> payment.setPayment_amount(0));
    }

    //Проверяем корректную работу equals() и hashCode()
    @Test
    void testEqualsAndHashCode() {
        Payment payment1 = new Payment("Васильев Пал Палыч", 15, 5, 2007, 10000);
        Payment payment2 = new Payment("Васильев Пал Палыч", 15, 5, 2007, 10000);
        Payment payment3 = new Payment("Васильев Михаил Андреич", 15, 5, 2007, 10000);

        assertEquals(payment1, payment2); // объекты с одинаковыми данными равны
        assertEquals(payment1.hashCode(), payment2.hashCode()); // и хэши тоже равны
        assertNotEquals(payment1, payment3); // разные данные — разные объекты
    }

    //Проверяем правильность формирования строки в методе toString()
    @Test
    void testToString() {
        Payment payment = new Payment("Васильев Пал Палыч", 15, 5, 2007, 12345);
        assertEquals("Платит[Имя: Васильев Пал Палыч, Дата: 15.5.2007, Сумма: 123руб.45коп.]", payment.toString());
    }
}
