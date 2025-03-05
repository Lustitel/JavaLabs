package org.example.goods;

import java.util.Objects;

public class Goods
//TODO:Класс «Товар».
// Товар имеет название и описание (строки).
{
    String name_Goods;
    String options_Goods;

    public Goods(String user_name_Goods, String user_options_Goods) {
        if (user_options_Goods == null || user_options_Goods.isEmpty()) throw new NullPointerException("Должна быть строка, а не null!");
        else this.options_Goods = user_options_Goods;
        //(user_options_Goods == null || user_options_Goods.isEmpty())
        if (user_name_Goods == null || user_name_Goods.isEmpty()) throw new NullPointerException("Должна быть строка, а не null!");
        else this.name_Goods = user_name_Goods;
    }

    public String getName_Goods() {return name_Goods;}

    public String getOptions_Goods() {return options_Goods;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Сравнение ссылок
        if (o == null || getClass() != o.getClass()) return false; // Проверка типов
        Goods Goods_test = (Goods) o;
        return Objects.equals(name_Goods, Goods_test.name_Goods) &&
                Objects.equals(options_Goods, Goods_test.options_Goods);
    }

    @Override
    public int hashCode() {return Objects.hash(getName_Goods(), getOptions_Goods());}

    @Override
    public String toString() {
        return "Товар: '" + name_Goods + '\'' + '\n' +
                "Описание товара: '" + options_Goods + '\'';
    }
}