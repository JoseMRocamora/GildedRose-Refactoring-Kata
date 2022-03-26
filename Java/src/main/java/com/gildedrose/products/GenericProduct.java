package com.gildedrose.products;

import com.gildedrose.Item;

public class GenericProduct extends AbstractProduct {

    private final String name;

    public GenericProduct(Item item) {
        super(item);
        this.name = item.name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void doUpdateQuality() {
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
