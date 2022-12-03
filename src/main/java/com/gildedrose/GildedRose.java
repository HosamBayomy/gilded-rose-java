package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    /***
     - Once the sell by date has passed, Quality degrades twice as fast
     - The Quality of an item is never negative [quality > 0]
     - "Aged Brie" actually increases in Quality the older it gets ["Aged Brie" quality +]
     - The Quality of an item is never more than 50 [quality <= 50]
     - "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
     - "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
     quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less
     but quality drops to 0 after the concert
     * Just for clarification, an item can never have its Quality increase above 50,
     * however "Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.
     */
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {

                if (items[i].quality > 0) {

                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {

                        if (items[i].sellIn < 11) {

                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {

                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {

                if (!items[i].name.equals("Aged Brie")) {

                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {

                        if (items[i].quality > 0) {

                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}