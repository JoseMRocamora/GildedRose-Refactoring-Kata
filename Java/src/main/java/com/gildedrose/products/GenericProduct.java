package com.gildedrose.products;

import com.gildedrose.Item;

public class GenericProduct extends AbstractProduct {

    public GenericProduct(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (quality > 0) {
            quality = quality - 1;
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            if (quality > 0) {
                quality = quality - 1;
            }
        }
    }

}
