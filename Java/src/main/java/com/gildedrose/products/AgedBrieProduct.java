package com.gildedrose.products;

import com.gildedrose.Item;

public class AgedBrieProduct extends AbstractProduct{

    private static final String AGED_BRIE = "Aged Brie";

    public AgedBrieProduct(Item item) {
        super(item);
        this.name = AGED_BRIE;
    }

    @Override
    public void updateQuality() {
        if (name.equals(AGED_BRIE)) {
            incrementQuality();
        }

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
