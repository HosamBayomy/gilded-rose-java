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
     - "Conjured" items degrade in Quality twice as fast as normal items
     */
    public void updateQuality() {
        for (Item item : items) {
            int qualityDecreaseRate = 1;
            int qualityMinimum = 1;

            if (item.name.equals("Conjured")) {
                qualityDecreaseRate *= 2;
            }

            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {

                if (item.quality >= qualityMinimum) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.quality = Math.max(0, item.quality - qualityDecreaseRate);
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality >= qualityMinimum) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = Math.max(0, item.quality - qualityDecreaseRate);
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}