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
        if (sellIn >= 0) {
            incrementQuality(1);
        }
        else {
            incrementQuality(2);
        }
    }

    private void incrementQuality(int units) {
        quality = quality + units;
    }
}
