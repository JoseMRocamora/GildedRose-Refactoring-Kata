package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            Product product = new Product(item);

            product.updateQuality();

            item.sellIn = product.getSellIn();
            item.quality = product.getQuality();
        }
    }

}
