package com.gildedrose.products;

import com.gildedrose.Item;

public class BackStagePasseProduct extends AbstractProduct{

    static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    public BackStagePasseProduct(Item item) {
        super(item);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void doUpdateQuality() {
        if (sellIn < 0) {
            quality = 0;
        }

        if ((sellIn >= 0) && (sellIn < 5)) {
            incrementQuality(3);
        }

        if ((sellIn >= 5) && (sellIn < 10)) {
            incrementQuality(2);
        }

        if (sellIn >= 10) {
            incrementQuality(1);
        }
    }

    private void incrementQuality(int units) {
        quality = quality + units;
    }
}
