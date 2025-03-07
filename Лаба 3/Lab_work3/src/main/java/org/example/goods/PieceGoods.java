package org.example.goods;

import java.util.Objects;

public class PieceGoods extends Goods
//TODO: Штучный товар хранит название, описание и вес одной штуки товара (в кг).
// Должен быть конструктор по всем трем полям.
{
    double weight_piece;

    public PieceGoods(String user_name_Goods, String user_options_Goods, double user_weight_piece) {
        super(user_name_Goods, user_options_Goods);
        this.weight_piece = user_weight_piece;
    }

    public double getWeight_piece() {return weight_piece;}

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PieceGoods PieceGoods)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(getWeight_piece(), PieceGoods.getWeight_piece()) == 0;
    }

    @Override
    public int hashCode() {return Objects.hash(super.hashCode(), getWeight_piece());}

    @Override
    public String toString() {
        return "Товар: '" + name_Goods + '\'' + '\n' +
                "Описание товара: '" + options_Goods + '\'' + '\n' +
                "Вес товара: '" + weight_piece + '\'';
    }
}