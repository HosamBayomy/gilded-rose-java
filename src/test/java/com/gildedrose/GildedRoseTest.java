package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    @Test
    public void testThrowsNPE() {
        GildedRose app = new GildedRose(null);
        try {
            app.updateQuality();
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testEmptyItems() {
        Item[] items = new Item[] {};
        GildedRose app = new GildedRose(items);
        assertEquals(0, app.items.length);
    }

    @Test
    void testDecreaseQualityByOneWhereQualityGreaterThanZero_OtherItems() {
        Item[] items = new Item[] {
                new Item("foo", 1, 0),
                new Item("foo", 1, 1),
                new Item("foo", 1, 2),
                new Item("foo", 1, 3)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[1].quality);
        assertEquals(0, app.items[1].sellIn);
        assertEquals(1, app.items[2].quality);
        assertEquals(0, app.items[2].sellIn);
        assertEquals(2, app.items[3].quality);
        assertEquals(0, app.items[3].sellIn);
    }

    @Test
    void testSellInPassedDecreaseQualityByTwoWhereQualityGreaterThanZero_OtherItems() {
        Item[] items = new Item[] {
                new Item("foo", 0, 0),
                new Item("foo", 0, 1),
                new Item("foo", 0, 2),
                new Item("foo", 0, 3),
                new Item("foo", 0, 4)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[1].quality);
        assertEquals(-1, app.items[1].sellIn);
        assertEquals(0, app.items[2].quality);
        assertEquals(-1, app.items[2].sellIn);
        assertEquals(1, app.items[3].quality);
        assertEquals(-1, app.items[3].sellIn);
        assertEquals(2, app.items[4].quality);
        assertEquals(-1, app.items[4].sellIn);
    }

    @Test
    void testDecreaseQualityByOneWhereQualityGreaterThanZero_Conjured() {
        Item[] items = new Item[] {
                new Item("Conjured", 1, 0),
                new Item("Conjured", 1, 1),
                new Item("Conjured", 1, 2),
                new Item("Conjured", 1, 3),
                new Item("Conjured", 1, 4),
                new Item("Conjured", 1, 5)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[1].quality);
        assertEquals(0, app.items[1].sellIn);
        assertEquals(0, app.items[2].quality);
        assertEquals(0, app.items[2].sellIn);
        assertEquals(1, app.items[3].quality);
        assertEquals(0, app.items[3].sellIn);
        assertEquals(2, app.items[4].quality);
        assertEquals(0, app.items[4].sellIn);
        assertEquals(3, app.items[5].quality);
        assertEquals(0, app.items[5].sellIn);
    }

    @Test
    void testSellInPassedDecreaseQualityByTwoWhereQualityGreaterThanZero_Conjured() {
        Item[] items = new Item[] {
                new Item("Conjured", 0, 0),
                new Item("Conjured", 0, 1),
                new Item("Conjured", 0, 2),
                new Item("Conjured", 0, 3),
                new Item("Conjured", 0, 4),
                new Item("Conjured", 0, 5),
                new Item("Conjured", 0, 6),
                new Item("Conjured", 0, 7)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[1].quality);
        assertEquals(-1, app.items[1].sellIn);
        assertEquals(0, app.items[2].quality);
        assertEquals(-1, app.items[2].sellIn);
        assertEquals(0, app.items[3].quality);
        assertEquals(-1, app.items[3].sellIn);
        assertEquals(0, app.items[4].quality);
        assertEquals(-1, app.items[4].sellIn);
        assertEquals(1, app.items[5].quality);
        assertEquals(-1, app.items[5].sellIn);
        assertEquals(2, app.items[6].quality);
        assertEquals(-1, app.items[6].sellIn);
        assertEquals(3, app.items[7].quality);
        assertEquals(-1, app.items[7].sellIn);
    }

    @Test
    void testIncreaseQualityByOneWhereQualityLessThanFifty_AgedBrie() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 1, 45),
                new Item("Aged Brie", 1, 49),
                new Item("Aged Brie", 1, 50),
                new Item("Aged Brie", 1, 0)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(46, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(50, app.items[1].quality);
        assertEquals(0, app.items[1].sellIn);
        assertEquals(50, app.items[2].quality);
        assertEquals(0, app.items[2].sellIn);
        assertEquals(1, app.items[3].quality);
        assertEquals(0, app.items[3].sellIn);
    }

    @Test
    void testSellInPassedIncreaseQualityByTwoWhereQualityLessThanFifty_AgedBrie() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 0, 45),
                new Item("Aged Brie", 0, 49),
                new Item("Aged Brie", 0, 50),
                new Item("Aged Brie", 0, 0)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(47, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(50, app.items[1].quality);
        assertEquals(-1, app.items[1].sellIn);
        assertEquals(50, app.items[2].quality);
        assertEquals(-1, app.items[2].sellIn);
        assertEquals(2, app.items[3].quality);
        assertEquals(-1, app.items[3].sellIn);
    }

    @Test
    void testIncreaseQualityByTwoWhereQualityLessThanFiftyAndSellInLessThanEleven_Backstage() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 45),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 48),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(47, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[1].quality);
        assertEquals(9, app.items[1].sellIn);
        assertEquals(50, app.items[2].quality);
        assertEquals(9, app.items[2].sellIn);
        assertEquals(50, app.items[3].quality);
        assertEquals(9, app.items[3].sellIn);
        assertEquals(2, app.items[4].quality);
        assertEquals(9, app.items[4].sellIn);
    }

    @Test
    void testIncreaseQualityByThreeWhereQualityLessThanFiftyAndSellInLessThanSix_Backstage() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 45),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 48),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 0)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(48, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(50, app.items[1].quality);
        assertEquals(0, app.items[1].sellIn);
        assertEquals(50, app.items[2].quality);
        assertEquals(0, app.items[2].sellIn);
        assertEquals(50, app.items[3].quality);
        assertEquals(0, app.items[3].sellIn);
        assertEquals(3, app.items[4].quality);
        assertEquals(0, app.items[4].sellIn);
    }

    @Test
    void testSellInPassedResetQualityToZeroWhereQualityLessThanFifty_Backstage() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 45),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 48),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[1].quality);
        assertEquals(-1, app.items[1].sellIn);
        assertEquals(0, app.items[2].quality);
        assertEquals(-1, app.items[2].sellIn);
        assertEquals(0, app.items[3].quality);
        assertEquals(-1, app.items[3].sellIn);
        assertEquals(0, app.items[4].quality);
        assertEquals(-1, app.items[4].sellIn);
    }
}
