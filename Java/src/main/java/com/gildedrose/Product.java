package com.gildedrose;

public class Product {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    private final String name;
    private int sellIn;
    private int quality;

    public Product(Item item) {
        this.name = item.name;
        this.sellIn = item.sellIn;
        this.quality = item.quality;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public void updateQuality() {
        if (name.equals(AGED_BRIE)) {
            if (quality < 50) {
                quality = quality + 1;
            }
        } else {
            if (name.equals(BACKSTAGE_PASSES)) {
                if (quality < 50) {
                    quality = quality + 1;

                    if (sellIn < 11) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }

                    if (sellIn < 6) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
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
                if (quality < 50) {
                    quality = quality + 1;
                }
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
}
