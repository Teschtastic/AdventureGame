package dev.tesch.Actions;

import dev.tesch.Items.Armor;
import dev.tesch.Items.Item;
import dev.tesch.Items.Weapon;
import dev.tesch.Player.EquipItemToPlayer;
import dev.tesch.Player.Player;
import dev.tesch.Player.UnEquipItemFromPlayer;
import dev.tesch.Player.UsedItemOnPlayer;
import dev.tesch.Rooms.Room;

import java.util.*;

public class ItemActions {

    /* Method used for attempting to pickup an item */
    public static void pickupItem(Player player) {
        Room room = player.getRoomIsIn();

        // If there isn't an item in the room, nothing to pickup
        if (!room.isHasItem())
            System.out.println("\nThere is no item to pickup.");
            // This means there is something in the room
        else {
            Item item = room.getItemInRoom();
            // The item is able to be picked up, so remove it from the room and remove the room tag for the item
            // then add the item to the players inventory
            if (item.getCanPickup()) {
                System.out.println("\nYou pickup the " + item.getName());
                room.setItemInRoomIndex(-1);
                room.setHasItem(false);
                player.addToInventory(item);
            }
            // Otherwise, the item isn't able to be picked up
            else
                System.out.println("\nYou can't pickup the " + item.getName());
        }
    }

    /* Method used to describe an item in your inventory */
    public static void describeItem(Player player) {
        List<Item> itemsToDescribe = new ArrayList<>();
        List<Item> inventory = player.getInventory();

        Room room = player.getRoomIsIn();
        Item item = room.getItemInRoom();

        if (!inventory.isEmpty()) {
            itemsToDescribe.addAll(inventory);
        }
        if (item != null){
            itemsToDescribe.add(item);
        }

        if (itemsToDescribe.isEmpty())
            System.out.println("\nThere are no items to describe.");
        else if (itemsToDescribe.size() == 1)
            System.out.println("\nYou inspect the " + itemsToDescribe.get(0).getName() +
                    "\n\nYou describe it as:\n" + itemsToDescribe.get(0).getDescription());
        else {
            int i = 0;
            int size = itemsToDescribe.size() - 1;
            Scanner itemDesc = new Scanner(System.in);
            int itemChoice = -1;

            System.out.println("\nYou have multiple items available to you:");

            for (Item it : itemsToDescribe)
                System.out.println(i++ + " " + it.getName());

            Actions.typeChoice();

            try {
                if (itemDesc.hasNextInt())
                    itemChoice = itemDesc.nextInt();
                else
                    itemDesc.close();

                if (itemChoice >= 0 && itemChoice <= size)
                    System.out.println("\nYou inspect the " + itemsToDescribe.get(itemChoice).getName() +
                            "\n\nYou describe it as:\n" + itemsToDescribe.get(itemChoice).getDescription());
                else
                    System.out.println("\nInvalid choice.");
            }
            catch (InputMismatchException e) {
                System.out.println("\nInvalid input.");
            }
        }
    }

    /* Method used to drop and item in your inventory */
    public static void dropItem(Player player) {
        List<Item> inventory = player.getInventory();
        Room room = player.getRoomIsIn();
        Item item;

        // Nothing in inventory to drop
        if (inventory.isEmpty())
            System.out.println("\nThere is nothing in your inventory to drop.");
            // If there is an item in the room already
        else if (room.isHasItem() && inventory.size() > 0)
            System.out.println("\nYou cannot drop the item.\nThe room already has an item in it.");
            // Only one item in your inventory to drop
        else if (inventory.size() == 1) {
            item = inventory.get(0);

            System.out.println("\nYou drop your " + item.getName());

            room.setHasItem(true);
            room.setItemInRoomIndex(item.getItemIndex());
            room.setItemInRoom(item);
            inventory.remove(0);
        }
        // Multiple items in inventory, choose which one to drop
        else {
            int i = 0;
            int size = inventory.size() - 1;
            Scanner itemDesc = new Scanner(System.in);
            int itemChoice = -1;

            System.out.println("\nYour inventory contains:");
            for (Item it : inventory)
                System.out.println(i++ + " " + it.getName());

            Actions.typeChoice();

            try {
                if (itemDesc.hasNextInt())
                    itemChoice = itemDesc.nextInt();
                else
                    itemDesc.close();

                if (itemChoice >= 0 && itemChoice <= size) {
                    item = inventory.get(itemChoice);
                    System.out.println("\nYou drop your " + item.getName());
                    room.setHasItem(true);
                    room.setItemInRoomIndex(item.getItemIndex());
                    room.setItemInRoom(item);
                    inventory.remove(itemChoice);
                } else
                    System.out.println("\nInvalid choice.");
            }
            catch (InputMismatchException e) {
                System.out.println("\n Invalid input.");
            }
        }
    }

