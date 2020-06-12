package dev.tesch.Actions;

import dev.tesch.Rooms.Room;

import java.util.*;

// Class for the various actions
public class Actions {

    // HashMap used for storing Lists of different actions that a user might type as values
    // and assigning them to an Integer key for easier and prettier parsing
    public static Map<Integer, List<String>> actionsMap = new HashMap<>();

    // Constructing the different actions that will be used
    // TODO: add more actions to this HashMap
    public Actions() {
        actionsMap.put(1, Arrays.asList(new String[] {"i", "inventory"}));
        actionsMap.put(2, Arrays.asList(new String[] {"h", "help"}));
        actionsMap.put(3, Arrays.asList(new String[] {"l", "location"}));
        actionsMap.put(4, Arrays.asList(new String[] {"m", "move", "g", "go"}));
        actionsMap.put(0, Arrays.asList(new String[] {"q", "quit", "e", "exit"}));
    }

    // Various messages that will print to the user based oin their choices
    // TODO: add more messages and more functionality
    public static void welcome() {
        System.out.println("\nWelcome to my Adventure Game!" +
                            "\nThis is still a WIP." +
                            "\n(Type 'h' or 'help' for help menu)\n");
    }

    // Generic type choice message
    public static void typeChoice() {
        System.out.println("\nType your choice:");
    }

    // Method to display your inventory, so far no implementation
    // TODO: When I implement items, work on inventory system
    public static void inventory() {
        System.out.println("\nNo inventory yet.\n");
    }

    public static void help() {
        System.out.println("\nThis is the help screen\n");

        System.out.println("Actions the you have access to:");
        for (Map.Entry<Integer, List<String>> entry: actionsMap.entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println("\n");
    }

    // Method to display which room you're in
    public static void printLocation(Integer roomIndex, Map<Integer, Room> userRooms) {
        System.out.println("You are in " + userRooms.get(roomIndex).getName() + "\n");
    }

    // Method used to change rooms
    public static int move(Map<Integer, Room> userRooms, Integer roomIndex) {
        String[] directions = {"N", "E", "S", "W"};
        String moveDirection;
        Room currentRoom = userRooms.get(roomIndex);
        int[] currentRoomMoves = currentRoom.getMoves();
        int[] connectedRooms = currentRoom.getConnectedRooms();

        // Gets user choice
        System.out.println("\nWhich direction would you like to go?\n(N S E W)\n");
        Scanner moveAction = new Scanner(System.in);
        moveDirection = moveAction.nextLine().toUpperCase();

        // Checks which direction you want to move and if you can move there
        for (int i = 0; i < directions.length; i++) {
            // If you can move there, prints which room you're leaving and returns
            // the index to the new room you are entering
            if (moveDirection.equals(directions[i]) && currentRoomMoves[i] == 1) {
                System.out.println("You went " + moveDirection + "\n");
                currentRoom.getLeaveMessage();
                userRooms.get(connectedRooms[i]).getEnterMessage();
                return connectedRooms[i];
            }
        }

        // If you can't move, tells you so, and returns the current room index
        System.out.println("\nCouldn't move that way.\n");
        return roomIndex;
    }

    // Method used to display exit message
    public static void exitMessage() {
        System.out.println("\nNow exiting the game. Goodbye.");
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
