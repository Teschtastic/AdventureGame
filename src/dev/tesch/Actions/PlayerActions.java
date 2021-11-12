package dev.tesch.Actions;

import dev.tesch.Items.Armor;
import dev.tesch.Items.Armors;
import dev.tesch.Items.Consumable;
import dev.tesch.Items.Consumables;
import dev.tesch.Items.Item;
import dev.tesch.Items.Items;
import dev.tesch.Items.Weapon;
import dev.tesch.Items.Weapons;
import dev.tesch.Player.Player;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Map.Entry;

public class PlayerActions {

    /* Method to display your inventory, so far no implementation */
    public static void inventory(Player player) {
        if (player.getInventory().isEmpty())
            System.out.println("\nYour inventory is empty.");
        else {
            System.out.println("\nYour inventory contains:");
            for (Item i : player.getInventory())
                System.out.println(" - " + i.getName());
        }
    }

    /* Method to print the help menu */
    public static void help(Map<Integer, List<String>> userActions) {
        System.out.println("\n/* ~ This is the help screen ~ */\nActions that you have access to:");
        for (Map.Entry<Integer, List<String>> entry: userActions.entrySet()) {
            System.out.println(" " + entry.getValue());
        }
    }

    /* Method used to describe the player character */
    public static void describePlayer(Player player) {
        System.out.println(player.toString());
    }

    /* Method used to use something, whether it's an item or furniture */
    public static void useSomething(Player player) {
        Scanner useIn = new Scanner(System.in);
        int useChoice = -1;

        System.out.print(
                "\nWhat would you like to use?\n" +
                        "\n1 - Item in inventory" +
                        "\n2 - Item in room" +
                        "\n3 - Furniture in room" +
                        "\n0 - Exit using\n");

        Actions.typeChoice();

        try {
            if (useIn.hasNextInt())
                useChoice = useIn.nextInt();
            else
                useIn.close();

            if (useChoice == 1)
                ItemActions.useInventoryItem(player);
            else if (useChoice == 2)
                RoomActions.useItemInRoom(player);
            else if (useChoice == 3)
                FurnitureActions.useFurniture(player);
            else if (useChoice == 0)
                System.out.println("\nYou decide to use nothing.");
            else
                System.out.println("\nInvalid choice.");
        } catch (InputMismatchException e) {
            System.out.println("\nInvalid input.");
        }
    }

    /* Method used to use something, whether it's an item or furniture */
    public static void describeSomething(Player player) {
        Scanner useIn = new Scanner(System.in);
        int describeChoice = -1;

        System.out.print(
                "\nWhat would you like to describe?\n" +
                "\n1 - Item" +
                "\n2 - Furniture in room" +
                "\n0 - Exit describing\n");
        Actions.typeChoice();

        try {
            if (useIn.hasNextInt())
                describeChoice = useIn.nextInt();
            else
                useIn.close();

            if (describeChoice == 1)
                ItemActions.describeItem(player);
            else if (describeChoice == 2)
                FurnitureActions.describeFurniture(player);
            else if (describeChoice == 0)
                System.out.println("\nYou decide to describe nothing.");
            else
                System.out.println("\nInvalid choice.");
        } catch (InputMismatchException e) {
            System.out.println("\nInvalid input.");
        }
    }

    /* Method used to access inventory and return an item from it */
    public static Item takeItemFromInventory(List<Item> inventory) {
        // Nothing in inventory to drop
        if (inventory.isEmpty())
            System.out.println("\nThere are no items available.");
        else if (inventory.size() == 1)
            return inventory.get(0);
        // Multiple items in inventory, choose which one to drop
        else {
            int i = 1;
            int size = inventory.size() - 1;
            Scanner itemDesc = new Scanner(System.in);
            int itemChoice = -1;

            System.out.println("\nYour available items are:");
            for (Item it : inventory)
                System.out.println(i++ + " - " + it.getName());
            System.out.println("0 - Nothing");
            Actions.typeChoice();

            try {
                if (itemDesc.hasNextInt())
                    itemChoice = itemDesc.nextInt();
                else
                    itemDesc.close();

                if (itemChoice > 0 && itemChoice <= size)
                    return inventory.get(itemChoice - 1);
                else if (itemChoice == 0) {
                    System.out.println("\nYou choose nothing.");
                } else
                    System.out.println("\nInvalid choice.");
            }
            catch (InputMismatchException e) {
                System.out.println("\n Invalid input.");
            }
        }
        return null;
    }

    public static void saveGame(Player player) {

        final String saveFilePath = "src/dev/tesch/save/player/playerStats.txt";
        final String inventoryFilePath = "src/dev/tesch/save/player/playerInventory.txt";
        
        Map<Integer, Item> items = new Items().itemsMap;
        Map<Integer, Armor> armors = new Armors().armorMap;
        Map<Integer, Weapon> weapons = new Weapons().weaponMap;
        Map<Integer, Consumable> consumables = new Consumables().consumablesMap;

        try {
            FileWriter playerWriter = new FileWriter(saveFilePath);
            FileWriter inventoryWriter = new FileWriter(inventoryFilePath);

            playerWriter.write("Current Health:" + player.getCurrentHealth() + "\n");
            playerWriter.write("Maximum Health:" + player.getMaximumHealth() + "\n");
            playerWriter.write("Current Weight:" + player.getCurrentCarryWeight() + "\n");
            playerWriter.write("Maximum Weight:" + player.getMaximumCarryWeight() + "\n");
            playerWriter.write("Armor Class:" + player.getArmorClass() + "\n");
            playerWriter.write("Attack Damage:" + player.getAttackDamage() + "\n");
            playerWriter.write("Equipped Armor:" + player.getArmorIndex() + "\n");
            playerWriter.write("Equipped Weapon:" + player.getWeaponIndex() + "\n");
            playerWriter.write("Current Room:" + player.getRoomIndex() + "\n");

            playerWriter.close();

            for (Item item : player.getInventory()) {
                if (item.getClass() == Armor.class) {
                    for (Entry<Integer, Armor> entry : armors.entrySet()) {
                        if (Objects.equals(item, entry.getValue())) {
                            inventoryWriter.write("Armor:" + entry.getKey() + "\n");
                        }
                    }
                } else if (item.getClass() == Weapon.class) {
                    for (Entry<Integer, Weapon> entry : weapons.entrySet()) {
                        if (Objects.equals(item, entry.getValue())) {
                            inventoryWriter.write("Weapon:" + entry.getKey() + "\n");
                        }
                    }
                } else if (item.getClass() == Consumable.class) {
                    for (Entry<Integer, Consumable> entry : consumables.entrySet()) {
                        if (Objects.equals(item, entry.getValue())) {
                            inventoryWriter.write("Consumable:" + entry.getKey() + "\n");
                        }
                    }
                } else {
                    for (Entry<Integer, Item> entry : items.entrySet()) {
                        if (Objects.equals(item, entry.getValue())) {
                            inventoryWriter.write("Item:" + entry.getKey() + "\n");
                        }
                    }
                }
            }

            inventoryWriter.close();

            System.out.println("\n*    You have saved your progress    *");

        } catch (IOException e) {
            System.out.println("An error occurred while writing to save file.");
            e.printStackTrace();
        }
    }
}
