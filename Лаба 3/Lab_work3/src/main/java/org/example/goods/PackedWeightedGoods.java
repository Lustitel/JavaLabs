package org.example.goods;

public class PackedWeightedGoods extends WeightedGoods
//TODO: Класс «Упакованный весовой товар» содержит
// упаковку и некоторое количество весового товара (в кг).
{
    private WeightedGoods default_WeightedGoods;
    private final PackingGoods default_PackingGoods;

    public PackedWeightedGoods(WeightedGoods user_WeightedGoods, PackingGoods user_PackingGoods) {
        super(user_WeightedGoods.getName_Goods(), user_PackingGoods.getName_pack(), user_WeightedGoods.getWeight());
        if (user_WeightedGoods == null) throw new IllegalArgumentException("Весовой товар не может быть null.");
        if (user_PackingGoods == null) throw new IllegalArgumentException("Упаковка не может быть null.");
        if (user_WeightedGoods.getWeight() <= 0) throw new IllegalArgumentException("Вес товара должен быть положительным.");
        if (user_PackingGoods.getMass_pack() < 0) throw new IllegalArgumentException("Масса упаковки не может быть отрицательной.");

        this.default_WeightedGoods = user_WeightedGoods;
        this.default_PackingGoods = user_PackingGoods;
    }

    public double getMassNet() {return default_WeightedGoods.getWeight();}

    public double getMassGross() {return getMassNet() + default_PackingGoods.getMass_pack();}
}