package dev.tesch.Items;

import java.util.HashMap;
import java.util.Map;

public class Weapons {

    // HashMap the armors are stored in
    public Map<Integer, Weapon> weaponMap = new HashMap<>();

    public Weapons() {

        weaponMap.put(1, new Weapon(
                "Stabby Thingies",
                "Pointy and sharp.",
                "\nOne pointy 'brush' for each hand",
                2,
                true,
                false,
                true,
                false,
                true,
                10));
    }
}
