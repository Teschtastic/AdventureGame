package dev.tesch.Player;

import dev.tesch.Actions.Actions;
import dev.tesch.Actions.PlayerActions;
import dev.tesch.Crafting.Recipe;
import dev.tesch.Furniture.Container;
import dev.tesch.Furniture.Furniture;
import dev.tesch.Items.Item;
import dev.tesch.NPCs.NPC;
import dev.tesch.Rooms.Room;

import java.util.*;

public class UsedFurnitureOnPlayer {

    // Use furniture method with a switch case for the different furnitures with uses
    public static void useFurniture(Player player) {
        Furniture furniture = player.getRoomIsIn().getFurnitureInRoom();
        switch (furniture.getName()) {
            case "Camping chair":
                usedCampingChair(player);
                break;

            case "Sean's Bed":

            case "Jeff's Bed":
                usedBed(player);
                break;

            case "Crafting Table":
                useCraftingTable(player);
                break;

            case "Chest":

            case "Refrigerator":
                useContainer(player, (Container) furniture);
                break;

            default:
                System.out.println("\nThis doesn't seem to help you");
        }
    }

    // Method for using the camping chair
    private static void usedCampingChair(Player player) {
        // Heals the player
        System.out.println("\nYour health has been restored.");
        player.setCurrentHealth(player.getMaximumHealth());
    }

    // Method for using Sean's bed
    private static void usedBed(Player player) {
        NPC npc;
        Room room = player.getRoomIsIn();

        if (room.isHasNPC()) {
            npc = room.getNpcInRoom();

            // If Claudia is in the room, heals and increases health
            if (npc.getName().equals("Claudia")) {
                System.out.println(
                                "\nYou and Claudia snuggle <3" +
                                "\nYour max health increases by 50" +
                                "\nand your health has been restored.");
                player.setMaximumHealth(player.getMaximumHealth() + 50);
                player.setCurrentHealth(player.getMaximumHealth());
            }
            // If jeff is in the room he deals damage to the player
            else if (npc.getName().equals("Jeff")) {
                System.out.println(
                        "\nJeff bites your face in your sleep." +
                                "\nYou lose 25 health.");
                player.setCurrentHealth(player.getCurrentHealth() - 25);
            }
        }
        // Or else only increases health
        else {
            System.out.println("\nYour max health increases by 25");
            player.setMaximumHealth(player.getMaximumHealth() + 25);
        }
    }

    // Method for using the crafting table
    private static void useCraftingTable(Player player) {
        Item craftedItem;
        List<Item> inventory = player.getInventory();
        List<Recipe> recipes = player.getKnownRecipes();

        // Checks if the player has an empty inventory and has recipes to craft
        if (!inventory.isEmpty() && !recipes.isEmpty()) {

            Scanner craftChoice = new Scanner(System.in);
            int craftIndex = -1;
            int i = 1;

            // Prints available recipes to craft or to exit
            System.out.println("\nWhat would you like to craft?\n");
            for (Recipe r: recipes) {
                System.out.println(i++ + " - " + r.getOutputItem().getName());
            }
            System.out.println("0 - Exit crafting");
            Actions.typeChoice();

            if (craftChoice.hasNextInt())
                craftIndex = craftChoice.nextInt();
            else
                craftChoice.close();

            if (craftIndex == 0)
                System.out.println("\nYou exit crafting");
            else {
                Recipe recipe = recipes.get(craftIndex - 1);
                // Checks if the players inventory contains the necessary items
                // to craft the chosen recipe, then crafts
                if (recipe.canCraft(inventory)) {

                    List<Item> craftingItems = new LinkedList<>(recipe.getInputItems());
                    craftedItem = recipe.getOutputItem();

                    for (Item it : craftingItems) {
                        System.out.println(it.getUseMessage());
                    }

                    player.removeFromInventory(craftingItems);
                    player.addToInventory(craftedItem);
                    craftingItems.removeAll(recipe.getInputItems());
                } else
                    System.out.println("\nYou don't have the required materials.");
            }
        }
        else {
            System.out.println("\nYou have nothing to craft with.");
        }
    }

