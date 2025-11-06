public class Main {
    public static void main(String[] args) {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Conjured Mana Cake", 3, 6),
                new Item("Eternal Artifact", 5, 40),
                new Item("Perishable Fruit", 4, 10)
        };

        GildedRose app = new GildedRose(items);

        // Simulate one day
        app.updateQuality();

        // Print updated items
        for (Item item : items) {
            System.out.println(item);
        }
    }
}