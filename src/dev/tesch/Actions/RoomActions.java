package dev.tesch.Actions;

import dev.tesch.Items.Item;
import dev.tesch.NPCs.NPC;
import dev.tesch.Rooms.Room;

import java.util.Map;

public class RoomActions {

    /* Method to display which room you're in */
    public static void printLocation(Integer roomIndex, Map<Integer, Room> userRooms) {
        userRooms.get(roomIndex).getInMessage();
    }

    /* Method used to change rooms */
    public static int move(Map<Integer, Room> userRooms, Integer roomIndex, String choice) {
        String[] directions = {"N", "E", "S", "W"};
        String moveDirection = choice.toUpperCase();
        Room currentRoom = userRooms.get(roomIndex);
        int[] currentRoomMoves = currentRoom.getMoves();
        int[] connectedRooms = currentRoom.getConnectedRooms();

        // Checks which direction you want to move and if you can move there
        for (int i = 0; i < directions.length; i++) {
            // If you can move there, prints which room you're leaving and returns
            // the index to the new room you are entering
            if (moveDirection.equals(directions[i]) && currentRoomMoves[i] == 1) {
                System.out.println("\nYou went " + moveDirection + "\n");
                currentRoom.getLeaveMessage();
                userRooms.get(connectedRooms[i]).getEnterMessage();
                return connectedRooms[i];
            }
        }

        // If you can't move, tells you so, and returns the current room index
        System.out.println("\nCouldn't move that way.");
        return roomIndex;
    }

    /* Method used to look in the room you're in */
    public static void lookAround(Map<Integer, NPC> userNpcs, Map<Integer, Room> userRooms, Integer roomIndex, Map<Integer, Item> userItems) {
        Room room = userRooms.get(roomIndex);

        if (!room.isHasNPC()) {
            System.out.println("\nYou don't see any people.");
        } else {
            NPC npc = userNpcs.get(room.getNpcInRoom());
            System.out.println("\nYou see " + npc.getName());
        }

        if (!room.isHasItem())
            System.out.println("\nYou don't see any items.");
        else {
            Item item = userItems.get(room.getItemInRoom());
            System.out.println("\nYou see a " + item.getName());
        }
    }

}
