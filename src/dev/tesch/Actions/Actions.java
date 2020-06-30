package dev.tesch.Actions;

import dev.tesch.Items.Item;
import dev.tesch.NPCs.NPC;
import dev.tesch.Player.Player;
import dev.tesch.Rooms.Room;

import java.util.*;
// TODO: Potentially split this file into multiple parts based off of
//  which type of action is being performed, such as for items, rooms,
//  or NPCs to improve readability and make it easier to add new actions
public class Actions {

    /* HashMap used for storing Lists of different actions that a user might type as values
       and assigning them to an Integer key for easier and prettier parsing */
    public Map<Integer, List<String>> actionsMap = new HashMap<>();

    /* Constructing the different actions that will be used */
    // TODO: add more actions to this HashMap
    public Actions() {
        actionsMap.put(1, Arrays.asList("i", "inventory"));
        actionsMap.put(2, Arrays.asList("h", "help"));
        actionsMap.put(3, Arrays.asList("w", "where"));
        actionsMap.put(4, Arrays.asList("m", "move", "g", "go"));
        actionsMap.put(5, Arrays.asList("v", "view", "l", "look"));
        actionsMap.put(6, Arrays.asList("p", "pickup", "g", "grab"));
        actionsMap.put(7, Arrays.asList("de", "describe"));
        actionsMap.put(8, Arrays.asList("dr", "drop", "t", "toss"));
        actionsMap.put(9, Arrays.asList("u", "use"));
        actionsMap.put(10, Arrays.asList("t", "talk", "s", "speak"));
        actionsMap.put(0, Arrays.asList("q", "quit", "e", "exit"));
    }

    /* Various messages that will print to the user based oin their choices */
    // TODO: add more messages and more functionality
    public static void welcome() {
        System.out.println("+------------------------------------+" +
                         "\n| Welcome to my Adventure Game!      |" +
                         "\n| This is still a WIP.               |" +
                         "\n| (Type 'h' or 'help' for help menu) |" +
                         "\n+------------------------------------+\n");
    }

