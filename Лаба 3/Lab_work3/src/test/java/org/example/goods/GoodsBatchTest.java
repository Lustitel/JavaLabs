package org.example.goods;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class GoodsBatchTest {

    // Тестовые данные
    PackingGoods packaging1 = new PackingGoods("Упаковка 1", 900); // 500 грамм упаковки
    PackingGoods packaging2 = new PackingGoods("Упаковка 2", 500); // 300 грамм упаковки
    PieceGoods PieceGoods1 = new PieceGoods("Товар 1", "Описание 1", 1.5); // 1.5 кг штучного товара
    PieceGoods PieceGoods2 = new PieceGoods("Товар 2", "Описание 2", 0.8); // 0.8 кг штучного товара
    WeightedGoods WeightedGoods1 = new WeightedGoods("Весовой товар 1", "Описание весового товара 1", 2.0); // 2 кг весового товара

    @Test
    public void testBatchOfGoods() {
        // Создаем упакованные товары
        PackedPieceGoods packedPiece1 = new PackedPieceGoods(packaging1, PieceGoods1, 5); // 3 штучных товара
        PackedPieceGoods packedPiece2 = new PackedPieceGoods(packaging2, PieceGoods2, 8); // 5 штучных товаров
        PackedWeightedGoods packedWeighted1 = new PackedWeightedGoods(WeightedGoods1, packaging1); // 1 весовой товар

        // Создаем партию товаров с данными товарами
        GoodsBatch batch = new GoodsBatch("Партия 1",
                Arrays.asList(packedPiece1, packedPiece2),
                List.of(packedWeighted1));

        // Проверка метода getTotalGrossMass
        // Масса брутто:
        // 5 шт * (1.5 кг + 0.9 кг упаковка) = 12 кг
        // 8 шт * (0.8 кг + 0.5 кг упаковка) = 10.4 кг
        // 1 шт * (2.0 кг + 0.9 кг упаковка) = 2.9 кг
        // Сумма: 12 кг + 10.4 кг + 2.9 кг = 25.3 кг
        assertEquals(25.3, batch.getTotalGrossMass(), "Суммарная масса брутто должна быть 25.3 кг");

        // Проверка на пустое описание партии
        assertThrows(IllegalArgumentException.class, () ->
                        new GoodsBatch("", List.of(packedPiece1), List.of(packedWeighted1)),
                "Описание партии не может быть пустым"
        );

        // Проверка на null в списке товаров
        assertThrows(NullPointerException.class, () ->
                        new GoodsBatch("Партия 2", null, List.of(packedWeighted1)),
                "Список упакованных товаров не может быть null"
        );

        // Проверка на null упаковки товара
        assertThrows(NullPointerException.class, () ->
                        new GoodsBatch("Партия 3", List.of(packedPiece1), null),
                "Список упакованных весовых товаров не может быть null"
        );
    }
}