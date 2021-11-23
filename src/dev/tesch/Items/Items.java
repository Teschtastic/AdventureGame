package dev.tesch.Items;

import java.util.HashMap;
import java.util.Map;

public class Items {

    // HashMap the items are stored in
    public Map<Integer, Item> itemsMap = new HashMap<>();

    public Items() {
        // Constructs each item with its index, name, description, room location, and if the player can pick it up
        itemsMap.put(1, new Item(
                "Cardboard boxes",
                "What can I say?\nI like ordering from Amazon",
                "\nYou fashion the boxes into\na makeshift set of armor.",
                2,
                true,
                false,
                false,
                false,
                false));

        itemsMap.put(2, new Item(
                "Desktop PC",
                "My AMD beast",
                "\nYou use the PC to play some games.",
                50,
                false,
                true,
                false,
                false,
                false));

        itemsMap.put(3, new Item(
                "Sean's Toothbrush",
                "This might be useful.",
                "\nYou take the two toothbrushes.",
                1,
                true,
                false,
                false,
                false,
                false));

        itemsMap.put(4, new Item(
                "Jeff's Toothbrush",
                "Is this useful?",
                "And craft them into some stabbies.",
                1,
                true,
                false,
                false,
                false,
                false));
    }
}
