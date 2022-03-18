package com.gildedrose.products;

import com.gildedrose.Item;

public class BackStagePasseProduct extends AbstractProduct{

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    public BackStagePasseProduct(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (name.equals(AGED_BRIE)) {
            incrementQuality();
        } else {
            if (name.equals(BACKSTAGE_PASSES)) {
                if (quality < 50) {
                    quality = quality + 1;

                    if (sellIn < 11) {
                        incrementQuality();
                    }

                    if (sellIn < 6) {
                        incrementQuality();
                    }
                }
            } else {
                if (quality > 0) {
                    if (!name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                        quality = quality - 1;
                    }
                }
            }
        }

        if (!name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            sellIn = sellIn - 1;
        }

        if (sellIn < 0) {
            if (name.equals(AGED_BRIE)) {
                incrementQuality();
            } else {
                if (name.equals(BACKSTAGE_PASSES)) {
                    quality = quality - quality;
                } else {
                    if (quality > 0) {
                        if (!name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                            quality = quality - 1;
                        }
                    }
                }
            }
        }
    }

    private void incrementQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }
}
