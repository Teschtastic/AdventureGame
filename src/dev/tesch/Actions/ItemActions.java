package dev.tesch.Actions;

import dev.tesch.Items.Item;
import dev.tesch.NPCs.NPC;
import dev.tesch.Player.Player;
import dev.tesch.Rooms.Room;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ItemActions {

    /* Method used for attempting to pickup an item */
    public static void pickupItem(Map<Integer, Room> userRooms, Integer roomIndex, Map<Integer, Item> userItems, Player player) {
        Room room = userRooms.get(roomIndex);

        // If there isn't an item in the room, nothing to pickup
        if (!room.isHasItem())
            System.out.println("\nThere is no item to pickup.");
            // This means there is something in the room
        else {
            Item item = userItems.get(room.getItemInRoom());
            // The item is able to be picked up, so remove it from the room and remove the room tag for the item
            // then add the item to the players inventory
            if (item.getCanPickup()) {
                System.out.println("\nYou pickup the " + item.getName());
                room.setItemInRoom(-1);
                room.setHasItem(false);
                item.setRoomLocation(-1);
                player.addToInventory(item);
            }
            // Otherwise, the item isn't able to be picked up
            else
                System.out.println("\nYou can't pickup the " + item.getName());
        }
    }

    /* Method used to describe an item in your inventory */
    // TODO: Add functionality to describe items that you can't pickup and
    //  therefore aren't in the player's inventory
    public static void describeItem(List<Item> inventory) {
        if (inventory.size() == 0)
            System.out.println("\nThere is nothing in your inventory to describe.");
        else if (inventory.size() == 1)
            System.out.println("\nYou inspect your " + inventory.get(0).getName() +
                    "\nYou describe it as:\n" + inventory.get(0).getDescription());
        else {
            int i = 0;
            int size = inventory.size() - 1;
            Scanner itemDesc = new Scanner(System.in);
            int itemChoice;

            System.out.println("\nYour inventory contains:");
            for (Item it : inventory)
                System.out.println(i++ + " " + it.getName());

            System.out.print("\nWhich item would you like to inspect?\n(0 - " + size + ")\n>");
            itemChoice = itemDesc.nextInt();

            if (itemChoice >= 0 && itemChoice <= size)
                System.out.println("\nYou inspect your " + inventory.get(itemChoice).getName() +
                        "\nYou describe it as:\n" + inventory.get(itemChoice).getDescription());
            else
                System.out.println("\nInvalid item, try again.");
        }
    }

    /* Method used to drop and item in your inventory */
    public static void dropItem(Map<Integer, Room> userRooms, Integer roomIndex, Player player) {

        Room room = userRooms.get(roomIndex);
        Item item;

        // Nothing in inventory to drop
        if (player.getInventory().size() == 0)
            System.out.println("\nThere is nothing in your inventory to drop.");
            // Only one item in your inventory to drop
        else if (room.isHasItem() && player.getInventory().size() > 0)
            System.out.println("\nYou cannot drop the item.\nThe room already has an item in it.");
        else if (player.getInventory().size() == 1) {
            item = player.getInventory().get(0);

            System.out.println("\nYou drop your " + item.getName());

            room.setHasItem(true);
            item.setRoomLocation(roomIndex);
            room.setItemInRoom(item.getItemIndex());
            player.getInventory().remove(0);
        }
        // Multiple items in inventory, choose which one to drop
        else {
            int i = 0;
            int size = player.getInventory().size() - 1;
            Scanner itemDesc = new Scanner(System.in);
            int itemChoice;

            System.out.println("\nYour inventory contains:");
            for (Item it : player.getInventory())
                System.out.println(i++ + " " + it.getName());

            System.out.print("\nWhich item would you like to drop?\n(0 - " + size + ")\n>");
            itemChoice = itemDesc.nextInt();

            if (itemChoice >= 0 && itemChoice <= size) {
                item = player.getInventory().get(itemChoice);
                System.out.println("\nYou drop your " + item.getName());
                room.setHasItem(true);
                item.setRoomLocation(roomIndex);
                room.setItemInRoom(item.getItemIndex());
                player.getInventory().remove(itemChoice);
            }
            else
                System.out.println("\nInvalid item, try again.");
        }
    }

    public static void useItem(Map<Integer, Room> userRooms, Integer roomIndex, Player player) {
        Room room = userRooms.get(roomIndex);
        Item item;

        // Nothing in inventory to use
        if (player.getInventory().size() == 0)
            System.out.println("\nThere is nothing in your inventory to use.");
            // Only one item in your inventory to use
        else if (player.getInventory().size() == 1) {
            item = player.getInventory().get(0);

            // If the item has the can use flag, use it and remove
            // it from the player's inventory
            if (player.getInventory().get(0).isCanUse()) {
                System.out.println(item.getUseMessage());
                player.getInventory().remove(0);
            }
            else
                System.out.println("\nYou can't use " + item.getName());
        }
        // Multiple items in inventory, choose which one to use
        else {
            int i = 0;
            int size = player.getInventory().size() - 1;
            Scanner itemDesc = new Scanner(System.in);
            int itemChoice;

            // Prints the inventory for the user
            System.out.println("\nYour inventory contains:");
            for (Item it : player.getInventory())
                System.out.println(i++ + " " + it.getName());

            // Choice as to which item to use
            System.out.print("\nWhich item would you like to use?\n(0 - " + size + ")\n>");
            itemChoice = itemDesc.nextInt();


            if (itemChoice >= 0 && itemChoice <= size) {
                item = player.getInventory().get(itemChoice);

                if (player.getInventory().get(itemChoice).isCanUse()) {

                    System.out.println(item.getUseMessage());

                    player.getInventory().remove(itemChoice);
                }
                else
                    System.out.println("\nYou can't use " + item.getName());
            }
            else
                System.out.println("\nInvalid item, try again.");
        }
    }

    public static void giveItem(Map<Integer, Room> userRooms, Map<Integer, NPC> userNPCs, Integer roomIndex, Player player) {
        Room room = userRooms.get(roomIndex);
        NPC npc = userNPCs.get(room.getNpcInRoom());
        Item item;

        // Nothing in inventory to give
        if (player.getInventory().size() == 0)
            System.out.println("\nThere is nothing in your inventory to give.");
            // Only one item in your inventory to give
        else if (player.getInventory().size() == 1) {
            item = player.getInventory().get(0);

            if (npc.isHasItem()) {
                System.out.println("\n" + npc.getName() + " already has an item." +
                        "\nCannot give them the " +item.getName());
            } else {
                // Removes item from your inventory and adds to the NPCs
                player.getInventory().remove(0);
                npc.setHasItem(true);
                npc.setItemInInventory(item.getItemIndex());
                System.out.println("\nYou gave " + npc.getName() + " your " + item.getName());
            }
        }
        // Multiple items in inventory, choose which one to use
        else {
            int i = 0;
            int size = player.getInventory().size() - 1;
            Scanner itemDesc = new Scanner(System.in);
            int itemChoice;

            // Prints the inventory for the user
            System.out.println("\nYour inventory contains:");
            for (Item it : player.getInventory())
                System.out.println(i++ + " " + it.getName());

            // Choice as to which item to use
            System.out.print("\nWhich item would you like to give?\n(0 - " + size + ")\n>");
            itemChoice = itemDesc.nextInt();

            if (itemChoice >= 0 && itemChoice <= size) {
                item = player.getInventory().get(itemChoice);

                if (npc.isHasItem())
                    System.out.println("\n" + npc.getName() + " already has an item." +
                                        "\nCannot give them the " +item.getName());
                else {
                    player.getInventory().remove(itemChoice);
                    npc.setHasItem(true);
                    npc.setItemInInventory(item.getItemIndex());
                    System.out.println("\nYou gave " + npc.getName() + " your " + item.getName());
                }
            }
            else
                System.out.println("\nInvalid item, try again.");
        }
    }

    public static void takeItem(Map<Integer, Room> userRooms, Map<Integer, NPC> userNPCs, Map<Integer, Item> userItems,Integer roomIndex, Player player) {
        Room room = userRooms.get(roomIndex);
        NPC npc = userNPCs.get(room.getNpcInRoom());
        Item item;

        // If there isn't an item in the NPCs inventory, nothing to take
        if (!npc.isHasItem())
            System.out.println("\n" + npc.getName() + " doesn't have an item.");
        else {
            item = userItems.get(npc.getItemInInventory());
            // The item is able to be taken, so remove it from the NPCs inventory and add it tyo yours

            npc.setHasItem(false);
            npc.setItemInInventory(-1);
            player.addToInventory(item);
            System.out.println("\nYou take the " + item.getName() +
                                "\nfrom " + npc.getName());
        }
    }
}
