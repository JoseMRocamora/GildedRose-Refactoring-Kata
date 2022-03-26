package com.gildedrose.products;

import com.gildedrose.Item;

public class AgedBrieProduct extends AbstractProduct{

    static final String NAME = "Aged Brie";

    public AgedBrieProduct(Item item) {
        super(item);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void doUpdateQuality() {
        incrementQuality();

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            incrementQuality();
        }
    }

    private void incrementQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }
}
