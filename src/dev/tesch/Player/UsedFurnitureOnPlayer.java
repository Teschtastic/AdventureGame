package dev.tesch.Player;

import dev.tesch.Actions.Actions;
import dev.tesch.Crafting.Recipe;
import dev.tesch.Crafting.Recipes;
import dev.tesch.Furniture.Container;
import dev.tesch.Furniture.Furniture;
import dev.tesch.Items.Armor;
import dev.tesch.Items.Item;
import dev.tesch.Items.Weapon;
import dev.tesch.NPCs.NPC;
import dev.tesch.Rooms.Room;

import java.util.*;

public class UsedFurnitureOnPlayer {

    public static void useFurniture(
            Player player,
            Furniture furniture,
            Room room) {

        switch (furniture.getName()) {
            case "Camping chair":
                usedCampingChair(player);
                break;

            case "Sean's Bed":
                usedSeansBed(player, room);
                break;

            case "Jeff's Bed":
                usedJeffsBed(player, room);
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

    private static void usedSeansBed(Player player, Room room) {
        NPC npc;

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

    private static void usedJeffsBed(Player player, Room room) {
        NPC npc;

        if (room.isHasNPC()) {
            npc = room.getNpcInRoom();

            if (npc.getName().equals("Jeff")) {
                System.out.println(
                                "\nJeff bites you face in your sleep." +
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

        if (!inventory.isEmpty()) {
            if (recipes.get(0).canCraft(inventory)) {
                Recipe recipe = recipes.get(0);

                craftingItems.addAll(recipe.getInputItems());
                craftedItem = recipe.getOutputItem();

                for (Item it: craftingItems) {
                    System.out.println(it.getUseMessage());
                }

                inventory.removeAll(craftingItems);
                inventory.add(craftedItem);
                craftingItems.removeAll(recipe.getInputItems());
            }
            if (recipes.get(1).canCraft(inventory)) {
                Recipe recipe = recipes.get(1);
                craftingItems.addAll(recipe.getInputItems());
                craftedItem = recipe.getOutputItem();

                for (Item it: craftingItems) {
                    System.out.println(it.getUseMessage());
                }

                inventory.removeAll(craftingItems);
                inventory.add(craftedItem);
                craftingItems.removeAll(recipe.getInputItems());
            }
        }
        else {
            System.out.println("\nYou have nothing to craft with.");
        }
    }

    private static void useChest(Player player, Container container) {
        System.out.println("What would you like to take: \n");
        Scanner take = new Scanner(System.in);
        List<Item> containerInventory = container.getContainerInventory();
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
}
