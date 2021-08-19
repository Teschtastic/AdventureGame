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
                "Sean's bedroom",
                true,
                items.get(2),
                true,
                npcs.get(1),
                true,
                furnitures.get(3)));

        roomsMap.put(2, new Room(
                "Sean's bathroom",
                true,
                items.get(3),
                false,
                null,
                true,
                containers.get(1)));

        roomsMap.put(3, new Room(
                "Inner hallway",
                false,
                null,
                false,
                null,
                false,
                null));

        roomsMap.put(4, new Room(
                "Jeff's bathroom",
                true,
                items.get(4),
                false,
                null,
                false,
                null));

        roomsMap.put(5, new Room(
                "Jeff's bedroom",
                false,
                null,
                true,
                npcs.get(2),
                true,
                furnitures.get(4)));

        roomsMap.put(6, new Room(
                "Outer hallway",
                false,
                null,
                false,
                null,
                false,
                null));

        roomsMap.put(7, new Room(
                "Dining room",
                true,
                items.get(1),
                false,
                null,
                true,
                furnitures.get(2)));

        roomsMap.put(8, new Room(
                "Kitchen",
                false,
                null,
                false,
                null,
                true,
                containers.get(2)));

        roomsMap.put(9, new Room(
                "Living room",
                false,
                null,
                false,
                null,
                true,
                furnitures.get(1)));

        roomsMap.put(10, new Room(
                "Porch",
                false,
                null,
                true,
                npcs.get(3),
                false,
                null));

        roomsMap.get(1).setConnRooms(
                new HashMap<>() {{
                    put("N", null);
                    put("E", roomsMap.get(3));
                    put("S", roomsMap.get(2));
                    put("W", null);
                }}
        );

        roomsMap.get(2).setConnRooms(
                new HashMap<>() {{
                    put("N", roomsMap.get(1));
                    put("E", null);
                    put("S", null);
                    put("W", null);
                }}
        );

        roomsMap.get(3).setConnRooms(
                new HashMap<>() {{
                    put("N", roomsMap.get(6));
                    put("E", roomsMap.get(5));
                    put("S", roomsMap.get(4));
                    put("W", roomsMap.get(1));
                }}
        );

        roomsMap.get(4).setConnRooms(
                new HashMap<>() {{
                    put("N", roomsMap.get(3));
                    put("E", null);
                    put("S", null);
                    put("W", null);
                }}
        );

        roomsMap.get(5).setConnRooms(
                new HashMap<>() {{
                    put("N", null);
                    put("E", null);
                    put("S", null);
                    put("W", roomsMap.get(3));
                }}
        );

        roomsMap.get(6).setConnRooms(
                new HashMap<>() {{
                    put("N", roomsMap.get(8));
                    put("E", roomsMap.get(7));
                    put("S", roomsMap.get(3));
                    put("W", roomsMap.get(9));
                }}
        );

        roomsMap.get(7).setConnRooms(
                new HashMap<>() {{
                    put("N", null);
                    put("E", null);
                    put("S", null);
                    put("W", roomsMap.get(6));
                }}
        );

        roomsMap.get(8).setConnRooms(
                new HashMap<>() {{
                    put("N", null);
                    put("E", null);
                    put("S", roomsMap.get(6));
                    put("W", null);
                }}
        );

        roomsMap.get(9).setConnRooms(
                new HashMap<>() {{
                    put("N", null);
                    put("E", roomsMap.get(6));
                    put("S", null);
                    put("W", roomsMap.get(10));
                }}
        );

        roomsMap.get(10).setConnRooms(
                new HashMap<>() {{
                    put("N", null);
                    put("E", roomsMap.get(9));
                    put("S", null);
                    put("W", null);
                }}
        );
    }
}
