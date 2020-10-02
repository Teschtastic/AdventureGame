package dev.tesch.Items;

import java.util.HashMap;
import java.util.Map;

public class Items {

    // HashMap the items are stored in
    public Map<Integer, Item> itemsMap = new HashMap<>();

    public Items() {
        // Constructs each item with it's index, name, description, room location, and if the player can pick it up
        itemsMap.put(1, new Item(
                "Dr. Pepper",
                "Yummy, delicious nectar of the gods",
                "\nYou drink your Dr. Pepper.\nYou feel powerful!",
                1,
                8,
                true,
                true));

        itemsMap.put(2, new Item(
                "Cardboard boxes",
                "What can I say?\nI like ordering from Amazon",
                "\nYou fashion the boxes into\na makeshift set of armor.",
                2,
                7,
                true,
                true));
    }
}
