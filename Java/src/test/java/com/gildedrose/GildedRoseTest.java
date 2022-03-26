package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String NORMAL_ITEM = "Normal item";
    private static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";


    private Item[] getItems(String name, int sellIn, int quality) {
        return new Item[]{new Item(name, sellIn, quality)};
    }

    // - At the end of each day our system lowers both values for every item
    @Test
    void at_the_end_of_each_day_our_system_lowers_both_values_for_every_item() {
        // given
        int initialSellIn = 10;
        int initialQuality = 15;
        Item[] items = getItems(NORMAL_ITEM, initialSellIn, initialQuality);
        GildedRose app = new GildedRose(items);
        // when
        app.updateQuality();
        //then
        Item firstItem = app.items[0];
        assertTrue(firstItem.sellIn < initialSellIn);
        assertTrue(firstItem.quality < initialQuality);
    }

    // - Once the sell by date has passed, Quality degrades twice as fast
    @Test
    void once_the_sell_by_date_has_passed_quality_degrades_twice_as_fast() {
        // given
        int initialSellIn = 0;
        int initialQuality = 15;
        Item[] items = getItems(NORMAL_ITEM, initialSellIn, initialQuality);
        GildedRose app = new GildedRose(items);
        // when
        app.updateQuality();
        //then
        Item firstItem = app.items[0];
        assertTrue(firstItem.sellIn < initialSellIn);
        assertEquals(initialQuality - 2, firstItem.quality);
    }

    // - The Quality of an item is never negative
    @Test
    void the_quality_of_an_item_is_never_negative() {
        // given
        int initialSellIn = 10;
        int initialQuality = 0;
        Item[] items = getItems(NORMAL_ITEM, initialSellIn, initialQuality);
        GildedRose app = new GildedRose(items);
        // when
        app.updateQuality();
        //then
        Item firstItem = app.items[0];
        assertTrue(firstItem.quality >= 0);
    }

    // - "Aged Brie" actually increases in Quality the older it gets
    @Test
    void aged_brie_actually_increases_in_quality_the_older_it_gets() {
        // given
        int initialSellIn = 10;
        int initialQuality = 15;
        Item[] items = getItems(AGED_BRIE, initialSellIn, initialQuality);
        GildedRose app = new GildedRose(items);
        // when
        app.updateQuality();
        //then
        Item firstItem = app.items[0];
        assertTrue(firstItem.sellIn < initialSellIn);
        assertEquals(initialQuality + 1, firstItem.quality);
    }

    // - "Aged Brie" increases Quality 2 units by day when the sell by date has passed
    @Test
    void aged_brie_increases_quality_2_units_by_day_when_the_sell_by_date_has_passed() {
        // given
        int initialSellIn = 0;
        int initialQuality = 15;
        Item[] items = getItems(AGED_BRIE, initialSellIn, initialQuality);
        GildedRose app = new GildedRose(items);
        // when
        app.updateQuality();
        //then
        Item firstItem = app.items[0];
        assertTrue(firstItem.sellIn < initialSellIn);
        assertEquals(initialQuality + 2, firstItem.quality);
    }

    // - The Quality of an item is never more than 50
    @Test
    void the_quality_of_an_item_is_never_more_than_50() {
        // given
        int initialSellIn = 10;
        int initialQuality = 50;
        Item[] items = getItems(NORMAL_ITEM, initialSellIn, initialQuality);
        GildedRose app = new GildedRose(items);
        // when
        app.updateQuality();
        //then
        Item firstItem = app.items[0];
        assertTrue(firstItem.quality <= 50);
    }

    // - "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    @Test
    void sulfuras_being_a_legendary_item_never_has_to_be_sold_or_decreases_in_quality() {
        // given
        int initialSellIn = 10;
        int initialQuality = 80;
        Item[] items = getItems(SULFURAS_HAND_OF_RAGNAROS, initialSellIn, initialQuality);
        GildedRose app = new GildedRose(items);
        // when
        app.updateQuality();
        //then
        Item firstItem = app.items[0];
        assertEquals(initialSellIn, firstItem.sellIn);
        assertEquals(initialQuality, firstItem.quality);
    }

    // - "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
    //    Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
    //    Quality drops to 0 after the concert
    @Test
    void backstage_passes_increases_by_1_there_are_more_than_10_days() {
        // given
        int initialSellIn = 11;
        int initialQuality = 25;
        Item[] items = getItems(BACKSTAGE_PASSES, initialSellIn, initialQuality);
        GildedRose app = new GildedRose(items);
        // when
        app.updateQuality();
        //then
        Item firstItem = app.items[0];
        assertEquals(initialQuality + 1, firstItem.quality);
    }

    @Test
    void backstage_passes_increases_by_2_there_are_10_days_or_less() {
        // given
        int initialSellIn = 10;
        int initialQuality = 25;
        Item[] items = getItems(BACKSTAGE_PASSES, initialSellIn, initialQuality);
        GildedRose app = new GildedRose(items);
        // when
        app.updateQuality();
        //then
        Item firstItem = app.items[0];
        assertEquals(initialQuality + 2, firstItem.quality);
    }

    @Test
    void backstage_passes_increases_by_3_there_are_5_days_or_less() {
        // given
        int initialSellIn = 5;
        int initialQuality = 25;
        Item[] items = getItems(BACKSTAGE_PASSES, initialSellIn, initialQuality);
        GildedRose app = new GildedRose(items);
        // when
        app.updateQuality();
        //then
        Item firstItem = app.items[0];
        assertEquals(initialQuality + 3, firstItem.quality);
    }

    @Test
    void backstage_passes_drops_quality_to_0_after_the_concert() {
        // given
        int initialSellIn = 0;
        int initialQuality = 25;
        Item[] items = getItems(BACKSTAGE_PASSES, initialSellIn, initialQuality);
        GildedRose app = new GildedRose(items);
        // when
        app.updateQuality();
        //then
        Item firstItem = app.items[0];
        assertEquals(0, firstItem.quality);
    }

    // - "Conjured" items degrade in Quality twice as fast as normal items
    @Test
    void conjured_items_degrade_in_quality_twice_as_fast_as_normal_items(){
        // given
        int initialSellIn = 11;
        int initialQuality = 25;
        Item[] items = getItems(CONJURED_MANA_CAKE, initialSellIn, initialQuality);
        GildedRose app = new GildedRose(items);
        // when
        app.updateQuality();
        //then
        Item firstItem = app.items[0];
        assertEquals(initialQuality - 2, firstItem.quality);
    }

    @Test
    void conjured_items_degrade_in_quality_twice_as_fast_as_normal_items_also_past_sale_date(){
        // given
        int initialSellIn = 0;
        int initialQuality = 25;
        Item[] items = getItems(CONJURED_MANA_CAKE, initialSellIn, initialQuality);
        GildedRose app = new GildedRose(items);
        // when
        app.updateQuality();
        //then
        Item firstItem = app.items[0];
        assertEquals(initialQuality - 4, firstItem.quality);
    }
}
