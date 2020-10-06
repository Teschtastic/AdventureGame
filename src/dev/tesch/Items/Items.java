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
                true,
                false));

        itemsMap.put(2, new Item(
                "Cardboard boxes",
                "What can I say?\nI like ordering from Amazon",
                "\nYou fashion the boxes into\na makeshift set of armor.",
                2,
                7,
                true,
                false,
                false));

        itemsMap.put(3, new Item(
                "Desktop PC",
                "My AMD beast",
                "\nYou use the PC to play some games.",
                3,
                1,
                false,
                true,
                false));

        itemsMap.put(4, new Item(
                "Sean's Toothbrush",
                "This might be useful.",
                "\nYou take the two toothbrushes.",
                4,
                2,
                true,
                false,
                false));

        itemsMap.put(5, new Item(
                "Jeff's Toothbrush",
                "Is this useful?",
                "And craft them into some stabbies.",
                5,
                4,
                true,
                false,
                false));

        itemsMap.put(6, new Item(
                "Stabby Thingies",
                "Pointy and sharp.",
                "\nNot a useful  sword, yet.",
                6,
                -1,
                false,
                false,
                true));

        itemsMap.put(7, new Item(
                "Cardboard Armor",
                "Protects from pointy sharp things.",
                "\nYou put on the armor.\nYou feel more protected.",
                7,
                -1,
                false,
                true,
                true));
    }
}
