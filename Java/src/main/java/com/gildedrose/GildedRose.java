package com.gildedrose;

import com.gildedrose.products.*;

class GildedRose {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            Product product;
            if (AGED_BRIE.equals(item.name)) {
                product = new AgedBrieProduct(item);
            }
            else if (BACKSTAGE_PASSES.equals(item.name)) {
                product = new BackStagePasseProduct(item);
            }
            else if (SULFURAS_HAND_OF_RAGNAROS.equals(item.name)) {
                product = new SulfurasProduct(item);
            }
            else {
                product = new GenericProduct(item);
            }

            product.updateQuality();

            item.sellIn = product.getSellIn();
            item.quality = product.getQuality();
        }
    }

}
