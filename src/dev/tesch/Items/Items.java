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
                "Desktop PC",
                "My AMD beast",
                "\nYou use the PC to play some games.",
                2,
                1,
                false,
                true));

        itemsMap.put(3, new Item(
                "Camping chair",
                "The only furniture in the living room",
                "\nThe chair's magical properties seem\nto have healed you to full health",
                3,
                9,
                false,
                true));

        itemsMap.put(4, new Item(
                "Cardboard boxes",
                "What can I say?\nI like ordering from Amazon",
                "\nYou fashion the boxes into\na makeshift set of armor.",
                4,
                7,
                true,
                true));
    }
}
