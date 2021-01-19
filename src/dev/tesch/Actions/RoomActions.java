package dev.tesch.Actions;

import dev.tesch.Furniture.Container;
import dev.tesch.Furniture.Furniture;
import dev.tesch.Items.Item;
import dev.tesch.NPCs.NPC;
import dev.tesch.Player.Player;
import dev.tesch.Player.UsedItemOnPlayer;
import dev.tesch.Rooms.Room;

import java.util.Map;

public class RoomActions {

    /* Method to display which room you're in */
    public static void printLocation(Player player, Map<Integer, Room> userRooms) {
        Room room = userRooms.get(player.getRoomIsIn());

        room.getInMessage();
        System.out.println(room.getMoves(room.getMoveIndices()));

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
    public static void lookAround(Player player, Map<Integer, NPC> userNpcs, Map<Integer, Room> userRooms, Map<Integer, Item> userItems, Map<Integer, Furniture> userFurnitures, Map<Integer, Container> userContainers) {
        Room room = userRooms.get(player.getRoomIsIn());

        room.getInMessage();

        if (!room.isHasNPC()) {
            System.out.println("\nYou don't see any people.");
        } else {
            NPC npc = userNpcs.get(room.getNpcInRoom());
            System.out.println("\nYou see " + npc.getName());
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
            if (room.getFurnitureInRoom().getClass() == Container.class) {
                Container container = userContainers.get(room.getFurnitureInRoomIndex());
                System.out.println("You see the " + container.getName());
            }
            else if (room.getFurnitureInRoom().getClass() == Furniture.class) {
                Furniture furniture = userFurnitures.get(room.getFurnitureInRoomIndex());
                System.out.println("You see the " + furniture.getName());
            }
        }
    }

    public static void useItemInRoom(Player player, Map<Integer, Room> userRooms, Map<Integer, Item> userItems) {
        Room room = userRooms.get(player.getRoomIsIn());
        Item item = userItems.get(room.getItemInRoom());

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
