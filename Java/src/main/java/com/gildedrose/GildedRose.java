package com.gildedrose;

import com.gildedrose.products.*;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        ProductFactory productFactory = new ProductFactory();

        for (Item item : items) {
            Product product = productFactory.create(item);
            product.updateQuality();

            item.sellIn = product.getSellIn();
            item.quality = product.getQuality();
        }
    }

}
