package com.gildedrose.products;

import com.gildedrose.Item;
import com.gildedrose.Product;

public class ProductFactory {

    public Product create(Item item) {
        Product product;

        if (AgedBrieProduct.NAME.equals(item.name)) {
            product = new AgedBrieProduct(item);
        }
        else if (BackStagePasseProduct.NAME.equals(item.name)) {
            product = new BackStagePasseProduct(item);
        }
        else if (SulfurasProduct.NAME.equals(item.name)) {
            product = new SulfurasProduct(item);
        }
        else if (ConjuredProduct.NAME.equals(item.name)) {
            product = new ConjuredProduct(item);
        }
        else {
            product = new GenericProduct(item);
        }

        return product;
    }
}
