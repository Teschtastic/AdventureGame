package dev.tesch;

import dev.tesch.Items.*;

import java.util.HashMap;
import java.util.Map;

public class AllItems {

    // Different Item maps
    public Map<Integer, Item>           items;
    public Map<Integer, Armor>          armors;
    public Map<Integer, Weapon>         weapons;
    public Map<Integer, Consumable>     consumables;

    public AllItems() {

        items = new Items().itemsMap;
        armors = new Armors().armorMap;
        weapons = new Weapons().weaponMap;
        consumables = new Consumables().consumablesMap;
    }
}
