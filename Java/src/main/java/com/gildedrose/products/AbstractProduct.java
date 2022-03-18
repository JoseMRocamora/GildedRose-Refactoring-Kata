package com.gildedrose.products;

import com.gildedrose.Item;
import com.gildedrose.Product;

public abstract class AbstractProduct implements Product {

    protected final String name;
    protected int sellIn;
    protected int quality;

    public AbstractProduct(Item item) {
        this.name = item.name;
        this.sellIn = item.sellIn;
        this.quality = item.quality;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSellIn() {
        return sellIn;
    }

    @Override
    public int getQuality() {
        return quality;
    }

    @Override
    public abstract void updateQuality();

}
