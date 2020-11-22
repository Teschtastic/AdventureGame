package dev.tesch.Player;

import dev.tesch.Furniture.Furniture;
import dev.tesch.Items.Armor;
import dev.tesch.Items.Item;
import dev.tesch.NPCs.NPC;
import dev.tesch.Rooms.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UsedFurnitureOnPlayer {

    public static void useFurniture(Player player, Furniture furniture, Map<Integer, Room> userRooms, Map<Integer, Item> userItems, Map<Integer, Armor> userArmors, Map<Integer, NPC> userNPCs) {
        switch (furniture.getName()) {
            case "Camping chair":
                usedCampingChair(player);
                break;

            case "Bed":
                usedBed(player, userRooms, userNPCs);
                break;

            case "Crafting Table":
                useCraftingTable(player, userItems, userArmors);
                break;

            default:
                System.out.println("\nThis doesn't seem to help you");
        }
    }

    private static void usedCampingChair(Player player) {
        System.out.println("\nYour health has been restored.");
        player.setCurrentHealth(player.getMaximumHealth());
    }

    private static void usedBed(Player player, Map<Integer, Room> userRooms, Map<Integer, NPC> userNPCs) {
        Room room = userRooms.get(player.getRoomIsIn());
        NPC npc = null;

        if (room.isHasNPC()) {
            npc = userNPCs.get(room.getNpcInRoom());

            if (npc.getName().equals("Claudia")) {
                System.out.println("\nYour max health increases by 50\nand your health has been restored.");
                player.setMaximumHealth(player.getMaximumHealth() + 50);
                player.setCurrentHealth(player.getMaximumHealth());
            }
        }
        else if (!room.isHasNPC() || npc == null) {
            System.out.println("\nYour max health increases by 25");
            player.setMaximumHealth(player.getMaximumHealth() + 25);
        }
    }

    private static void useCraftingTable(Player player, Map<Integer, Item> userItems, Map<Integer, Armor> userArmors) {
        List<Item> craftingItems = new ArrayList<>();
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
            if (inventory.containsAll(Arrays.asList(new Item[]{userItems.get(4), userItems.get(5)}))) {
                craftingItems.add(0, userItems.get(4));
                craftingItems.add(1, userItems.get(5));
                craftedItem = userItems.get(6);

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
}
