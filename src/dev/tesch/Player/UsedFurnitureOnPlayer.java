package dev.tesch.Player;

import dev.tesch.Actions.Actions;
import dev.tesch.Actions.ItemActions;
import dev.tesch.Actions.PlayerActions;
import dev.tesch.Crafting.Recipe;
import dev.tesch.Furniture.Container;
import dev.tesch.Furniture.Furniture;
import dev.tesch.Items.Item;
import dev.tesch.NPCs.NPC;
import dev.tesch.Rooms.Room;

import java.util.*;

public class UsedFurnitureOnPlayer {

    public static void useFurniture(Player player) {
        Furniture furniture = player.getRoomIsIn().getFurnitureInRoom();
        switch (furniture.getName()) {
            case "Camping chair":
                usedCampingChair(player);
                break;

            case "Sean's Bed":
                usedSeansBed(player);
                break;

            case "Jeff's Bed":
                usedJeffsBed(player);
                break;

            case "Crafting Table":
                useCraftingTable(player);
                break;

            case "Chest":
                useChest(player, (Container) furniture);
                break;

            default:
                System.out.println("\nThis doesn't seem to help you");
        }
    }

    private static void usedCampingChair(Player player) {
        System.out.println("\nYour health has been restored.");
        player.setCurrentHealth(player.getMaximumHealth());
    }

    private static void usedSeansBed(Player player) {
        NPC npc;
        Room room = player.getRoomIsIn();

        if (room.isHasNPC()) {
            npc = room.getNpcInRoom();

            if (npc.getName().equals("Claudia")) {
                System.out.println(
                                "\nYou and Claudia snuggle <3" +
                                "\nYour max health increases by 50" +
                                "\nand your health has been restored.");
                player.setMaximumHealth(player.getMaximumHealth() + 50);
                player.setCurrentHealth(player.getMaximumHealth());
            }
        }
        else {
            System.out.println("\nYour max health increases by 25");
            player.setMaximumHealth(player.getMaximumHealth() + 25);
        }
    }

    private static void usedJeffsBed(Player player) {
        NPC npc;
        Room room = player.getRoomIsIn();

        if (room.isHasNPC()) {
            npc = room.getNpcInRoom();

            if (npc.getName().equals("Jeff")) {
                System.out.println(
                                "\nJeff bites your face in your sleep." +
                                "\nYou lose 25 health.");
                player.setCurrentHealth(player.getCurrentHealth() - 25);
            }
        } else {
            System.out.println("\nYour max health increases by 25");
            player.setMaximumHealth(player.getMaximumHealth() + 25);
        }
    }

    private static void useCraftingTable(Player player) {
        List<Item> craftingItems = new LinkedList<>();
        Item craftedItem;
        List<Item> inventory = player.getInventory();
        List<Recipe> recipes = player.getKnownRecipes();

        if (!inventory.isEmpty() && !recipes.isEmpty()) {

            Scanner craftChoice = new Scanner(System.in);
            int craftIndex = -1;
            int i = 0;

            System.out.println("\nWhat would you like to craft?");
            for (Recipe r: recipes) {
                System.out.println(i++ + " - " + r.getOutputItem().getName());
            }
            Actions.typeChoice();

            if (craftChoice.hasNextInt())
                craftIndex = craftChoice.nextInt();
            else
                craftChoice.close();

            Recipe recipe = recipes.get(craftIndex);
            if (recipe.canCraft(inventory)) {

                craftingItems.addAll(recipe.getInputItems());
                craftedItem = recipe.getOutputItem();

                for (Item it : craftingItems) {
                    System.out.println(it.getUseMessage());
                }

                inventory.removeAll(craftingItems);
                inventory.add(craftedItem);
                craftingItems.removeAll(recipe.getInputItems());
            }
            else
                System.out.println("\nYou don't have the required materials.");
        }
        else {
            System.out.println("\nYou have nothing to craft with.");
        }
    }

    private static void useChest(Player player, Container container) {

        System.out.println("\nHow do you want to use the chest?");
        System.out.println(
                        "\n0 - View " + container.getName() + "'s inventory" +
                        "\n1 - Take item from" +
                        "\n2 - Put item into");
        
        List<Item> containerInventory = container.getContainerInventory();
        Scanner chestChoice = new Scanner(System.in);
        int chestIndex = -1;

        Actions.typeChoice();

        if (chestChoice.hasNextInt())
            chestIndex = chestChoice.nextInt();
        else
            chestChoice.close();

        if (chestIndex == 0) {
            int i = 0;
            System.out.println("\nInside the " + container.getName() + " you see:\n");
            for (Item it: containerInventory) {
                System.out.println(i++ + " " + it.getName());
            }
        }

        if (chestIndex == 1) {
            System.out.println("\nWhat would you like to take: \n");
            Scanner take = new Scanner(System.in);
            int i = 0;
            int itemIndex = -1;
            Item item;
            for (Item it: containerInventory) {
                System.out.println(i++ + " " + it.getName());
            }
            Actions.typeChoice();

            try {
                if (take.hasNext())
                    itemIndex = take.nextInt();
                else
                    take.close();

                item = containerInventory.get(itemIndex);

                System.out.println("\nYou take the " + item.getName());
                player.addToInventory(item);
                container.removeFromInventory(item);
            }
            catch (InputMismatchException e) {
                System.out.println("\nInvalid input.");
            }
        }
        else if (chestIndex == 2) {
            Item item  = PlayerActions.takeItemFromInventory(player);

            System.out.println(
                            "\nYou remove the " + item.getName() + " from " +
                            "\nyour inventory and place it into the\n" + container.getName());

            container.addToInventory(item);
            player.getInventory().remove(item);
        }
    }
}
