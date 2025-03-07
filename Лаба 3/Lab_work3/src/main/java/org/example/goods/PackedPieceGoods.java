package org.example.goods;

public class PackedPieceGoods extends PieceGoods
//TODO: Класс «Упакованный штучный товар» содержит упаковку и несколько единиц штучного товара. Методы:
// получить количество штук товара,
// получить массу нетто  (суммарный вес всех единиц товара)
// и массу брутто (упаковки и всех единиц товара  вместе).
{
    int amount_piece;
    PackingGoods default_packaging_of_good;
    PieceGoods default_good_piece;

    public PackedPieceGoods(PackingGoods user_packaging_of_good, PieceGoods user_good_piece, int amount_piece) {
        super(user_good_piece.getName_Goods(), user_good_piece.getOptions_Goods(), user_good_piece.getWeight_piece() * amount_piece);

        if (user_packaging_of_good == null) {
            throw new IllegalArgumentException("Упаковка не может быть null.");
        }
        if (amount_piece <= 0) {
            throw new IllegalArgumentException("Количество единиц товара должно быть больше нуля.");
        }

        this.default_packaging_of_good = user_packaging_of_good;
        this.default_good_piece = user_good_piece;
        this.amount_piece = amount_piece;
    }

    public double getAmountGoods() {
        return amount_piece;
    }

    public double getMassNet() {
        return default_good_piece.getWeight_piece()
                * amount_piece;
    }

    public double getMassGross() {

        return getMassNet() +
                default_packaging_of_good.getMass_pack()
                        * amount_piece;
    }

    @Override
    public String toString() {
        return " Наименование товара:'" + default_good_piece.getName_Goods() + '\'' + '\n' +
                " Описание товара:'" + default_good_piece.getOptions_Goods() + '\'' + '\n' +
                " Масса нетто:'" + getMassNet() + '\'' + '\n' +
                " Масса брутто:'" + getMassGross() + '\'' + '\n' +
                " Наименование упаковки:'" + default_packaging_of_good.getName_pack() + '\'';
    }
}