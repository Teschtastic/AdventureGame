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
                1,
                new int[] {0, 1, 1, 0},
                new int[] {-1, 3, 2, -1},
                "Sean's bedroom",
                true,
                3,
                items.get(3),
                true,
                1,
                npcs.get(1),
                true,
                3,
                furnitures.get(3)));

        roomsMap.put(2, new Room(
                2,
                new int[] {1, 0, 0, 0},
                new int[] {1, -1, -1, -1},
                "Sean's bathroom",
                true,
                4,
                items.get(4),
                false,
                -1,
                null,
                true,
                1,
                containers.get(1)));

        roomsMap.put(3, new Room(
                3,
                new int[] {1, 1, 1, 1},
                new int[] {6, 5, 4, 1},
                "Inner hallway",
                false,
                -1,
                null,
                false,
                -1,
                null,
                false,
                -1,
                null));

        roomsMap.put(4, new Room(
                4,
                new int[] {1, 0, 0, 0},
                new int[] {3, -1, -1, -1},
                "Jeff's bathroom",
                true,
                5,
                items.get(5),
                false,
                -1,
                null,
                false,
                -1,
                null));

        roomsMap.put(5, new Room(
                5,
                new int[] {0, 0, 0, 1},
                new int[] {-1, -1, -1, 3},
                "Jeff's bedroom",
                false,
                -1,
                null,
                true,
                2,
                npcs.get(2),
                true,
                4,
                furnitures.get(4)));

        roomsMap.put(6, new Room(
                6,
                new int[] {1, 1, 1, 1},
                new int[] {8, 7, 3, 9},
                "Outer hallway",
                false,
                -1,
                null,
                false,
                -1,
                null,
                false,
                -1,
                null));

        roomsMap.put(7, new Room(
                7,
                new int[] {0, 0, 0, 1},
                new int[] {-1, -1, -1, 6},
                "Dining room",
                true,
                2,
                items.get(2),
                false,
                -1,
                null,
                true,
                2,
                furnitures.get(2)));

        roomsMap.put(8, new Room(
                8,
                new int[] {0, 0, 1, 0},
                new int[] {-1, -1, 6, -1},
                "Kitchen",
                true,
                1,
                items.get(1),
                false,
                -1,
                null,
                false,
                -1,
                null));

        roomsMap.put(9, new Room(
                9,
                new int[] {0, 1, 0, 1},
                new int[] {-1, 6, -1, 10},
                "Living room",
                false,
                -1,
                null,
                false,
                -1,
                null,
                true,
                1,
                furnitures.get(1)));

        roomsMap.put(10, new Room(
                10,
                new int[]{0, 1, 0, 0},
                new int[] {-1, 9, -1, -1},
                "Porch",
                false,
                -1,
                null,
                true,
                3,
                npcs.get(3),
                false,
                -1,
                null));
    }
}
