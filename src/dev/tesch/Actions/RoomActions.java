package dev.tesch.Actions;

import dev.tesch.Furniture.Furniture;
import dev.tesch.Items.Item;
import dev.tesch.NPCs.NPC;
import dev.tesch.Player.Player;
import dev.tesch.Rooms.Room;

import java.util.Map;

public class RoomActions {

    /* Method to display which room you're in */
    public static void printLocation(Player player, Map<Integer, Room> userRooms) {
        userRooms.get(player.getRoomIsIn()).getInMessage();
    }

    /* Method used to change rooms */
    public static void move(Player player, Map<Integer, Room> userRooms) {
        String[] directions = {"N", "E", "S", "W"};
        String moveDirection = player.getChoice().toUpperCase();
        Room currentRoom = userRooms.get(player.getRoomIsIn());
        int[] currentRoomMoves = currentRoom.getMoveIndices();
        int[] connectedRooms = currentRoom.getConnectedRooms();

        // Checks which direction you want to move and if you can move there
        for (int i = 0; i < directions.length; i++) {
            // If you can move there, prints which room you're leaving
            if (moveDirection.equals(directions[i]) && currentRoomMoves[i] == 1) {
                System.out.println("\nYou went " + moveDirection + "\n");
                currentRoom.getLeaveMessage();
                userRooms.get(connectedRooms[i]).getEnterMessage();
                player.setRoomIsIn(connectedRooms[i]);
                return;
            }
        }

        // If you can't move, tells you so
        System.out.println("\nCouldn't move that way.");
    }

    /* Method used to look in the room you're in */
    public static void lookAround(Player player, Map<Integer, NPC> userNpcs, Map<Integer, Room> userRooms, Map<Integer, Item> userItems, Map<Integer, Furniture> userFurnitures) {
        Room room = userRooms.get(player.getRoomIsIn());

        room.getInMessage();

        if (!room.isHasNPC()) {
            System.out.println("You don't see any people.");
        } else {
            NPC npc = userNpcs.get(room.getNpcInRoom());
            System.out.println("You see " + npc.getName());
        }

        if (!room.isHasItem())
            System.out.println("You don't see any items.");
        else {
            Item item = userItems.get(room.getItemInRoom());
            System.out.println("You see the " + item.getName());
        }

        if (!room.isHasFurniture())
            System.out.println("You don't see any furniture.");
        else {
            Furniture furniture = userFurnitures.get(room.getFurnitureInRoom());
            System.out.println("You see the " + furniture.getName());
        }
    }
}
