package org.example.packed;

import org.example.goods.PieceGoods;
import org.example.goods.PackingGoods;
import org.example.goods.PackedPieceGoods;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PackedPieceGoodsTest {
    @Test
    public void testPackedPieceGoods() {
        // Создаем объекты для тестов
        PackingGoods test_packaging = new PackingGoods("Коробка", 1500);
        PieceGoods test_good = new PieceGoods("Шоколад", "Молочный шоколад", 0.2);

        // Проверка корректной работы конструктора и методов
        PackedPieceGoods test = new PackedPieceGoods(test_packaging, test_good, 5);

        assertEquals(
                5,
                test.getAmountGoods(),
                "Количество товара должно совпадать с заданным"
        );

        assertEquals(
                1.0,
                test.getMassNet(),
                "Масса нетто должна быть равна суммарному весу всех единиц товара"
        );

        assertEquals(
                //7.5(масса упаковки)+1(масса продукта)
                8.5,
                test.getMassGross(),
                "Масса брутто должна быть равна сумме массы нетто и упаковки"
        );

        // Проверка исключений
        assertThrows(IllegalArgumentException.class, () ->
                        new PackedPieceGoods(null, test_good, 5),
                "Expected: Упаковка не может быть null"
        );

        assertThrows(NullPointerException.class, () ->
                        new PackedPieceGoods(test_packaging, null, 5),
                "Expected: Товар не может быть null"
        );

        assertThrows(IllegalArgumentException.class, () ->
                        new PackedPieceGoods(test_packaging, test_good, 0),
                "Expected: Количество товара должно быть больше нуля"
        );

        assertThrows(IllegalArgumentException.class, () ->
                        new PackedPieceGoods(test_packaging, test_good, -1),
                "Expected: Количество товара должно быть больше нуля"
        );
    }
}