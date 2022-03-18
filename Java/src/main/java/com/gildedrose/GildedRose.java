package com.gildedrose;

import com.gildedrose.products.AbstractProduct;
import com.gildedrose.products.GenericProduct;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            AbstractProduct product = new GenericProduct(item);

            product.updateQuality();

            item.sellIn = product.getSellIn();
            item.quality = product.getQuality();
        }
    }

}
