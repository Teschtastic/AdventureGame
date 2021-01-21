package dev.tesch.Player;

import dev.tesch.Actions.Actions;
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
            Room room,
            Map<Integer, Item> userItems,
            Map<Integer, Armor> userArmors,
            Map<Integer, Weapon> userWeapons) {

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
                useCraftingTable(player, userItems, userArmors, userWeapons);
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
                System.out.println("\nYour max health increases by 50\nand your health has been restored.");
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
                System.out.println("\nJeff bites you face in your sleep.\nYou lose 25 health.");
                player.setCurrentHealth(player.getCurrentHealth() - 25);
            }
        } else {
            System.out.println("\nYour max health increases by 25");
            player.setMaximumHealth(player.getMaximumHealth() + 25);
        }
    }

    // TODO: Make a recipe object or something to reduce the method signature and limit the use of all the maps throughout the program
    // FIXME: The crafting system has broken, need to look into this
    private static void useCraftingTable(Player player, Map<Integer, Item> userItems, Map<Integer, Armor> userArmors, Map<Integer, Weapon> userWeapons) {
        List<Item> craftingItems = new LinkedList<>();
        Item craftedItem;
        List<Item> inventory = player.getInventory();

        if (!inventory.isEmpty()) {
            if (inventory.contains(userItems.get(2))) {
                craftingItems.add(0, userItems.get(2));
                craftedItem = userArmors.get(1);

                System.out.println(craftingItems.get(0).getUseMessage());
                inventory.remove(craftingItems.get(0));
                inventory.add(craftedItem);
            }
            if (inventory.containsAll(Arrays.asList(userItems.get(4), userItems.get(5)))) {
                craftingItems.add(0, userItems.get(4));
                craftingItems.add(1, userItems.get(5));
                craftedItem = userWeapons.get(1);

                System.out.println(craftingItems.get(0).getUseMessage());
                System.out.println(craftingItems.get(1).getUseMessage());

                inventory.remove(craftingItems.get(0));
                inventory.remove(craftingItems.get(1));
                inventory.add(craftedItem);
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
        catch (UnsupportedOperationException e) {
            System.out.println("Didn't work lol");
        }
        catch (InputMismatchException e) {
            System.out.println("\n Invalid input.");
        }


    }
}
