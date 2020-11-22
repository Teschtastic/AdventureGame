package dev.tesch.Actions;

import dev.tesch.Furniture.Furniture;
import dev.tesch.Items.Armor;
import dev.tesch.Items.Item;
import dev.tesch.NPCs.NPC;
import dev.tesch.Player.Player;
import dev.tesch.Rooms.Room;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PlayerActions {

    /* Method to display your inventory, so far no implementation */
    // TODO: When I implement items, work on inventory system
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
    public static void useSomething(Player player, Map<Integer, Room> userRooms, Map<Integer, Item> userItems, Map<Integer, Armor> userArmors, Map<Integer, NPC> userNPCs, Map<Integer, Furniture> userFurnitures) {
        Scanner useIn = new Scanner(System.in);
        int useChoice;

        System.out.print("\nWhat would you like to use?\n\n0 - Item in inventory\n1 - Item in room\n2 - Furniture in room\n");
        Actions.typeChoice();

        try {
            useChoice = useIn.nextInt();

            if (useChoice == 0)
                ItemActions.useInventoryItem(player);
            else if (useChoice == 1)
                RoomActions.useItemInRoom(player, userRooms, userItems);
            else if (useChoice == 2)
                FurnitureActions.useFurniture(player, userRooms, userNPCs, userItems, userArmors, userFurnitures);
            else
                System.out.println("\nInvalid choice.");
        } catch (InputMismatchException e) {
            System.out.println("\nInvalid input.");
        }
    }
}
