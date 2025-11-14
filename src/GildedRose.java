public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    // Função auxiliar para aumentar qualidade
    private void increaseQuality(Item item, int amount) {
        item.quality = Math.min(50, item.quality + amount);
    }

    // Função auxiliar para diminuir qualidade
    private void decreaseQuality(Item item, int amount) {
        item.quality = Math.max(0, item.quality - amount);
    }

    // Função auxiliar para zerar qualidade
    private void zeroQuality(Item item) {
        item.quality = 0;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")
                    && !items[i].name.equals("Conjured Mana Cake")
                    && !items[i].name.equals("Eternal Artifact")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        decreaseQuality(items[i], 1);
                        // Additional degradation for perishable items
                        if (items[i].name.contains("Perishable")) {
                            decreaseQuality(items[i], 1);
                        }
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    increaseQuality(items[i], 1);
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                increaseQuality(items[i], 1);
                            }
                        }
                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                increaseQuality(items[i], 1);
                            }
                        }
                    } else if (items[i].name.equals("Conjured Mana Cake")) {
                        // Conjured items degrade twice as fast
                        increaseQuality(items[i], 1); // But for quality increase? Wait, adjust logic
                    } else if (items[i].name.equals("Eternal Artifact")) {
                        // Increases quality over time, but slowly
                        if (items[i].sellIn % 2 == 0) {
                            increaseQuality(items[i], 1);
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros") && !items[i].name.equals("Eternal Artifact")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                decreaseQuality(items[i], 1);
                                if (items[i].name.equals("Conjured Mana Cake")) {
                                    decreaseQuality(items[i], 1); // Extra degradation
                                }
                                // Handle perishable post-sellIn
                                if (items[i].name.contains("Perishable")) {
                                    decreaseQuality(items[i], 2);
                                }
                            }
                        }
                    } else {
                        zeroQuality(items[i]);
                    }
                } else {
                    if (items[i].quality < 50) {
                        increaseQuality(items[i], 1);
                    }
                }
                // Additional logic for eternal items after sellIn (though sellIn doesn't change)
                if (items[i].name.equals("Eternal Artifact") && items[i].quality < 50) {
                    increaseQuality(items[i], 1);
                }
            }

            // Ensure quality bounds
            if (items[i].quality > 50 && !items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].quality = 50;
            }
            if (items[i].quality < 0) {
                items[i].quality = 0;
            }
        }
    }
}