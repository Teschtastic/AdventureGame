package dev.tesch.Actions;

import dev.tesch.Items.Item;
import dev.tesch.Player.Player;

import java.util.List;
import java.util.Map;

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
        System.out.println("\n/* ~ This is the help screen ~ */\nActions the you have access to:");
        for (Map.Entry<Integer, List<String>> entry: userActions.entrySet()) {
            System.out.println(" " + entry.getValue());
        }
    }


}
