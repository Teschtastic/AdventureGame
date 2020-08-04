package dev.tesch.Actions;

import dev.tesch.NPCs.NPC;
import dev.tesch.Rooms.Room;

import java.util.Map;

public class NPCActions {

    public static void talkToNPC(Map<Integer, NPC> userNpcs, Map<Integer, Room> userRooms, int roomIndex) {
        Room room = userRooms.get(roomIndex);
        NPC npc = userNpcs.get(room.getNpcInRoom());

        if (!room.isHasNPC()) {
            System.out.println("\nThere is nobody to talk to.");
        } else {
            System.out.println("\n" + npc.getName() + " says \"" + npc.getMessage() + "\"");
        }
    }
}
