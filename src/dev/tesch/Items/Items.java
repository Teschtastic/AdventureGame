package dev.tesch.Items;

import java.util.HashMap;
import java.util.Map;

public class Items {

    // HashMap the items are stored in
    public Map<Integer, Item> itemsMap = new HashMap<>();

    public Items() {
        // Constructs each item with it's index, name, description, room location, and if the player can pick it up
        itemsMap.put(1, new Item("Dr. Pepper", "Yummy, delicious nectar of the gods", 1, 8, true));
        itemsMap.put(2, new Item("Desktop PC", "My AMD beast", 2, 1, false));
        itemsMap.put(3, new Item("Camping chair", "The only furniture in the living room", 3, 9, false));
        itemsMap.put(4, new Item("Cardboard boxes", "What can I say, I like ordering from Amazon", 4, 7, true));
    }
}
