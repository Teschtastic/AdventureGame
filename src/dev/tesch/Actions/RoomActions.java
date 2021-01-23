package dev.tesch.Actions;

import dev.tesch.Furniture.Furniture;
import dev.tesch.Items.Item;
import dev.tesch.NPCs.NPC;
import dev.tesch.Player.Player;
import dev.tesch.Player.UsedItemOnPlayer;
import dev.tesch.Rooms.Room;

import java.util.Map;

public class RoomActions {

    /* Method to display which room you're in */
    public static void printLocation(Player player) {
        Room room = player.getRoomIsIn();
        room.getInMessage();
        System.out.println(room.getMoves(room.getMoveIndices()));
    }

    /* Method used to change rooms */
    // TODO: Redo this stinky method, maybe need to edit the room class
    public static void move(Player player, Map<Integer, Room> userRooms) {
        String[] directions = {"N", "E", "S", "W"};
        String moveDirection = player.getChoice().toUpperCase();
        Room currentRoom = player.getRoomIsIn();
        int[] currentRoomMoves = currentRoom.getMoveIndices();
        int[] connectedRooms = currentRoom.getConnectedRooms();

        // Checks which direction you want to move and if you can move there
        for (int i = 0; i < directions.length; i++) {
            // If you can move there, prints which room you're leaving
            if (moveDirection.equals(directions[i]) && currentRoomMoves[i] == 1) {
                System.out.println("\nYou went " + moveDirection + "\n");
                currentRoom.getLeaveMessage();
                userRooms.get(connectedRooms[i]).getEnterMessage();
                player.setRoomIsIn(userRooms.get(connectedRooms[i]));
                return;
            }
        }

        // If you can't move, tells you so
        System.out.println("\nCouldn't move that way.");
    }

    /* Method used to look in the room you're in */
    public static void lookAround(Player player) {
        Room room = player.getRoomIsIn();

        room.getInMessage();

        if (!room.isHasItem())
            System.out.println("\nYou don't see any items.");
        else {
            Item item = room.getItemInRoom();
            System.out.println("\nYou see the " + item.getName());
        }

        if (!room.isHasNPC()) {
            System.out.println("You don't see any people.");
        } else {
            NPC npc = room.getNpcInRoom();
            System.out.println("You see " + npc.getName());
        }

        if (!room.isHasFurniture())
            System.out.println("You don't see any furniture.");
        else {
            Furniture furniture = room.getFurnitureInRoom();
            System.out.println("You see the " + furniture.getName());
        }
    }

    public static void useItemInRoom(Player player) {
        Room room = player.getRoomIsIn();
        Item item = room.getItemInRoom();

        if (room.isHasItem() && item.isCanUse()) {
            System.out.println(item.getUseMessage());
            UsedItemOnPlayer.useItem(player, item);
        }
        else if (room.isHasItem() && !item.isCanUse())
            System.out.println("\nYou can't use the " + item.getName());
        else
            System.out.println("\nThere is no item in the room to use.");
    }
}
