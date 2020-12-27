package dev.tesch.Actions;

import dev.tesch.Items.Item;
import dev.tesch.NPCs.NPC;
import dev.tesch.Player.Player;
import dev.tesch.Rooms.Room;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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

    /* Method used to give an item in your inventory to an NPC */
    public static void giveItem(Player player, Map<Integer, Room> userRooms, Map<Integer, NPC> userNPCs) {
        List<Item> inventory = player.getInventory();
        Room room = userRooms.get(player.getRoomIsIn());
        NPC npc = userNPCs.get(room.getNpcInRoom());
        Item item;

        // Nothing in inventory to give
        if (inventory.isEmpty())
            System.out.println("\nThere is nothing in your inventory to give.");
            // Only one item in your inventory to give
        else if (inventory.size() == 1) {
            item = inventory.get(0);

            if (npc.isHasItem()) {
                System.out.println("\n" + npc.getName() + " already has an item." +
                        "\nCannot give them the " +item.getName());
            } else {
                // Removes item from your inventory and adds to the NPCs
                inventory.remove(0);
                npc.setHasItem(true);
                npc.setItemInInventory(item.getItemIndex());
                System.out.println("\nYou gave " + npc.getName() + " your " + item.getName());
            }
        }
        // Multiple items in inventory, choose which one to use
        else {
            int i = 0;
            int size = inventory.size() - 1;
            Scanner itemDesc = new Scanner(System.in);
            int itemChoice = -1;

            // Prints the inventory for the user
            System.out.println("\nYour inventory contains:");
            for (Item it : inventory)
                System.out.println(i++ + " " + it.getName());

            System.out.print("\n--------------------------------------\nType your choice:\n> ");

            try {
                if (itemDesc.hasNextInt())
                    itemChoice = itemDesc.nextInt();
                else
                    itemDesc.close();

                if (itemChoice >= 0 && itemChoice <= size) {
                    item = inventory.get(itemChoice);

                    if (npc.isHasItem())
                        System.out.println("\n" + npc.getName() + " already has an item." +
                                "\nCannot give them the " + item.getName());
                    else {
                        inventory.remove(itemChoice);
                        npc.setHasItem(true);
                        npc.setItemInInventory(item.getItemIndex());
                        System.out.println("\nYou gave " + npc.getName() + " your " + item.getName());
                    }
                } else
                    System.out.println("\nInvalid choice.");
            }
            catch (InputMismatchException e) {
                System.out.println("\nInvalid input.");
            }
        }
    }

    /* Method use to take an item from an NPC */
    public static void takeItem(Player player, Map<Integer, Room> userRooms, Map<Integer, NPC> userNPCs, Map<Integer, Item> userItems) {
        Room room = userRooms.get(player.getRoomIsIn());
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
