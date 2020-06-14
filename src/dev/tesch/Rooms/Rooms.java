package dev.tesch.Rooms;

import java.util.HashMap;
import java.util.Map;

public class Rooms {

    // HashMap the rooms are stored in
    public Map<Integer, Room> roomsMap = new HashMap<>();

    public Rooms() {
        // Constructs each room with the index, possible moves, connected rooms (by HashMap index), the room's name, if there is an item in it, and which item is in it
        roomsMap.put(1, new Room(1, new int[]{0, 1, 1, 0}, new int[] {-1, 3, 2, -1}, "Sean's bedroom", true, 2));
        roomsMap.put(2, new Room(2, new int[]{1, 0, 0, 0}, new int[] {1, -1, -1, -1}, "Sean's bathroom", false, -1));
        roomsMap.put(3, new Room(3, new int[]{1, 1, 1, 1}, new int[] {6, 5, 4, 1}, "Apartment inner hallway", false, -1));
        roomsMap.put(4, new Room(4, new int[]{1, 0, 0, 0}, new int[] {3, -1, -1, -1}, "Jack's bathroom", false, -1));
        roomsMap.put(5, new Room(5, new int[]{0, 0, 0, 1}, new int[] {-1, -1, -1, 3}, "Jack's bedroom", false, -1));

        roomsMap.put(6, new Room(6, new int[]{1, 1, 1, 1}, new int[] {8, 7, 3, 9}, "Apartment outer hallway", false, -1));
        roomsMap.put(7, new Room(7, new int[]{0, 0, 0, 1}, new int[] {-1, -1, -1, 6}, "Apartment dining room", true, 4));
        roomsMap.put(8, new Room(8, new int[]{0, 0, 1, 0}, new int[] {-1, -1, 6, -1}, "Apartment kitchen", true, 1));
        roomsMap.put(9, new Room(9, new int[]{0, 1, 0, 0}, new int[] {-1, 6, -1, -1}, "Apartment living room", true, 3));
    }
}
