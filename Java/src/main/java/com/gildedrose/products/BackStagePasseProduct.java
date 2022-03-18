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
    public void updateQuality() {
        if (quality < 50) {
            quality = quality + 1;

            if (sellIn < 11) {
                incrementQuality();
            }

            if (sellIn < 6) {
                incrementQuality();
            }
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            quality = 0;
        }
    }

    private void incrementQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }
}
