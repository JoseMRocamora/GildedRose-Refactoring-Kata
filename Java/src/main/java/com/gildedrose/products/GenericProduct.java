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
        if (sellIn >= 0) {
            decrementQuality(1);
        }
        else {
            decrementQuality(2);
        }
    }

    void decrementQuality(int units) {
        quality = quality - units;
    }
}
