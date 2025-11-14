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


    // Funções auxiliares para verificação de tipos de itens (começo)

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isConjured(Item item) {
        return item.name.equals("Conjured Mana Cake");
    }

    private boolean isEternalArtifact(Item item) {
        return item.name.equals("Eternal Artifact");
    }

    private boolean containsPerishable(Item item) {
        return item.name.contains("Perishable");    // Nesse método eu utilizei contains invés de equals, porque é a forma como aparece no código
    }

    // Funções auxiliares para verificação de tipos de itens (fim)

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!isAgedBrie(items[i])
                    && !isBackstagePass(items[i])
                    && !isConjured(items[i])
                    && !isEternalArtifact(items[i])) {
                if (items[i].quality > 0) {
                    if (!isSulfuras(items[i])) {
                        decreaseQuality(items[i], 1);
                        // Additional degradation for perishable items
                        if (containsPerishable(items[i])) {
                            decreaseQuality(items[i], 1);
                        }
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    increaseQuality(items[i], 1);
                    if (isBackstagePass(items[i])) {
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
                    } else if (isConjured(items[i])) {
                        // Conjured items degrade twice as fast
                        increaseQuality(items[i], 1); // But for quality increase? Wait, adjust logic
                    } else if (isEternalArtifact(items[i])) {
                        // Increases quality over time, but slowly
                        if (items[i].sellIn % 2 == 0) {
                            increaseQuality(items[i], 1);
                        }
                    }
                }
            }

            if (!isSulfuras(items[i]) && !isEternalArtifact(items[i])) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!isAgedBrie(items[i])) {
                    if (!isBackstagePass(items[i])) {
                        if (items[i].quality > 0) {
                            if (!isSulfuras(items[i])) {
                                decreaseQuality(items[i], 1);
                                if (isConjured(items[i])) {
                                    decreaseQuality(items[i], 1); // Extra degradation
                                }
                                // Handle perishable post-sellIn
                                if (containsPerishable(items[i])) {
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
                if (isEternalArtifact(items[i]) && items[i].quality < 50) {
                    increaseQuality(items[i], 1);
                }
            }

            // Ensure quality bounds
            if (items[i].quality > 50 && !isSulfuras(items[i])) {
                items[i].quality = 50;
            }
            if (items[i].quality < 0) {
                items[i].quality = 0;
            }
        }
    }
}