    // Method for using a container
    private static void useContainer(Player player, Container container) {

        // Prints an options menu
        System.out.println("\nHow do you want to use the " + container.getName() + "?");
        System.out.println(
                        "\n1 - View " + container.getName() + "'s inventory" +
                        "\n2 - Take item from" +
                        "\n3 - Put item into" +
                        "\n0 - Exit furniture");
        
        List<Item> containerInventory = container.getContainerInventory();
        Scanner containerChoice = new Scanner(System.in);
        int containerIndex = -1;

        Actions.typeChoice();

        if (containerChoice.hasNextInt())
            containerIndex = containerChoice.nextInt();
        else
            containerChoice.close();

        // This either shows the container's inventory or that it is empty
        if (containerIndex == 1) {
            if (containerInventory.isEmpty())
                System.out.println("\nThe " + container.getName() + " is empty.");
            else {
                System.out.println("\nInside the " + container.getName() + " you see:\n");
                for (Item it : containerInventory) {
                    System.out.println("- " + it.getName());
                }
            }
        }
        // Used for taking item(s) from inventory
        else if (containerIndex == 2) {
            System.out.println("\nWhat would you like to take: \n");
            Scanner take = new Scanner(System.in);
            int i = 1;
            int itemIndex = -1;
            int totalWeight = 0;
            Item item;

            // Choice for which item to take: one, all, or none
            for (Item it: containerInventory) {
                System.out.println(i++ + " - " + it.getName());
            }
            System.out.println("0 - Take all\n-1 - Take nothing");
            Actions.typeChoice();

            try {
                if (take.hasNext())
                    itemIndex = take.nextInt();
                else
                    take.close();

                // Takes all the items from the container
                if (itemIndex == 0) {
                    for (Item it: containerInventory) {
                        totalWeight += it.getItemWeight();
                    }
                    if ((player.getCurrentCarryWeight() + totalWeight) < player.getMaximumCarryWeight()) {
                        System.out.println("\nYou take all of the items");
                        player.addToInventory(containerInventory);
                        container.removeFromInventory(containerInventory);
                    }
                    else
                        System.out.println("\nYour inventory is too full to take\nthe items from the " + container.getName());
                }
                // Take nothing
                else if (itemIndex == -1)
                    System.out.println("\nYou decided to take nothing");
                // Takes the item the player chose from the inventory
                else {
                    item = containerInventory.get(itemIndex - 1);
                    if ((player.getCurrentCarryWeight() + item.getItemWeight()) < player.getMaximumCarryWeight()) {
                        totalWeight = player.getCurrentCarryWeight() + item.getItemWeight();

                        System.out.println("\nYou take the " + item.getName());
                        player.addToInventory(item);
                        container.removeFromInventory(item);
                        player.setCurrentCarryWeight(totalWeight);
                    }
                    else
                        System.out.println("\nYour inventory is too full to take\nthe " + item.getName());
                }
            }
            catch (InputMismatchException e) {
                System.out.println("\nInvalid input.");
            }
        }
        // Puts an item from the inventory into the container
        else if (containerIndex == 3) {
            Scanner place = new Scanner(System.in);
            int itemIndex = -1;
            Item item;
            List<Item> playerInventory = player.getInventory();

            System.out.println("\nWhat would you like to place: \n");
            System.out.println(
                        "\n1 - Single inventory item" +
                        "\n2 - All inventory items" +
                        "\n0 - Exit putting item");

            Actions.typeChoice();

            try {

                if (place.hasNextInt())
                    itemIndex = place.nextInt();
                else
                    place.close();

                if (itemIndex == 1) {
                    item = PlayerActions.takeItemFromInventory(player.getInventory());

                    if (item != null) {
                        System.out.println(
                                "\nYou remove the " + item.getName() + " from " +
                                "\nyour inventory and place it into the\n" + container.getName());

                        container.addToInventory(item);
                        player.removeFromInventory(item);
                    }
                }
                else if (itemIndex == 2) {
                    System.out.println(
                                    "\nYou place all your items" +
                                    "\ninto the " + container.getName());

                    container.addToInventory(playerInventory);
                    player.removeFromInventory(playerInventory);
                }
            }
            catch (InputMismatchException e) {
                System.out.println("\nInvalid input.");
            }
        }
        else if (containerIndex == 0)
            System.out.println("\nYou left the " + container.getName());
        else
            System.out.println("\nInvalid choice.");
    }
}
