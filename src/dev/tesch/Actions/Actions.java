package dev.tesch.Actions;

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
        actionsMap.put(0, Arrays.asList(new String[] {"q", "quit", "e", "exit"}));
    }

    // Various messages that will print to the user based oin their choices
    // TODO: add more messages and more functionality
    public static void welcome() {
        System.out.println("\nWelcome to my Adventure Game!\nThis is still a WIP.\n");
    }

    public static void typeChoice() {
        System.out.println("\nType your choice:");
    }

    public static void inventory() {
        System.out.println("\nNo inventory yet.\n");
    }

    public static void help() {
        System.out.println("\nThis is the help screen\n\nq, e, quit, or exit to quit the game\n");
    }

    public static void exitMessage() {
        System.out.println("\nNow exiting the game. Goodbye.");
    }

    public static void error() {
        System.out.println("\nError. Not a valid input.\nTry again.\n");
    }

}
