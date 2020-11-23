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
                "\nNot a useful  sword, yet.",
                1,
                -1,
                false,
                false,
                true,
                false,
                true,
                10));
    }
}
