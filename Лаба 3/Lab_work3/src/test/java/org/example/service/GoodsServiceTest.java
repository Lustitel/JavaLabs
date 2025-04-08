package org.example.service;

import org.example.goods.*;
import org.example.filter.Filter;
import org.example.goods.PackedPieceGoods;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class GoodsServiceTest {

    @Test
    void testCountByFilter() {
        // Создаем партию товаров
        GoodsBatch batch = new GoodsBatch("Партия сладостей", List.of(
                new PackedPieceGoods(new PackingGoods("Фольга", 10), new PieceGoods("Шоколад", "Uwu", 2),3),
                new PackedPieceGoods(new PackingGoods("Коробка", 50), new PieceGoods("Конфеты", "Карамельные", 0.05), 2),
                new PackedPieceGoods(new PackingGoods("Бумага", 5), new PieceGoods("Шоколад", "Темный шоколад", 0.15), 1)
        ), List.of(new PackedWeightedGoods(new WeightedGoods("Шоколад", "Вкусный", 2.0), new PackingGoods("Бумага",3)))); // Не пустой список весовых товаров

        // Фильтр: выбираем только товары, содержащие "Шоколад" в названии
        Filter filter = name -> name.contains("Шоколад");

        // Вызываем метод и проверяем результат
        int count = GoodsService.countByFilter(batch, filter);

        // Ожидаем, что найдено 3 товара: "Шоколад" и "Шоколадка"
        assertEquals(3, count, "Должно быть найдено 3 товара с 'Шоколад' в названии.");
    }

    @Test
    void testCountByFilter_NoMatches() {
        GoodsBatch batch = new GoodsBatch("Партия фруктов", List.of(
                new PackedPieceGoods(new PackingGoods("Сетка", 5), new PieceGoods("Яблоко", "гнилое",2), 5),
                new PackedPieceGoods(new PackingGoods("Коробка", 10), new PieceGoods("Банан", "22 см",3), 4)
        ), List.of());

        Filter filter = name -> name.contains("Шоколад");

        int count = GoodsService.countByFilter(batch, filter);

        // Ожидаем 0, так как ни один товар не содержит "Шоколад"
        assertEquals(0, count, "Не должно быть найдено товаров с 'Шоколад' в названии.");
    }

    @Test
    void testCountByFilter_EmptyBatch() {
        GoodsBatch batch = new GoodsBatch("Пустая партия", List.of(), List.of());
        Filter filter = name -> true; // Фильтр, который всегда возвращает true

        int count = GoodsService.countByFilter(batch, filter);

        // Ожидаем 0, так как партия пустая
        assertEquals(0, count, "В пустой партии товаров не должно быть найдено.");
    }

    @Test
    void testCountByFilter_NullBatch() {
        Filter filter = name -> name.contains("Шоколад");

        // Ожидаем исключение при передаче null в метод
        assertThrows(IllegalArgumentException.class, () -> GoodsService.countByFilter(null, filter));
    }

    @Test
    void testCountByFilter_NullFilter() {
        GoodsBatch batch = new GoodsBatch("Партия сладостей", List.of(
                new PackedPieceGoods(new PackingGoods("Фольга", 10), new PieceGoods("Шоколад", "Молочный шоколад", 0.1), 6)
        ), List.of());

        // Ожидаем исключение при передаче null в качестве фильтра
        assertThrows(IllegalArgumentException.class, () -> GoodsService.countByFilter(batch, null));
    }
}
