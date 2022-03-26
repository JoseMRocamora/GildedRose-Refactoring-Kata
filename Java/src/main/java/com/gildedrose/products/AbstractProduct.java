package com.gildedrose.products;

import com.gildedrose.Item;
import com.gildedrose.Product;

public abstract class AbstractProduct implements Product {

    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;

    protected int sellIn;
    protected int quality;

    public AbstractProduct(Item item) {
        this.sellIn = item.sellIn;
        this.quality = item.quality;
    }

    @Override
    public abstract String getName();

    @Override
    public int getSellIn() {
        return sellIn;
    }

    @Override
    public int getQuality() {
        return quality;
    }

    @Override
    public void updateQuality() {
        sellIn = sellIn - 1;

        doUpdateQuality();

        if (quality < MIN_QUALITY) {
            quality = MIN_QUALITY;
        }

        if (quality > MAX_QUALITY) {
            quality = MAX_QUALITY;
        }
    }

    protected abstract void doUpdateQuality();
}
