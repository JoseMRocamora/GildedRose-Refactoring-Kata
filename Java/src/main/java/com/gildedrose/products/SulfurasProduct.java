package com.gildedrose.products;

import com.gildedrose.Item;

public class SulfurasProduct extends AbstractProduct {

    static final String NAME = "Sulfuras, Hand of Ragnaros";

    public SulfurasProduct(Item item) {
        super(item);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void updateQuality() {
        // nothing to do
    }
}
