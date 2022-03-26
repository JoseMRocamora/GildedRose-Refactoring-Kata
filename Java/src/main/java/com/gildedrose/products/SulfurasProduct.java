package com.gildedrose.products;

import com.gildedrose.Item;
import com.gildedrose.Product;

public class SulfurasProduct implements Product {

    static final String NAME = "Sulfuras, Hand of Ragnaros";
    private Item item;

    public SulfurasProduct(Item item) {
        this.item = item;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int getSellIn() {
        return item.sellIn;
    }

    @Override
    public int getQuality() {
        return item.quality;
    }

    @Override
    public void updateQuality() {
        // do nothing
        // "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    }
}