    /* Generic type choice message */
    public static void typeChoice() {
        System.out.print("\n--------------------------------------\nType your choice:\n> ");
    }

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
        System.out.println("\n/* ~ This is the help screen ~ */\nActions the you have access to:");
        for (Map.Entry<Integer, List<String>> entry: userActions.entrySet()) {
            System.out.println(" " + entry.getValue());
        }
    }

    /* Method to display which room you're in */
    public static void printLocation(Integer roomIndex, Map<Integer, Room> userRooms) {
        userRooms.get(roomIndex).getInMessage();
    }

    /* Method used to change rooms */
    public static int move(Map<Integer, Room> userRooms, Integer roomIndex) {
        String[] directions = {"N", "E", "S", "W"};
        String moveDirection;
        Room currentRoom = userRooms.get(roomIndex);
        int[] currentRoomMoves = currentRoom.getMoves();
        int[] connectedRooms = currentRoom.getConnectedRooms();

        // Gets user choice
        System.out.print("\nWhich direction would you like to go?\n[N, S, E, W]:\n> ");
        Scanner moveAction = new Scanner(System.in);
        moveDirection = moveAction.nextLine().toUpperCase();

        // Checks which direction you want to move and if you can move there
        for (int i = 0; i < directions.length; i++) {
            // If you can move there, prints which room you're leaving and returns
            // the index to the new room you are entering
            if (moveDirection.equals(directions[i]) && currentRoomMoves[i] == 1) {
                System.out.println("\nYou went " + moveDirection + "\n");
                currentRoom.getLeaveMessage();
                userRooms.get(connectedRooms[i]).getEnterMessage();
                return connectedRooms[i];
            }
        }

        // If you can't move, tells you so, and returns the current room index
        System.out.println("\nCouldn't move that way.");
        return roomIndex;
    }

    /* Method used to look in the room you're in */
    public static void lookAround(Map<Integer, NPC> userNpcs, Map<Integer, Room> userRooms, Integer roomIndex, Map<Integer, Item> userItems) {
        Room room = userRooms.get(roomIndex);

        if (!room.isHasNPC()) {
            System.out.println("\nYou don't see any people.");
        } else {
            NPC npc = userNpcs.get(room.getNpcInRoom());
            System.out.println("\nYou see " + npc.getName());
        }

        if (!room.isHasItem())
            System.out.println("\nYou don't see any items.");
        else {
            Item item = userItems.get(room.getItemInRoom());
            System.out.println("\nYou see a " + item.getName());
        }
    }

    /* Method used for attempting to pickup an item */
    public static void pickupItem(Map<Integer, Room> userRooms, Integer roomIndex, Map<Integer, Item> userItems, Player player) {
        Room room = userRooms.get(roomIndex);

        // If there isn't an item in the room, nothing to pickup
        if (!room.isHasItem())
            System.out.println("\nThere is no item to pickup.");
        // This means there is something in the room
        else {
            Item item = userItems.get(room.getItemInRoom());
            // The item is able to be picked up, so remove it from the room and remove the room tag for the item
            // then add the item to the players inventory
            if (item.getCanPickup()) {
                System.out.println("\nYou pickup a " + item.getName());
                room.setItemInRoom(-1);
                room.setHasItem(false);
                item.setRoomLocation(-1);
                player.addToInventory(item);
            }
            // Otherwise, the item isn't able to be picked up
            else
                System.out.println("\nYou can't pickup the " + item.getName());
        }
    }

    /* Method used to describe an item in your inventory */
    // TODO: Add functionality to describe items that you can't pickup and
    //  therefore aren't in the player's inventory
    public static void describeItem(List<Item> inventory) {
        if (inventory.size() == 0)
            System.out.println("\nThere is nothing in your inventory to describe.");
        else if (inventory.size() == 1)
            System.out.println("\nYou inspect your " + inventory.get(0).getName() +
                                "\nYou describe it as:\n" + inventory.get(0).getDescription());
        else {
            int i = 0;
            int size = inventory.size() - 1;
            Scanner itemDesc = new Scanner(System.in);
            int itemChoice;

            System.out.println("\nYour inventory contains:");
            for (Item it : inventory)
                System.out.println(i++ + " " + it.getName());

            System.out.print("\nWhich item would you like to inspect?\n(0 - " + size + ")\n>");
            itemChoice = itemDesc.nextInt();

            if (itemChoice >= 0 && itemChoice <= size)
                System.out.println("\nYou inspect your " + inventory.get(itemChoice).getName() +
                                    "\nYou describe it as:\n" + inventory.get(itemChoice).getDescription());
            else
                System.out.println("\nInvalid item, try again.");
        }
    }

    /* Method used to drop and item in your inventory */
    public static void dropItem(Map<Integer, Room> userRooms, Integer roomIndex, Player player) {

        Room room = userRooms.get(roomIndex);
        Item item;

        // Nothing in inventory to drop
        if (player.getInventory().size() == 0)
            System.out.println("\nThere is nothing in your inventory to drop.");
        // Only one item in your inventory to drop
        else if (room.isHasItem() && player.getInventory().size() > 0)
            System.out.println("\nYou cannot drop the item.\nThe room already has an item in it.");
        else if (player.getInventory().size() == 1) {
            item = player.getInventory().get(0);

            System.out.println("\nYou drop your " + item.getName());

            room.setHasItem(true);
            item.setRoomLocation(roomIndex);
            room.setItemInRoom(item.getItemIndex());
            player.getInventory().remove(0);
        }
        // Multiple items in inventory, choose which one to drop
        else {
            int i = 0;
            int size = player.getInventory().size() - 1;
            Scanner itemDesc = new Scanner(System.in);
            int itemChoice;

            System.out.println("\nYour inventory contains:");
            for (Item it : player.getInventory())
                System.out.println(i++ + " " + it.getName());

            System.out.print("\nWhich item would you like to drop?\n(0 - " + size + ")\n>");
            itemChoice = itemDesc.nextInt();

            if (itemChoice >= 0 && itemChoice <= size) {
                item = player.getInventory().get(itemChoice);
                System.out.println("\nYou drop your " + item.getName());
                room.setHasItem(true);
                item.setRoomLocation(roomIndex);
                room.setItemInRoom(item.getItemIndex());
                player.getInventory().remove(itemChoice);
            }
            else
                System.out.println("\nInvalid item, try again.");
        }
    }

    public static void useItem(Map<Integer, Room> userRooms, Integer roomIndex, Player player) {
        Room room = userRooms.get(roomIndex);
        Item item;

        // Nothing in inventory to use
        if (player.getInventory().size() == 0)
            System.out.println("\nThere is nothing in your inventory to use.");
            // Only one item in your inventory to use
        else if (player.getInventory().size() == 1) {
            item = player.getInventory().get(0);

            // If the item has the can use flag, use it and remove
            // it from the player's inventory
            if (player.getInventory().get(0).isCanUse()) {
                System.out.println(item.getUseMessage());
                player.getInventory().remove(0);
            }
            else
                System.out.println("\nYou can't use " + item.getName());
        }
        // Multiple items in inventory, choose which one to use
        else {
            int i = 0;
            int size = player.getInventory().size() - 1;
            Scanner itemDesc = new Scanner(System.in);
            int itemChoice;

            // Prints the inventory for the user
            System.out.println("\nYour inventory contains:");
            for (Item it : player.getInventory())
                System.out.println(i++ + " " + it.getName());

            // Choice as to which item to use
            System.out.print("\nWhich item would you like to use?\n(0 - " + size + ")\n>");
            itemChoice = itemDesc.nextInt();


            if (itemChoice >= 0 && itemChoice <= size) {
                item = player.getInventory().get(itemChoice);

                if (player.getInventory().get(itemChoice).isCanUse()) {

                    System.out.println(item.getUseMessage());

                    player.getInventory().remove(itemChoice);
                }
                else
                    System.out.println("\nYou can't use " + item.getName());
            }
            else
                System.out.println("\nInvalid item, try again.");
        }
    }

    public static void talkToNPC(Map<Integer, NPC> userNpcs, Map<Integer, Room> userRooms, int roomIndex) {
        Room room = userRooms.get(roomIndex);
        NPC npc = userNpcs.get(room.getNpcInRoom());

        if (!room.isHasNPC()) {
            System.out.println("\nThere is nobody to talk to.");
        } else {
            System.out.println("\n" + npc.getName() + " says \"" + npc.getMessage() + "\"");
        }
    }

    /* Method used to display exit message */
    public static void exitMessage() {
        System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                             "@        Thank you for playing       @\n" +
                             "@        Now exiting the game        @\n" +
                             "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.exit(0);
    }

    /* Method used to display user input error */
    public static void inputError() {
        System.out.println("\nError. Not a valid input.\nTry again.\n");
    }

    /* Method used to display a generic error */
    public static void genericError() {
        System.out.println("\nError.\n");
    }
}
