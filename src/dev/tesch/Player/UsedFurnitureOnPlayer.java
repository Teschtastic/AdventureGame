package dev.tesch.Player;

import dev.tesch.Furniture.Furniture;
import dev.tesch.NPCs.NPC;
import dev.tesch.Rooms.Room;

import java.util.Map;

public class UsedFurnitureOnPlayer {

    public static void useFurniture(Player player, Furniture furniture, Map<Integer, Room> userRooms, Map<Integer, NPC> userNPCs) {
        switch (furniture.getName()) {
            case "Camping chair":
                usedCampingChair(player);
                break;

            case "Bed":
                usedBed(player, userRooms, userNPCs);
                break;

            default:
                System.out.println("\nThis doesn't seem to help you");
        }
    }

    private static void usedCampingChair(Player player) {
        System.out.println("\nYour health has been restored.");
        player.setCurrentHealth(player.getMaximumHealth());
    }

    private static void usedBed(Player player, Map<Integer, Room> userRooms, Map<Integer, NPC> userNPCs) {
        Room room = userRooms.get(player.getRoomIsIn());
        NPC npc = null;

        if (room.isHasNPC()) {
            npc = userNPCs.get(room.getNpcInRoom());

            if (npc.getName().equals("Claudia")) {
                System.out.println("\n" + npc.getName() + " does that thing you like.\nYour max health increases by 50\nand your health has been restored.");
                player.setMaximumHealth(player.getMaximumHealth() + 50);
                player.setCurrentHealth(player.getMaximumHealth());
            }
        }
        else if (!room.isHasNPC() || npc == null) {
            System.out.println("\nYour max health increases by 25");
            player.setMaximumHealth(player.getMaximumHealth() + 25);
        }
    }
}
