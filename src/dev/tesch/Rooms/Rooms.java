package dev.tesch.Rooms;

import dev.tesch.save.LoadFromFile;

import java.util.HashMap;
import java.util.Map;

public class Rooms {

    // HashMap the rooms are stored in
    public Map<Integer, Room> roomsMap = new HashMap<>();

    public Rooms() {
        // Constructs each room with the index, possible moves, connected rooms (by HashMap index),
        // the room's name, if there is an item in it, and which item is in it
        LoadFromFile.loadRoomsFromFile(roomsMap);

    }
}
