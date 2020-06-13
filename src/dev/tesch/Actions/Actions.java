package dev.tesch.Actions;

import dev.tesch.Items.Item;
import dev.tesch.Rooms.Room;

import java.util.*;

// Class for the various actions
public class Actions {

    // HashMap used for storing Lists of different actions that a user might type as values
    // and assigning them to an Integer key for easier and prettier parsing
    public Map<Integer, List<String>> actionsMap = new HashMap<>();

    // Constructing the different actions that will be used
    // TODO: add more actions to this HashMap
    public Actions() {
        actionsMap.put(1, Arrays.asList("i", "inventory"));
        actionsMap.put(2, Arrays.asList("h", "help"));
        actionsMap.put(3, Arrays.asList("w", "where"));
        actionsMap.put(4, Arrays.asList("m", "move", "g", "go"));
        actionsMap.put(5, Arrays.asList("v", "view", "l", "look"));
        actionsMap.put(0, Arrays.asList("q", "quit", "e", "exit"));
    }

    // Various messages that will print to the user based oin their choices
    // TODO: add more messages and more functionality
    public static void welcome() {
        System.out.println("+------------------------------------+" +
                         "\n| Welcome to my Adventure Game!      |" +
                         "\n| This is still a WIP.               |" +
                         "\n| (Type 'h' or 'help' for help menu) |" +
                         "\n+------------------------------------+\n");
    }

    // Generic type choice message
    public static void typeChoice() {
        System.out.print("\nType your choice:\n> ");
    }

    // Method to display your inventory, so far no implementation
    // TODO: When I implement items, work on inventory system
    public static void inventory(List<Item> inventory) {
        if (inventory.isEmpty())
            System.out.println("\nYour inventory is empty.");
    }

    public static void help(Map<Integer, List<String>> userActions) {
        System.out.println("\n/* ~ This is the help screen ~ */\n");

        System.out.println("Actions the you have access to:");
        for (Map.Entry<Integer, List<String>> entry: userActions.entrySet()) {
            System.out.println(" " + entry.getValue());
        }
    }

    // Method to display which room you're in
    public static void printLocation(Integer roomIndex, Map<Integer, Room> userRooms) {
        userRooms.get(roomIndex).getInMessage();
    }

    // Method used to change rooms
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
        System.out.println("\nCouldn't move that way.\n");
        return roomIndex;
    }

    // Method used to look in the room you're in
    public static void lookAround(Map<Integer, Room> userRooms, Integer roomIndex, Map<Integer, Item> userItems) {
        Room room = userRooms.get(roomIndex);

        if (!room.isHasItem())
            System.out.println("\nYou look around and see nothing.");
        else {
            Item item = userItems.get(room.getItemInRoom());
            System.out.println("\nYou see a " + item.getName());
        }
    }

    // Method used to display exit message
    public static void exitMessage() {
        System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                           "@  Thank you for playing  @\n" +
                           "@  Now exiting the game   @\n" +
                           "@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

    // Method used to display user input error
    public static void inputError() {
        System.out.println("\nError. Not a valid input.\nTry again.\n");
    }

    // Method used to display a generic error
    public static void genericError() {
        System.out.println("\nError.\n");
    }
}
