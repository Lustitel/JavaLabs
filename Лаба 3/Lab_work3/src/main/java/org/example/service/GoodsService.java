package org.example.service;

import org.example.goods.GoodsBatch;
import org.example.goods.PackedPieceGoods;
import org.example.goods.PackedWeightedGoods;
import org.example.goods.WeightedGoods;
import org.example.goods.PackingGoods;
import org.example.filter.Filter;

public class GoodsService {
    public static int countByFilter(GoodsBatch batch, Filter filter) {
        if (batch == null || filter == null) {
            throw new IllegalArgumentException("Партия товаров и фильтр не могут быть null");
        }
        int count_piece = 0;
        // Подсчет для упакованных штучных товаров
        for (PackedPieceGoods piece : batch.getPackedPieceGoodss()) {
            if (filter.apply(piece.getName_Goods())) {
                count_piece++;
            }
        }

        int count_weight = 0;
        // Подсчет упакованных весовых товаров
        for (PackedWeightedGoods piece : batch.getPackedWeightedGoods()) {
            if (filter.apply(piece.getName_Goods())) {
                count_weight++;
            }
        }
        return count_weight+count_piece;
    }
}
