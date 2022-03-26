package com.gildedrose.products;

import com.gildedrose.Item;

public class ConjuredProduct extends GenericProduct{

    static final String NAME = "Conjured Mana Cake";

    public ConjuredProduct(Item item) {
        super(item);
        this.degradationVelocity = 2 * this.degradationVelocity;
    }
}
