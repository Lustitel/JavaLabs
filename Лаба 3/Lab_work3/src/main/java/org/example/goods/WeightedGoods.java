package org.example.goods;

import java.util.Objects;

public class WeightedGoods extends Goods
//TODO:Класс «Весовой товар».
// Весовой товар хранит название и описание.
{
    double weight;
    String name;
    public WeightedGoods(String user_name_Goods, String user_option_Goods, double user_weight) {
        super(user_name_Goods, user_option_Goods);
        if(weight < 0 ) throw new IllegalArgumentException("Масса должна быть положительной");
        else this.weight = user_weight;
        this.name = user_name_Goods;
    }

    public double getWeight() {return weight;}

    public String getWeight_Name(){return name;}

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof WeightedGoods that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(getWeight(), that.getWeight()) == 0;
    }

    @Override
    public int hashCode() {return Objects.hash(super.hashCode(), getWeight());}


    @Override
    public String toString() {
        return "Товар: '" + name_Goods + '\'' + '\n' +
                "Описание товара: '" + options_Goods + '\'' + '\n' +
                "Вес товара: '" + weight + '\'';
    }
}