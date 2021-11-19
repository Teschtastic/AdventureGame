package dev.tesch.Actions;

import dev.tesch.Items.Armor;
import dev.tesch.Items.Item;
import dev.tesch.Items.Weapon;
import dev.tesch.Player.EquipItemToPlayer;
import dev.tesch.Player.Player;
import dev.tesch.Player.UnEquipItemFromPlayer;
import dev.tesch.Player.UsedItemOnPlayer;
import dev.tesch.Rooms.Room;
import dev.tesch.Rooms.Rooms;

import java.util.*;

public class ItemActions {

    /* Method used for attempting to pick up an item */
    public static void pickupItem(Player player, Map<Integer, Room> rooms) {
        Room room = rooms.get(player.getRoomIndex());

        // If there isn't an item in the room, nothing to pickup
        if (!room.isHasItem())
            System.out.println("\nThere is no item to pickup.");
            // This means there is something in the room
        else {
            Item item = room.getItemInRoom();
            // The item can be picked up, so remove it from the room and remove the room tag for the item
            // then add the item to the players inventory
            if ((player.getCurrentCarryWeight() + item.getItemWeight()) > player.getMaximumCarryWeight())
                System.out.println("\nYour inventory is too full to pickup\nthe " + item.getName());
            else if (item.getCanPickup()) {
                System.out.println("\nYou pickup the " + item.getName());
                room.setHasItem(false);
                room.setItemInRoom(null);
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

        Item itemInRoom = player.getRoomIsIn().getItemInRoom();

        if (!inventory.isEmpty()) {
            itemsToDescribe.addAll(inventory);
        }
        if (itemInRoom != null){
            itemsToDescribe.add(itemInRoom);
        }

        if (itemsToDescribe.isEmpty())
            System.out.println("\nThere are no items to describe.");
        else {
            Item item = PlayerActions.takeItemFromInventory(itemsToDescribe);
            assert item != null;
            System.out.println(
                    "\nYou inspect the " + item.getName() +
                            "\n\nYou describe it as:\n" + item.getDescription() +
                            "\n\nWith a weight of: " + item.getItemWeight());
        }

    }

    /* Method used to drop and item in your inventory */
    public static void dropItem(Player player, Map<Integer, Room> rooms) {
        Room room = rooms.get(player.getRoomIndex());
        Item item = PlayerActions.takeItemFromInventory(player.getInventory());

        assert item != null;
        System.out.println("\nYou drop your " + item.getName());

        room.setHasItem(true);
        room.setItemInRoom(item);
        player.removeFromInventory(item);
    }

    /* Method used to use an item in either your inventory or in the world */
    public static void useInventoryItem(Player player) {
        Item item = PlayerActions.takeItemFromInventory(player.getInventory());

        // If the item has the can use flag, use it and remove
        // it from the player's inventory
        if (item != null && item.isCanUse()) {
            System.out.println(item.getUseMessage());
            UsedItemOnPlayer.useItem(player, item);
        } else
            System.out.println("\nYou can't use " + item.getName());
    }

    public static void equipItem(Player player) {
        List<Item> playerInventory = player.getInventory();
        List<Item> weaponArmorInventory = new ArrayList<>();
        Item item;

        for (Item i: playerInventory) {
            if (i.getClass() == Armor.class || i.getClass() == Weapon.class) {
                weaponArmorInventory.add(i);
            }
        }

        if (playerInventory.isEmpty()) {
            System.out.println("\nYour inventory is empty.");
        } else if (weaponArmorInventory.isEmpty()) {
            System.out.println("\nYou have no weapons or armor.");
        } else {
            try {
                Scanner equipChoose = new Scanner(System.in);
                int equipChoice = -1;

                System.out.println("\nWhat would you like to equip?");
                System.out.println("\n1 - Armor\n2 - Weapon\n0 - Nothing");
                Actions.typeChoice();
                if (equipChoose.hasNextInt())
                    equipChoice = equipChoose.nextInt();
                else
                    equipChoose.close();

                item = PlayerActions.takeItemFromInventory(weaponArmorInventory);

                if (item != null) {
                    if (equipChoice == 1 && player.isHasEquippedArmor()) {
                        System.out.println("\nYou already have equipped armor.");
                    } else if (item.getClass() == Armor.class && equipChoice == 1 && !player.isHasEquippedArmor()) {
                        EquipItemToPlayer.equipArmor(player, (Armor) item);
                    } else if (equipChoice == 2 && player.isHasEquippedWeapon()) {
                        System.out.println("\nYou already have an equipped weapon.");
                    } else if (item.getClass() == Weapon.class && equipChoice == 2 && !player.isHasEquippedWeapon()) {
                        EquipItemToPlayer.equipWeapon(player, (Weapon) item);
                    }  else
                        System.out.println("\nInvalid choice.");
                } else if (item == null && equipChoice == 0) {
                    System.out.println("\nYou equip nothing.");
                }
            }
            catch (IllegalStateException e) {
                System.out.println("\n Invalid input.");
            }
        }
    }

    public static void unEquipItem(Player player) {
        if (!player.isHasEquippedArmor() && !player.isHasEquippedWeapon()) {
            System.out.println("\nYou don't have anything equipped.");
        } else {
            try {
                Scanner unequipChoose = new Scanner(System.in);
                int unequipChoice = -1;

                System.out.println("\nWhat would you like to un equip?");
                System.out.println("\n1 - Armor\n2 - Weapon\n0 - Nothing");
                Actions.typeChoice();

                if (unequipChoose.hasNextInt())
                    unequipChoice = unequipChoose.nextInt();
                else
                    unequipChoose.close();

                if (unequipChoice == 1 && player.isHasEquippedArmor()) {
                    Armor armor = player.getEquippedArmor();
                    UnEquipItemFromPlayer.unEquipArmor(player, armor);
                } else if (unequipChoice == 1 && !player.isHasEquippedArmor()){
                    System.out.println("\nYou don't have equipped armor.");
                } else if (unequipChoice == 2 && player.isHasEquippedWeapon()) {
                    Weapon weapon = player.getEquippedWeapon();
                    UnEquipItemFromPlayer.unEquipWeapon(player, weapon);
                } else if (unequipChoice == 2 && !player.isHasEquippedWeapon()) {
                    System.out.println("\nYou don't have an equipped weapon.");
                } else if (unequipChoice == 0) {
                    System.out.println("\nYou un-equip nothing.");
                } else
                    System.out.println("\nInvalid choice.");
            }
            catch (IllegalStateException e) {
                System.out.println("\n Invalid input.");
            }
        }
    }
}
