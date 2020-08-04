package dev.tesch.Actions;

import dev.tesch.NPCs.NPC;
import dev.tesch.Player.Player;
import dev.tesch.Rooms.Room;

import java.util.Map;

public class NPCActions {

    public static void talkToNPC(Player player, Map<Integer, NPC> userNpcs, Map<Integer, Room> userRooms) {
        Room room = userRooms.get(player.getRoomIsIn());
        NPC npc = userNpcs.get(room.getNpcInRoom());

        if (!room.isHasNPC()) {
            System.out.println("\nThere is nobody to talk to.");
        } else {
            System.out.println("\n" + npc.getName() + " says \"" + npc.getMessage() + "\"");
        }
    }
}
