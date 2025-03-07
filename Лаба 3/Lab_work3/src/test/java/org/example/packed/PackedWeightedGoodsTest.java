package org.example.packed;

import org.example.goods.WeightedGoods;
import org.example.goods.PackingGoods;
import org.example.goods.PackedWeightedGoods;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PackedWeightedGoodsTest {

    @Test
    public void testPackedWeightedGoods() {
        // Создание тестовых объектов
        WeightedGoods testGoods = new WeightedGoods("Товар", "Описание товара", 2.5);
        PackingGoods testPackaging = new PackingGoods("Коробка", 1000);

        // Создание объекта PackedWeightedGoods
        PackedWeightedGoods packedGoods = new PackedWeightedGoods(testGoods, testPackaging);

        // Проверка расчета массы нетто
        assertEquals(2.5, packedGoods.getMassNet(), "Масса нетто должна быть равна весу товара.");

        // Проверка расчета массы брутто
        assertEquals(3.5, packedGoods.getMassGross(), "Масса брутто должна быть равна сумме массы упаковки и веса товара.");

        // Проверка выброса исключений
        assertThrows(IllegalArgumentException.class, () ->
                new PackedWeightedGoods(null, testPackaging), "Ожидается исключение, если товар равен null.");
        assertThrows(IllegalArgumentException.class, () ->
                new PackedWeightedGoods(testGoods, null), "Ожидается исключение, если упаковка равна null.");
        assertThrows(IllegalArgumentException.class, () ->
                new PackedWeightedGoods(new WeightedGoods("Товар", "Описание", -1), testPackaging), "Ожидается исключение, если вес товара отрицательный.");
        assertThrows(IllegalArgumentException.class, () ->
                new PackingGoods("Пакет", -1), "Ожидается исключение, если масса упаковки отрицательная.");
    }
}