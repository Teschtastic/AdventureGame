package dev.tesch.Actions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Actions {

    /* HashMap used for storing Lists of different actions that a user might type as values
       and assigning them to an Integer key for easier and prettier parsing */
    public Map<Integer, List<String>> actionsMap = new HashMap<>();

    /* Constructing the different actions that will be used */
    // TODO: add more actions to this HashMap
    public Actions() {
        actionsMap.put(1, Arrays.asList("i", "inventory"));
        actionsMap.put(2, Arrays.asList("h", "help"));
        actionsMap.put(3, Arrays.asList("wh", "where"));
        actionsMap.put(4, Arrays.asList("n", "e", "s", "w", "N", "E", "S", "W"));
        actionsMap.put(5, Arrays.asList("v", "view", "l", "look"));
        actionsMap.put(6, Arrays.asList("p", "pickup", "g", "grab"));
        actionsMap.put(7, Arrays.asList("de", "describe"));
        actionsMap.put(8, Arrays.asList("dr", "drop", "to", "toss"));
        actionsMap.put(9, Arrays.asList("u", "use"));
        actionsMap.put(10, Arrays.asList("t", "talk"));
        actionsMap.put(11, Arrays.asList("g", "give"));
        actionsMap.put(12, Arrays.asList("ta", "take"));
        actionsMap.put(0, Arrays.asList("q", "quit"));
    }

    /* Various messages that will print to the user based oin their choices */
    // TODO: add more messages and more functionality
    public static void welcome() {
        System.out.println("+------------------------------------+" +
                         "\n| Welcome to my Adventure Game!      |" +
                         "\n| This is still a WIP.               |" +
                         "\n| You can move N, E, S, or W         |" +
                         "\n| (Type 'h' or 'help' for help menu) |" +
                         "\n+------------------------------------+\n");
    }

    /* Generic type choice message */
    public static void typeChoice() {
        System.out.print("\n--------------------------------------\nType your choice:\n> ");
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
