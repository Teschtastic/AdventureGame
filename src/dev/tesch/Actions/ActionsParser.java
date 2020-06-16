package dev.tesch.Actions;

import dev.tesch.Items.Item;
import dev.tesch.Player.Player;
import dev.tesch.Rooms.Room;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static dev.tesch.Actions.Actions.*;

public class ActionsParser {

    public static void parseActions(Map<Integer, List<String>> userActions, Map<Integer, Room> userRooms, Map<Integer, Item> userItems, Player player) {
        // Scanners for player choices
        Scanner playerAction = new Scanner(System.in);

        // Var used in player choice
        String choice;

        // Var used to keep track of the room index
        Integer roomIndex = 1;

        // Welcome message
        Actions.welcome();

        // Tells you which room you're in
        userRooms.get(roomIndex).getStartMessage();

        // Main game loop
        // TODO: Make output look prettier
        while(true) {
            Integer choiceIndex = null;

            // Scans the System.in for the next user choice
            Actions.typeChoice();
            choice = playerAction.nextLine();

            // Checks to see if the user choice is defined in the actions scope, then assigns it to an Integer
            for (Map.Entry<Integer, List<String>> entry: userActions.entrySet()) {
                if (entry.getValue().contains(choice.toLowerCase())) {
                    choiceIndex = entry.getKey();
                }
            }

            // If there was no action for the choice given, set to error choice
            if (choiceIndex == null)
                choiceIndex = -1;

            // Switch case to parse the user's choice
            switch (choiceIndex) {
                case 1:
                    // Accesses the inventory
                    inventory(player);
                    break;

                case 2:
                    // Accesses the help menu
                    help(userActions);
                    break;

                case 3:
                    // Prints your location
                    printLocation(roomIndex, userRooms);
                    break;

                case 4:
                    // Moves into a new room
                    roomIndex = move(userRooms, roomIndex);
                    break;

                case 5:
                    // Looks around the room
                    lookAround(userRooms, roomIndex, userItems);
                    break;

                case 6:
                    // Attempts to pickup an item
                    pickupItem(userRooms, roomIndex, userItems, player);
                    break;

                case 7:
                    // Describes an item in your inventory
                    describeItem(player.getInventory());
                    break;

                case 0:
                    // Quits the game
                    exitMessage();
                    return;

                case -1:
                    // Input error
                    inputError();
                    break;

                default:
                    // Outputs a generic invalid choice message to the user
                    genericError();
                    break;
            }
        }
    }
}
