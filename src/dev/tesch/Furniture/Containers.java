package dev.tesch.Furniture;

import dev.tesch.Items.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Containers {
    public HashMap<Integer, Container> containersMap = new HashMap<>();

    public Containers() {
        Map<Integer, Item> items = new Items().itemsMap;
        //Map<Integer, Consumable> consumables = new Consumables().consumablesMap;
        Map<Integer, Armor> armors = new Armors().armorMap;
        Map<Integer, Weapon> weapons = new Weapons().weaponMap;

        containersMap.put(1, new Container(
                "Chest",
                "A run of the mill chest.",
                "\nYou open the chest to see what's inside.",
                1,
                2,
                true,
                new LinkedList<>(Arrays.asList(items.get(1), items.get(2), armors.get(1), weapons.get(1)))
        ));
    }
}
