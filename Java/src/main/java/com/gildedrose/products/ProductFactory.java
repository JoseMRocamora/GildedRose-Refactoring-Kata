package com.gildedrose.products;

import com.gildedrose.Item;
import com.gildedrose.Product;

public class ProductFactory {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    public Product create(Item item) {
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

        return product;
    }
}
