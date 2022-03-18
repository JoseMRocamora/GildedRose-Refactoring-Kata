package com.gildedrose.products;

import com.gildedrose.Item;

public class SulfurasProduct extends AbstractProduct {

    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    public SulfurasProduct(Item item) {
        super(item);
        this.name = SULFURAS_HAND_OF_RAGNAROS;
    }

    @Override
    public void updateQuality() {
        // nothing to do
    }
}
