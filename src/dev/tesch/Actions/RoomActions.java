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
        System.out.println(room.getMoves());
    }

    /* Method used to change rooms */
    public static void move(Player player) {
        String moveDirection = player.getChoice().toUpperCase();
        Room currentRoom = player.getRoomIsIn();

        for (Map.Entry<String, Room> entry : currentRoom.getConnRooms().entrySet())
            if (entry.getKey().equals(moveDirection)) {
                System.out.println("\nYou went " + entry.getKey() + "\n");
                currentRoom.getLeaveMessage();
                entry.getValue().getEnterMessage();
                player.setRoomIsIn(entry.getValue());
                return;
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