    /* Method used to use an item in either your inventory or in the world */
    public static void useInventoryItem(Player player) {
        Item item;
        List<Item> inventory = player.getInventory();

        // Only one item in your inventory to use
        if (inventory.size() == 1) {
            item = player.getInventory().get(0);

            // If the item has the can use flag, use it and remove
            // it from the player's inventory
            if (player.getInventory().get(0).isCanUse()) {
                System.out.println(item.getUseMessage());
                UsedItemOnPlayer.useItem(player, item);
            }
            else
                System.out.println("\nYou can't use " + item.getName());
        }
        // Multiple items in inventory, choose which one to use
        else if (inventory.size() > 1) {
            int i = 0;
            int size = inventory.size() - 1;
            Scanner itemDesc = new Scanner(System.in);
            int itemChoice = -1;

            // Prints the inventory for the user
            System.out.println("\nYou have multiple items\nin your inventory to use.\n\nYour inventory contains:");
            for (Item it : inventory)
                System.out.println(i++ + " - " + it.getName());

            Actions.typeChoice();

            try {
                if (itemDesc.hasNextInt())
                    itemChoice = itemDesc.nextInt();
                else
                    itemDesc.close();

                if (itemChoice >= 0 && itemChoice <= size) {
                    item = inventory.get(itemChoice);

                    if (inventory.get(itemChoice).isCanUse()) {
                        System.out.println(item.getUseMessage());
                        UsedItemOnPlayer.useItem(player, item);
                    } else
                        System.out.println("\nYou can't use " + item.getName());
                } else
                    System.out.println("\nInvalid item.");

            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input.");
            }
        }
        else
            System.out.println("\nYour inventory is empty.");
    }

    public static void equipItem(Player player) {
        Item item;
        List<Item> inventory = player.getInventory();

        try {

            // Only one item in your inventory to use
            if (inventory.size() == 1) {
                item = player.getInventory().get(0);

                // If the item is a weapon or armor class, use it and remove
                // it from the player's inventory
                if (item.getClass() == Armor.class) {
                    EquipItemToPlayer.equipArmor(player, (Armor) item);
                }
                else if (item.getClass() == Weapon.class) {
                    EquipItemToPlayer.equipWeapon(player, (Weapon) item);
                }
                else
                    System.out.println("\nYou can't equip " + item.getName());
            }
            // Multiple items in inventory, choose which one to use
            else if (inventory.size() > 1) {
                int i = 0;
                int size = inventory.size() - 1;
                Scanner itemDesc = new Scanner(System.in);
                int itemChoice = -1;

                // Prints the inventory for the user
                System.out.println("\nYou have multiple items\nin your inventory to equip.\n\nYour inventory contains:");
                for (Item it : inventory)
                    System.out.println(i++ + " - " + it.getName());

                Actions.typeChoice();

                try {
                    if (itemDesc.hasNextInt())
                        itemChoice = itemDesc.nextInt();
                    else
                        itemDesc.close();

                    if (itemChoice >= 0 && itemChoice <= size) {
                        item = inventory.get(itemChoice);

                        if (item.getClass() == Armor.class) {
                            EquipItemToPlayer.equipArmor(player, (Armor) item);
                        } else if (item.getClass() == Weapon.class) {
                            EquipItemToPlayer.equipWeapon(player, (Weapon) item);
                        } else
                            System.out.println("\nYou can't equip " + item.getName());
                    } else
                        System.out.println("\nInvalid item.");

                } catch (InputMismatchException e) {
                    System.out.println("\nInvalid input.");
                }
            }
            else
                System.out.println("\nYour inventory is empty.");

        } catch (InputMismatchException e) {
            System.out.println("\nInvalid input.");
        }
    }

    public static void unEquipItem(Player player) {
        if (!player.isHasEquippedArmor() && !player.isHasEquippedWeapon()) {
            System.out.println("\nYou don't have anything equipped.");
        } else {
            Scanner unequipChoose = new Scanner(System.in);
            int unequipChoice = -1;
            System.out.println("\nWhat would you like to un equip?");
            System.out.println("\n0 - Armor\n1 - Weapon");
            Actions.typeChoice();

            if (unequipChoose.hasNextInt())
                unequipChoice = unequipChoose.nextInt();
            else
                unequipChoose.close();

            if (unequipChoice == 0 && player.isHasEquippedArmor()) {
                Armor armor = player.getEquippedArmor();
                UnEquipItemFromPlayer.unEquipArmor(player, armor);
            } else if (unequipChoice == 0 && !player.isHasEquippedArmor()){
                System.out.println("\nYou don't have equipped armor.");
            } else if (unequipChoice == 1 && player.isHasEquippedWeapon()) {
                Weapon weapon = player.getEquippedWeapon();
                UnEquipItemFromPlayer.unEquipWeapon(player, weapon);
            } else {
                System.out.println("\nYou don't have an equipped weapon.");
            }
        }
    }
}
