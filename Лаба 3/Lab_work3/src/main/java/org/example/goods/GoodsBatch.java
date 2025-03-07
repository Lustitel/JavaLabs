package org.example.goods;

import java.util.List;

public class GoodsBatch
//TODO:Класс «Партия товаров».
// Партия товаров имеет описание и содержит некоторое  количество упакованных товаров, возможно, разных типов (в том числе наборов  товаров).
{
    private final String description; // Описание партии товаров
    private final List<PackedPieceGoods> PackedPieceGoodss; // Список упакованных штучных товаров
    private final List<PackedWeightedGoods> PackedWeightedGoods; // Список упакованных весовых товаров

    public GoodsBatch(String description, List<PackedPieceGoods> PackedPieceGoodss, List<PackedWeightedGoods> PackedWeightedGoods)
    //конструктор по произвольному набору упаковок товаров,
    {
        if (description == null || description.isEmpty()) throw new IllegalArgumentException("Описание партии товаров не может быть пустым.");
        if (PackedPieceGoodss == null || PackedPieceGoodss.isEmpty()) throw new NullPointerException("Список упакованных товаров не может быть null.");
        if (PackedWeightedGoods == null || PackedWeightedGoods.isEmpty()) throw new NullPointerException("Список упакованных весовых товаров не может быть null.");
        this.description = description;
        this.PackedPieceGoodss = PackedPieceGoodss;
        this.PackedWeightedGoods = PackedWeightedGoods;
    }

    public String getDescription() {return description;}

    public List<PackedWeightedGoods> getPackedWeightedGoods() {return PackedWeightedGoods;}

    public List<PackedPieceGoods> getPackedPieceGoodss() {return PackedPieceGoodss;}

    public double getTotalGrossMass()
    // получить массу всей партии (суммарная масса брутто всех товаров в партии).
    {
        double totalGrossMass = 0;

        // Считаем массу брутто для упакованных штучных товаров
        if (PackedPieceGoodss != null) {
            for (PackedPieceGoods piece : PackedPieceGoodss) {
                totalGrossMass += piece.getMassGross();
            }
        }
        // Считаем массу брутто для упакованных весовых товаров
        if (PackedWeightedGoods != null) {
            for (PackedWeightedGoods weighted : PackedWeightedGoods) {
                totalGrossMass += weighted.getMassGross();
            }
        }

        return totalGrossMass;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Партия товаров: ").append(description).append("\n");

        sb.append("Упакованные штучные товары:\n");
        if (PackedPieceGoodss != null) {
            for (PackedPieceGoods piece : PackedPieceGoodss) {
                sb.append(piece.toString()).append("\n");
            }
        }

        sb.append("Упакованные весовые товары:\n");
        if (PackedWeightedGoods != null) {
            for (PackedWeightedGoods weighted : PackedWeightedGoods) {
                sb.append(weighted.toString()).append("\n");
            }
        }

        return sb.toString();
    }
}