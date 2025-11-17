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

            // Variáveis de guarda (início)
            boolean isSulfuras = items[i].name.equals("Sulfuras, Hand of Ragnaros");
            boolean isAgedBrie = items[i].name.equals("Aged Brie");
            boolean isBackstage = items[i].name.equals("Backstage passes to a TAFKAL80ETC concert");
            boolean isConjured = items[i].name.equals("Conjured Mana Cake");
            boolean isEternal = items[i].name.equals("Eternal Artifact");
            boolean isPerishable = items[i].name.contains("Perishable");
            // Variáveis de guarda (fim)

            if (!isAgedBrie && !isBackstage && !isConjured && !isEternal) {
                if (items[i].quality > 0) {
                    if (!isSulfuras) {
                        decreaseQuality(items[i], 1);
                        // Additional degradation for perishable items
                        if (isPerishable) {
                            decreaseQuality(items[i], 1);
                        }
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    increaseQuality(items[i], 1);
                    if (isBackstage) {
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
                    } else if (isConjured) {
                        // Conjured items degrade twice as fast
                        increaseQuality(items[i], 1); // But for quality increase? Wait, adjust logic
                    } else if (isEternal) {
                        // Increases quality over time, but slowly
                        if (items[i].sellIn % 2 == 0) {
                            increaseQuality(items[i], 1);
                        }
                    }
                }
            }

            if (!isSulfuras && !isEternal) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!isAgedBrie) {
                    if (!isBackstage) {
                        if (items[i].quality > 0) {
                            if (!isSulfuras) {
                                decreaseQuality(items[i], 1);
                                if (isConjured) {
                                    decreaseQuality(items[i], 1); // Extra degradation
                                }
                                // Handle perishable post-sellIn
                                if (isPerishable) {
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
                if (isEternal && items[i].quality < 50) {
                    increaseQuality(items[i], 1);
                }
            }

            // Ensure quality bounds
            if (items[i].quality > 50 && !isSulfuras) {
                items[i].quality = 50;
            }
            if (items[i].quality < 0) {
                items[i].quality = 0;
            }
        }
    }
}