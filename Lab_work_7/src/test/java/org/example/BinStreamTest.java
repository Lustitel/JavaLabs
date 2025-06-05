package org.example;

import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class BinStreamTest {

    // ... (предыдущие тесты)

    /*
     Тестирует поведение при работе с пустым массивом в текстовом режиме.
     Создаёт пустой массив
     Записывает его в строку
     Проверяет, что строка пустая
     Считывает строку обратно
     Проверяет, что массив остался пустым
     */
    @Test
    void testEmptyArrayText() throws IOException {
        int[] emptyArray = {};
        StringWriter writer = new StringWriter();
        BinStream.writeIntArray(writer, emptyArray);
        String written = writer.toString();

        assertEquals("", written);

        int[] readArray = {};
        BinStream.readIntArray(new StringReader(written), readArray);
        assertEquals(0, readArray.length);
    }

    /*
     Тестирует чтение текстовых данных, когда чисел меньше, чем размер массива.
     Ожидается, что оставшиеся элементы массива останутся по умолчанию равными 0
     */
    @Test
    void testTextReadFewerNumbersThanExpected() throws IOException {
        String input = "1 2";
        int[] readArray = new int[4]; // ожидаем 4 элемента, получим только 2

        BinStream.readIntArray(new StringReader(input), readArray);

        assertArrayEquals(new int[]{1, 2, 0, 0}, readArray);
    }

    /*
     Тестирует чтение текстовых данных, когда чисел больше, чем размер массива.
     Ожидается, что лишние числа будут проигнорированы
     */
    @Test
    void testTextReadMoreNumbersThanExpected() throws IOException {
        String input = "5 6 7 8 9 10";
        int[] readArray = new int[3]; // массив меньше, чем чисел

        BinStream.readIntArray(new StringReader(input), readArray);

        assertArrayEquals(new int[]{5, 6, 7}, readArray); // только первые три
    }

    /*
     Тестирует поведение при попытке прочитать нечисловые данные.
     Ожидается NumberFormatException
     */
    @Test
    void testTextReadInvalidNumberFormat() {
        String input = "1 two 3";
        int[] readArray = new int[3];

        assertThrows(NumberFormatException.class, () -> {BinStream.readIntArray(new StringReader(input), readArray);});
    }
}
