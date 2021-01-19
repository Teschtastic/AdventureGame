package dev.tesch.Furniture;

import dev.tesch.Items.Item;
import dev.tesch.Items.Items;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Containers {
    public HashMap<Integer, Container> containersMap = new HashMap<>();

    public Containers() {
        Map<Integer, Item> items = new Items().itemsMap;

        containersMap.put(1, new Container(
                "Chest",
                "A run of the mill chest.",
                "\nYou open the chest to see what's inside.",
                1,
                2,
                true,
                Arrays.asList(new Item[]{items.get(1)})
        ));
    }
}
