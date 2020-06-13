package dev.tesch.Items;

import java.util.HashMap;
import java.util.Map;

public class Items {

    // HashMap the items are stored in
    public Map<Integer, Item> itemsMap = new HashMap<>();

    public Items() {
        // Constructs each item with it's index, name, description, room location, and if the player can pick it up
        itemsMap.put(1, new Item("Dr. Pepper", "Yummy, delicious nectar of the gods", 8, true));
        itemsMap.put(2, new Item("Desktop PC", "My AMD beast", 1, false));
    }
}
