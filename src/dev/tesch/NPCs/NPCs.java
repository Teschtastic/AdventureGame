package dev.tesch.NPCs;

import dev.tesch.Items.*;

import java.util.HashMap;
import java.util.Map;

public class NPCs {

    // Different item maps
    Map<Integer, Item>          items       = new Items().itemsMap;
    Map<Integer, Armor>         armors      = new Armors().armorMap;
    Map<Integer, Weapon>        weapons     = new Weapons().weaponMap;
    Map<Integer, Consumable>    consumables = new Consumables().consumablesMap;

    // HashMap the NPCs are stored in
    public Map<Integer, NPC> npcMap = new HashMap<>();

    public NPCs() {
        npcMap.put(1, new NPC(
                "Claudia",
                "Hi Seanie!",
                1,
                100,
                true,
                false,
                -1,
                null));

        npcMap.put(2, new NPC(
                "Jeff",
                "Hi bitch!",
                2,
                100,
                true,
                false,
                -1,
                null));

        npcMap.put(3, new NPC(
                "Michaela",
                "My Man!",
                3,
                100,
                true,
                false,
                -1,
                null));
    }
}
