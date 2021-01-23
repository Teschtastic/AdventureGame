package dev.tesch.Rooms;

import dev.tesch.Furniture.Container;
import dev.tesch.Furniture.Containers;
import dev.tesch.Furniture.Furniture;
import dev.tesch.Furniture.Furnitures;
import dev.tesch.Items.*;
import dev.tesch.NPCs.NPC;
import dev.tesch.NPCs.NPCs;

import java.util.HashMap;
import java.util.Map;

public class Rooms {

    // Different item maps
    Map<Integer, Item>          items       = new Items().itemsMap;
    Map<Integer, Armor>         armors      = new Armors().armorMap;
    Map<Integer, Weapon>        weapons     = new Weapons().weaponMap;
    Map<Integer, Consumable>    consumables = new Consumables().consumablesMap;

    // Different NPC maps
    Map<Integer, NPC>           npcs        = new NPCs().npcMap;

    // Different furniture maps
    Map<Integer, Furniture>     furnitures  = new Furnitures().furnituresMap;
    Map<Integer, Container>     containers  = new Containers().containersMap;

    // HashMap the rooms are stored in
    public Map<Integer, Room> roomsMap = new HashMap<>();

    public Rooms() {
        // Constructs each room with the index, possible moves, connected rooms (by HashMap index), the room's name, if there is an item in it, and which item is in it
        roomsMap.put(1, new Room(
                new int[] {0, 1, 1, 0},
                new int[] {-1, 3, 2, -1},
                "Sean's bedroom",
                true,
                items.get(3),
                true,
                npcs.get(1),
                true,
                furnitures.get(3)));

        roomsMap.put(2, new Room(
                new int[] {1, 0, 0, 0},
                new int[] {1, -1, -1, -1},
                "Sean's bathroom",
                true,
                items.get(4),
                false,
                null,
                true,
                containers.get(1)));

        roomsMap.put(3, new Room(
                new int[] {1, 1, 1, 1},
                new int[] {6, 5, 4, 1},
                "Inner hallway",
                false,
                null,
                false,
                null,
                false,
                null));

        roomsMap.put(4, new Room(
                new int[] {1, 0, 0, 0},
                new int[] {3, -1, -1, -1},
                "Jeff's bathroom",
                true,
                items.get(5),
                false,
                null,
                false,
                null));

        roomsMap.put(5, new Room(
                new int[] {0, 0, 0, 1},
                new int[] {-1, -1, -1, 3},
                "Jeff's bedroom",
                false,
                null,
                true,
                npcs.get(2),
                true,
                furnitures.get(4)));

        roomsMap.put(6, new Room(
                new int[] {1, 1, 1, 1},
                new int[] {8, 7, 3, 9},
                "Outer hallway",
                false,
                null,
                false,
                null,
                false,
                null));

        roomsMap.put(7, new Room(
                new int[] {0, 0, 0, 1},
                new int[] {-1, -1, -1, 6},
                "Dining room",
                true,
                items.get(2),
                false,
                null,
                true,
                furnitures.get(2)));

        roomsMap.put(8, new Room(
                new int[] {0, 0, 1, 0},
                new int[] {-1, -1, 6, -1},
                "Kitchen",
                true,
                items.get(1),
                false,
                null,
                false,
                null));

        roomsMap.put(9, new Room(
                new int[] {0, 1, 0, 1},
                new int[] {-1, 6, -1, 10},
                "Living room",
                false,
                null,
                false,
                null,
                true,
                furnitures.get(1)));

        roomsMap.put(10, new Room(
                new int[]{0, 1, 0, 0},
                new int[] {-1, 9, -1, -1},
                "Porch",
                false,
                null,
                true,
                npcs.get(3),
                false,
                null));
    }
}
