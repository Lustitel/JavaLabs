package org.example.goods;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WeightedGoodsTest{
    String test_str_empty = "";
    String test_str_null = null;
    int test_mass_pack = -10;

    @Test
    public void testPackingOfGoods() {
        PackingGoods test = new PackingGoods("Упаковка товара", 200);
        PackingGoods test_duplicate = new PackingGoods("Упаковка товара", 200);

        //Проверка на работоспособность класса
        assertEquals(
                new PackingGoods("Упаковка товара", 200),
                test,
                "Полученный упаковка товара должна быть с названием и массой"
        );
        //Проверка equals()
        assertEquals(test, test_duplicate, "Полученный упаковка товара должна быть равна дублированной");
        //Проверка hashCode()
        assertEquals(test.hashCode(), test_duplicate.hashCode(),"Полученный упаковка товара должна быть равна дублированной");


        assertThrows(NullPointerException.class, () ->
                //Проверка на значение null
                new PackingGoods(test_str_null, 100), "Expected: Передаваемая строчка не null!");
        assertThrows(NullPointerException.class, () ->
                //Проверка на значение isEmpty
                new PackingGoods(test_str_empty, 100), "Expected: Передаваемая строчка не пуста!");
        assertThrows(IllegalArgumentException.class, () ->
                //Проверка на значение отрицательной массы
                new PackingGoods("Упаковка товара", test_mass_pack), "Expected: Передаваемая масса не отрицательна!");
    }

}